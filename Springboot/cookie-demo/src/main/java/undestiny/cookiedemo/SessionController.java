package undestiny.cookiedemo;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @GetMapping("/setSession")
    public String setSession(HttpSession session){
        User user = new User();
        user.setUsername("Jack");
        user.setPassword("abcd");
        session.setAttribute("user",user);
        return "SUCCESS";
    }
    @GetMapping("/getSession")
    public User getSession(HttpSession session){
        return (User)session.getAttribute("user");
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "Logout Successfully";
    }
}
