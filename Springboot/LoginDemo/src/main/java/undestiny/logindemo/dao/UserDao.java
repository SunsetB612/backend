package undestiny.logindemo.dao;

import undestiny.logindemo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();
    List<String> getUsernameList();
    User getUserByUsername(String username);
    User getUserByUsernameAndPassword(String username,String password);
}
