package com.yuxuan.filter;

import com.yuxuan.utils.CurrentHolder;
import com.yuxuan.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @ClassName TokenFilter
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/29 19:45
 */
@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 1. 获取路径
//        String url = String.valueOf(request.getRequestURL());

        String url = request.getRequestURI();

        // 2. 判断是否是登录操作 /login
        if (url.contains("/login")) {
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 3. 获取请求头中的token
        String token = request.getHeader("token");

        // 4. 判断是否有token
        if (token == null || token.isEmpty()) {
            log.info("没有token，拦截");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 5. 解析token
        try {
            Claims claims = JwtUtils.parseJWT(token);
            Integer id = Integer.valueOf(claims.get("id").toString());
            log.info("token有效, id为{}, 存入当前线程中", id);
            CurrentHolder.setCurrentId(id);
        } catch (Exception e) {
            log.info("token无效，拦截");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 6. token有效，放行
        log.info("token有效，放行");

        filterChain.doFilter(servletRequest, servletResponse);

        CurrentHolder.remove();
    }
}
