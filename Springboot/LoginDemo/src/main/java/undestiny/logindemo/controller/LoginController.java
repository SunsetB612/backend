package undestiny.logindemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import undestiny.logindemo.service.UserService;
import undestiny.logindemo.service.UserServiceImpl;

@RestController
public class LoginController {
    //private UserService userService = new UserServiceImpl();

    @Autowired
    private UserService userService;

    @GetMapping("/login/{username}/{password}")
    public String login(@PathVariable(value = "username",required = true)String username,
                        @PathVariable(value = "password",required = true)String password,
                        HttpSession session){
        //参数校验
        if(username.length() < 2 || username.length() > 20
                || password.length() < 2 || password.length() > 20){
            return "Login failed";
        }
        //请求转发，会话管理
        try{
            session.setAttribute("user",userService.getUser(username,password));
        }catch (RuntimeException e){
            return "Login failed";
        }
        return "Login successfully";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        //注销session（在服务器里删除该session）
        session.invalidate();
        return "Logout successfully";
    }
}
