package org.lql.controller;

import org.lql.domain.User;
import org.lql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Title: UserController <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/28 14:21 <br>
 */
// 使该类成为处理请求的控制器
@Controller
// 处理来之/user URI的请求
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 返回一个String类型的逻辑视图名
    // 此处可直接标@RequestMapping，为此路径下的默认处理方法
    @RequestMapping("/register")
    public String register() {
        return "user/register";
    }

    @RequestMapping(method= RequestMethod.POST)
    public ModelAndView createrUser(User user) {
        userService.createUser(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/createSuccess");
        mav.addObject("user", user);

        return mav;
    }

    // URL中{xxx}占位符可以通过@PathVariable("xxx")绑定到操作方法的入参中
    @RequestMapping("/{userId}")
    public ModelAndView showDetail(@PathVariable("userId") String userId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/showUser");
        mav.addObject("user", userService.getUserById(userId));

        return mav;
    }

    // 使用请求方法，请求头参数及请求参数映射请求
    // param使用请求方法及请求参数映射请求
    @RequestMapping(path = "/delete", method = RequestMethod.POST, params = "userId")
    public String test1(@RequestParam("userId") String userId) {
        return "user/test1";
    }

    // headers使用报文头映射请求
    @RequestMapping(path = "/show", headers = "content-type=text/*")
    public String test2(@RequestParam("userId") String userId) {
        return "user/test2";
    }

    // 几种经典的处理方法签名
    // ①请求参数按名称匹配的方式绑定到方法入参中，方法返回对应的字符串代表逻辑视图名
    @RequestMapping(value = "/handle1")
    public String handle1(@RequestParam("userName") String userName,
                          @RequestParam("password") String password,
                          @RequestParam("realName") String realName) {
        return "success";
    }

    // ②将Cooke值及报文头属性绑定到入参中、方法返回ModelAndView
    @RequestMapping(value = "/handle2")
    public ModelAndView handle2(@CookieValue("JSESSIONID") String sessionId,
                                @RequestHeader("Accept-Language") String accpetLanguage) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        mav.addObject("user", new User());
        return mav;
    }

    // ③请求参数按名称匹配的方式绑定到user的属性中、方法返回对应的字符串代表逻辑视图名
    @RequestMapping(value = "/handle3")
    public String handle3(User user) {
        return "success";
    }

    // ④直接将HTTP请求对象传递给处理方法、方法返回对应的字符串代表逻辑视图名
    @RequestMapping(value = "/handle4")
    public String handle4(HttpServletRequest request) {
        return "success";
    }

    // 注解参数说明
    @RequestMapping(value = "/handle11")
    public String handle11(
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam("age") int age) {
        return "success";
    }

    @RequestMapping(value = "/handle12")
    public String handle12(
            @CookieValue(value = "sessionId", required = false) String sessionId,
            @RequestParam("age") int age) {
        return "success";
    }

    @RequestMapping(value = "/handle13")
    public String handle13(@RequestHeader("Accept-Encoding") String encoding,
                           @RequestHeader("Keep-Alive") long keepAlive) {
        return "success";
    }

    @RequestMapping(value = "/handle14")
    public String handle14(User user) {
        return "success";
    }

    // 使用Servlet API对象作为入参
    @RequestMapping(value = "/handle21")
    public void handle21(HttpServletRequest request,
                         HttpServletResponse response) {
        String userName = request.getParameter("userName");
        response.addCookie(new Cookie("userName", userName));
    }

    @RequestMapping(value = "/handle22")
    public ModelAndView handle22(HttpServletRequest request) {
        String userName = WebUtils.findParameterValue(request, "userName");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        mav.addObject("userName", userName);
        return mav;
    }

    @RequestMapping(value = "/handle23")
    public String handle23(HttpSession session) {
        session.setAttribute("sessionId", 1234);
        return "success";
    }

    @RequestMapping(value = "/handle24")
    public String handle24(HttpServletRequest request,
                           @RequestParam("userName") String userName) {

        return "success";
    }

    @RequestMapping(value = "/handle25")
    public String handle25(WebRequest request) {
        String userName = request.getParameter("userName");
        return "success";
    }

    // 使用io对象作为入参
    @RequestMapping(value = "/handle31")
    public void handle31(OutputStream os) throws IOException {
        Resource res = new ClassPathResource("/image.jpg");
        FileCopyUtils.copy(res.getInputStream(), os);
    }
}
