package undestiny.logindemo.dao;

import org.springframework.stereotype.Service;
import undestiny.logindemo.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao{
    @Override
    public List<User> getUserList() {
        User user1 = new User(1,"Jack","123");
        User user2 = new User(2,"Mary","456");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    @Override
    public List<String> getUsernameList() {
        List<User> userList = getUserList();
        List<String> usernameList = new ArrayList<>();
        for(User user: userList){
            usernameList.add(user.getUsername());
        }
        return usernameList;
    }

    @Override
    public User getUserByUsername(String username) {
        List<User> userList = getUserList();
        for(User user: userList){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = getUserByUsername(username);
        if(user.getPassword().equals(password)) return user;
        return null;
    }
}
