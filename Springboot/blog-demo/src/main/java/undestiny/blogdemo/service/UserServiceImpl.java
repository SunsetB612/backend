package undestiny.blogdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import undestiny.blogdemo.entity.User;
import undestiny.blogdemo.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User register(User user) {
        if(userMapper.insertUser(user) == 1) return user;
        else{
            throw new RuntimeException("注册失败");
        }
    }

    @Override
    public User login(String username,String password) {
        User user = userMapper.selectByUsername(username);
        if(user == null||!user.getPassword().equals(password)){
            throw new RuntimeException("用户名或id或密码错误");
        }
        return user;
    }

    @Override
    public User updatePassword(String username, String oldPassword, String newPassword) {
        User user = userMapper.selectByUsername(username);
        if(user != null && user.getPassword().equals(oldPassword)) {
            userMapper.updatePassword(username,newPassword);
            user = userMapper.selectByUsername(username);
        }
        else {
            throw new RuntimeException("用户名或id或密码错误");
        }
        return user;
    }
    @Override
    public boolean userExists(String username){
        User user = userMapper.selectByUsername(username);
        if(user == null) return false;
        return true;
    }
    @Override
    public boolean deleteUser(String username,String password){
        User user = userMapper.selectByUsername(username);
        if(user.getPassword().equals(password)){
            boolean result = userMapper.deleteUser(username);
            // 通过 JDBC 执行 SQL 重置自增 ID
            String resetAutoIncrementSql = "ALTER TABLE user AUTO_INCREMENT = 1";
            jdbcTemplate.update(resetAutoIncrementSql);
            return result;
        }else {
            throw new RuntimeException("注销用户失败,密码错误");
        }
    }
}
