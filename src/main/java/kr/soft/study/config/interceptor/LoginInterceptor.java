package kr.soft.study.config.interceptor;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request
                            , HttpServletResponse response
                            , Object handler) throws Exception {
        log.info("login preHandle");
        //true : 성공, false : 실패

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request
                            , HttpServletResponse response
                            , Object handler
                            , @Nullable Exception ex) throws Exception {
        log.info("Login Interceptor AfterComplateion");
    }
}
