package undestiny.blogdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UrlPathHelper;
import undestiny.blogdemo.entity.User;
import undestiny.blogdemo.service.UserServiceImpl;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    private UrlPathHelper mvcUrlPathHelper;

    @PostMapping("/register/{username}/{password}")
    public User register(@PathVariable("username")String username,
                         @PathVariable("password")String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(!userServiceImpl.userExists(username)) {
            userServiceImpl.register(user);
            return user;
        }else {
            throw new RuntimeException("用户已存在");
        }

    }
    @PostMapping("/login/{username}/{password}")
    public User login(@PathVariable("username")String username,
                      @PathVariable("password")String password){
        return userServiceImpl.login(username,password);
    }
    @PostMapping("/updatePassword/{username}/{oldPassword}/{newPassword}")
    public User updatePassword(@PathVariable("username")String username,
                               @PathVariable("oldPassword")String oldPassword,
                               @PathVariable("newPassword")String newPassword){
        return userServiceImpl.updatePassword(username,oldPassword,newPassword);
    }
    @GetMapping("/userExists/{username}")
    public boolean checkUserExists(@PathVariable String username) {
        return userServiceImpl.userExists(username);
    }
    @DeleteMapping("logout/{username}/{password}")
    public ResponseEntity<String> deleteUser(@PathVariable("username")String username, @PathVariable("password")String password){
     if(userServiceImpl.userExists(username)){
         userServiceImpl.deleteUser(username,password);
         return ResponseEntity.ok("用户注销成功");
     }else{
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("用户不存在");
     }
    }
}
