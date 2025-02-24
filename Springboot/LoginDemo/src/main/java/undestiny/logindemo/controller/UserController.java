package undestiny.logindemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import undestiny.logindemo.service.UserService;
import undestiny.logindemo.service.UserServiceImpl;

import java.util.List;

@RestController
public class UserController {
    private UserService userService = new UserServiceImpl();

    @GetMapping("/getUsernames")
    public List<String> getUsernames(HttpSession session){
        if(session.getAttribute("user")!=null)
            return userService.getUsernames();
        return null;
    }
}
