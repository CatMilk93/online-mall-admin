package lovely.baby.online.mall.backstage.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lovely.baby.online.mall.backstage.util.Constants.CookieNames;

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
            if (CookieNames.NAME.equals(cookie.getName())) {
                return true;
            }
        }
        response.sendRedirect("/login_entry");
        return false;
    }
}
