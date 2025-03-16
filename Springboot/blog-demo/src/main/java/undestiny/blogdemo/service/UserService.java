package undestiny.blogdemo.service;

import org.springframework.stereotype.Service;
import undestiny.blogdemo.entity.User;

public interface UserService {
    User register(User user);
    User login(String username,String password);
    User updatePassword(String username,String oldPassword,String newPassword);
    boolean userExists(String username);
    boolean deleteUser(String username,String password);
}
