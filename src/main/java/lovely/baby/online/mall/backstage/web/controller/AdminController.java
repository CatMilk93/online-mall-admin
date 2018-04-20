package lovely.baby.online.mall.backstage.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lovely.baby.online.mall.backstage.model.Admin;
import lovely.baby.online.mall.backstage.service.AdminService;
import lovely.baby.online.mall.backstage.util.Constants.CookieNames;
import lovely.baby.online.mall.backstage.util.RequestDataHolder;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/login_entry")
    public String login() {
        return "login";
    }

    // 退出页面
    @RequestMapping(value = "background/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        for (Cookie cookie : request.getCookies()) {
            if (CookieNames.NAME.equals(cookie.getName())) {
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return "redirect:/background";
    }

    // 验证登录是否成功后跳转页面
    @PostMapping("login")
    public String verifyLogin(@RequestParam("name") String name, @RequestParam("password") String password,
            HttpServletResponse response) {
        Admin admin = adminService.adminVerify(name, password);
        if (admin == null) {
            return "login";
        }
        Cookie cookie = new Cookie(CookieNames.NAME, admin.getName());
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/background";
    }

    @RequestMapping("/background")
    public ModelAndView background() {

        ModelAndView modelAndView = new ModelAndView("background");
        modelAndView.addObject("name", RequestDataHolder.getName());
        return modelAndView;
    }

}
