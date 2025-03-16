package undestiny.blogdemo.mapper;

import org.apache.ibatis.annotations.*;
import undestiny.blogdemo.entity.User;

@Mapper
public interface UserMapper {

    //注册
    @Insert("INSERT INTO user(username,password) VALUES (#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertUser(User user);

    //根据用户名查找用户
    @ResultType(User.class)
    @Select("SELECT * FROM user WHERE username = #{username}")
    User selectByUsername(@Param("username")String username);

    //修改密码
    @Update("UPDATE user SET password = #{newPassword} WHERE username = #{username}")
    int updatePassword(@Param("username")String username,@Param("newPassword")String newPassword);

    //删除用户
    @Delete("DELETE FROM user WHERE username=#{username}")
    boolean deleteUser(@Param("username")String username);
}
