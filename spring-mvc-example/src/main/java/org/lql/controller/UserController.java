package org.lql.controller;

import org.lql.domain.Dept;
import org.lql.domain.User;
import org.lql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
// 会将handle71中的模型属性自动保存到httpSession中，多个请求之间可以共享
// @SessionAttributes(value={"user","user1","user2"},types={Dept.class})
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

    // 使用HttpMessageConverter<T>，只用在使用下面两种方法时才使用http消息转换器对请求进行处理
    // 1. 使用@RequestBody/@ResponseBody对处理方法进行标注
    // 2. 使用HttpEntity<T>/RsponseEntity<T>作为处理方法的入参或返回值
    // 将请求报文体转换为字符串绑定到body入参中
    @RequestMapping(value = "/handle41")
    public String handle41(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    // 读取一张图片，并将图片数据输出到响应流中，客户端显示这张图片
    @ResponseBody
    @RequestMapping(value = "/handle42/{imageId}")
    public byte[] handle42(@PathVariable("imageId") String imageId)
            throws IOException {
        System.out.println("load image of " + imageId);
        Resource res = new ClassPathResource("/image.jpg");
        byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
        return fileData;
    }

    @RequestMapping(value = "/handle43")
    public String handle43(HttpEntity<String> requestEntity) {
        long contentLen = requestEntity.getHeaders().getContentLength();
        System.out.println("user:" + requestEntity.getBody());
        return "success";
    }

    @RequestMapping(value = "/handle44/{imageId}")
    public ResponseEntity<byte[]> handle44(
            @PathVariable("imageId") String imageId) throws Throwable {
        Resource res = new ClassPathResource("/image.jpg");
        byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(
                fileData, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/handle51")
    public ResponseEntity<User> handle51(HttpEntity<User> requestEntity) {
        User user = requestEntity.getBody();
        user.setUserId("1000");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // Spring MVC将请求消息绑定到User对象中，然后再以user为键将User对象放到模型中，在准备对象视图进行渲染前，Spring Mvc还会进一步将模型中的数据转储到视图的上下文中并暴露给视图对象
    @RequestMapping(value = "/handle61")
    public String handle61(@ModelAttribute("user") User user) {
        user.setUserId("1000");
        return "/user/createSuccess";
    }

    // 模型数据（getUser方法）会赋给User的入参，然后再根据Http请求消息进一步填充覆盖user对象
    @RequestMapping(value = "/handle62")
    public String handle62(@ModelAttribute("user") User user) {
        user.setUserName("tom");
        return "/user/showUser";
    }

    @RequestMapping(value = "/handle63")
    public String handle63(ModelMap modelMap) {
        User user = (User) modelMap.get("user");
        user.setUserName("tom");
        modelMap.addAttribute("testAttr", "value1");
        return "/user/showUser";
    }

    // 在访问UserController中的任何一个请求处理方法前，Spring MVC先执行该方法，并将返回值以user为键添加到模型中
    @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setUserId("1001");
        user.setUserName("<>");
        return user;
    }

    @ModelAttribute("user1")
    public User getUser1() {
        User user = new User();
        user.setUserId("1");
        return user;
    }

    @ModelAttribute("user2")
    public User getUser2() {
        User user = new User();
        user.setUserId("1");
        return user;
    }

    @ModelAttribute("dept")
    public Dept getDept() {
        Dept dept = new Dept();
        return dept;
    }

    @RequestMapping(value = "/handle71")
    public String handle71(@ModelAttribute("user") User user) {
        user.setUserName("John");
        return "redirect:handle72.html";
    }

    @RequestMapping(value = "/handle72")
    public String handle72(ModelMap modelMap, SessionStatus sessionStatus) {
        User user = (User) modelMap.get("user");
        if (user != null) {
            user.setUserName("Jetty");
            // 让Spring MVC清除本处理器对应的会话属性
            sessionStatus.setComplete();
        }
        return "/user/showUser";
    }

    // 使用自定义转换器/handle81.html?user=tom:1234:tomson
    @RequestMapping(value = "/handle81")
    public String handle81(@RequestParam("user") User user, ModelMap modelMap) {
        modelMap.put("user", user);
        return "/user/showUser";
    }

    // 通过@Valid使用校验框架
    @RequestMapping(value = "/handle91")
    public String handle91(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult, ModelMap mm) {
        if (bindingResult.hasErrors()) {
            return "/user/register3";
        } else {
            return "/user/showUser";
        }
    }

    // 在控制器初始化时调用
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 注册一个自定义编辑器
        // binder.registerCustomEditor(User.class, new UserEditor());
        // 4.0中可以使用addCustomFormatter指定格式化程序实现，这样就不需要实现一个PropertyEditor的实例
//        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
        // binder.setValidator(new UserValidator());
    }

}
