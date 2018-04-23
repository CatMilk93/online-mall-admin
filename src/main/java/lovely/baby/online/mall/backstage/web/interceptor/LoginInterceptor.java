package lovely.baby.online.mall.backstage.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lovely.baby.online.mall.backstage.util.AESEncryptUtils;
import lovely.baby.online.mall.backstage.util.Constants.CookieNames;
import lovely.baby.online.mall.backstage.util.RequestDataHolder;

@Component("loginInterceptor")
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!request.getRequestURI().startsWith("/background")) {
            return true;
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (CookieNames.TOKEN.equals(cookie.getName())) {
                try {
                    RequestDataHolder.setUsername(AESEncryptUtils.decrypt(cookie.getValue()));
                    return true;
                } catch (Exception e) {
                    break;
                }
            }
        }
        if (request.getRequestURI().endsWith("login")) {
            return true;
        }
        response.sendRedirect("/background/login");
        return false;
    }
}
