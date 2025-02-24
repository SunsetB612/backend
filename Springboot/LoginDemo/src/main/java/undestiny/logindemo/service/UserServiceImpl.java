package undestiny.logindemo.service;

import undestiny.logindemo.dao.UserDao;
import undestiny.logindemo.dao.UserDaoImpl;
import undestiny.logindemo.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User getUser(String username, String password) {
        User user = userDao.getUserByUsernameAndPassword(username,password);
        if(user==null) throw new RuntimeException();
        return user;
    }

    @Override
    public List<String> getUsernames() {
        return userDao.getUsernameList();
    }
}
