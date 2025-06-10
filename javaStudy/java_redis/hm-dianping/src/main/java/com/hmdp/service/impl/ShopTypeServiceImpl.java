package com.hmdp.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryList() {
        String key = "cache:shop_type";
        // 1. 查询缓存
        String typeList = stringRedisTemplate.opsForValue().get(key);

        // 2. 查询是否存在
        if (StrUtil.isNotBlank(typeList)) {
            // 3. 存在，返回
            List<ShopType> shopTypes = JSONUtil.toList(typeList, ShopType.class);
            return Result.ok(shopTypes);
        }

        // 4. 不存在，查询数据库
        List<ShopType> shopTypes = query().orderByAsc("sort").list();

        // 5. 不存在，爆粗404
        if (shopTypes == null) {
            return Result.fail("商品列表不存在！");
        }

        // 6. 存在，保存redis中
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shopTypes));

        // 7. 返回
        return Result.ok(shopTypes);
    }
}
