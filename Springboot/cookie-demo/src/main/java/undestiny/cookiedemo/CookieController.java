package undestiny.cookiedemo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {
    @GetMapping("/setCookies")
    public String setCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("sessionId","CookieTestInfo");
        response.addCookie(cookie);
        return "get cookies successfully";
    }
    @GetMapping("/getCookies")
    public String getCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie: cookies){
                //注意Java中==比较对象内存地址
                //String类型应使用equals()进行值比较
                if(cookie.getName().equals("sessionId")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    //注解方式获取cookie中对应的key值
    @GetMapping("/getCookies/annotation")
    public String testCookieValue(@CookieValue("sessionId") String cookieValue ) {
        //前提是已经创建了或者已经存在cookie了，那么下面这个就直接把对应的key值拿出来了。
        System.out.println("testCookieValue,cookieValue="+cookieValue);
        return "SUCCESS";
    }
}
