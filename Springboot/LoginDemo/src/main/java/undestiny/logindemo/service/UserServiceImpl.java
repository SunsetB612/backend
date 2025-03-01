package undestiny.logindemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import undestiny.logindemo.dao.UserDaoImpl;
import undestiny.logindemo.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDaoImpl userDao;
    //private UserDao userDao = new UserDaoImpl();

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
