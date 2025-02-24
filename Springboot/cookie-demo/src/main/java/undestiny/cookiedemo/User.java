package undestiny.cookiedemo;

public class User {
    String username;
    String password;

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUsername(){
        //用于测试函数是否被调用 System.out.println("get函数被调用");
        return username;
    }
    public String getPassword(){
        //用于测试函数是否被调用 System.out.println("get函数被调用");
        return password;
   }
}
