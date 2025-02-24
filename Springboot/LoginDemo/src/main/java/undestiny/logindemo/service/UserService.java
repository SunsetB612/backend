package undestiny.logindemo.service;

import undestiny.logindemo.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String username,String password);
    List<String> getUsernames();
}
