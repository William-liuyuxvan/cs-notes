package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.*;
import static com.hmdp.utils.SystemConstants.USER_NICK_NAME_PREFIX;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result sendCode(String phone, HttpSession session) {
        // 1. 校验手机号格式
        if (RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("无效手机号");
        }

        // 2. 生成验证码
        String code = RandomUtil.randomNumbers(6);

        // 3. 保存验证码到redis中
//        session.setAttribute("code", code);
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);

        // 4. 发送验证码
        log.debug("发送短信验证码成功，验证码: {}", code);

        return Result.ok();
    }

    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        // 1. 校验手机号
        String phone = loginForm.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)) {
            // 1.1 手机号格式错误  返回
            return Result.fail("无效手机号");
        }

        // 2. 校验验证码
        String code = loginForm.getCode();
        // TODO 2.1 从redis中获取验证码
//        Object cacheCode = session.getAttribute("code");
        String cacheCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY + phone);
        assert cacheCode != null;
        if (!cacheCode.equals(code)) {
            // 2.1 验证码为空或验证码错误  返回
            return Result.fail("验证码错误");
        }

        // 3. 根据手机号查询用户
        User user = query().eq("phone", phone).one();

        // 4. 用户是否存在
        if (user == null) {
            // 5. 不存在  创建新用户
            user = createUserWithPhone(phone);
        }

//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setIcon(user.getIcon());
//        userDTO.setNickName(user.getNickName());

        // 6. 保存用户到redis
        // 6.1 生成TOKEN，唯一值标识
        String token = UUID.randomUUID().toString(true);

        // 6.2 保存到redis中
//        session.setAttribute("user", BeanUtil.copyProperties(user, UserDTO.class));
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO, new HashMap<>(),
                CopyOptions.create()
                        .setIgnoreNullValue(true)
                        .setFieldValueEditor((fieldName, fieldValue) -> fieldValue.toString()));
        String key = LOGIN_USER_KEY + token;
        stringRedisTemplate.opsForHash().putAll(key, userMap);

        // 6.3 设置有效期
        stringRedisTemplate.expire(key, LOGIN_USER_TTL, TimeUnit.MINUTES);



        log.debug("用户登录成功: {}", userDTO);
        // 7 返回TOKEN到客户端

        return Result.ok(token);
    }

    private User createUserWithPhone(String phone) {
        // 1. 创建新用户
        User user = new User();
        user.setPhone(phone);
        user.setNickName(USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));

        // 2. 保存用户
        save(user);
        return user;
    }
}
