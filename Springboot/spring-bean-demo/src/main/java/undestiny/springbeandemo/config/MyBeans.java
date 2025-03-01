package undestiny.springbeandemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeans {
    @Bean("autowire")
    public Integer autowire_bean(){
        return 1;
    }
    @Bean("autowire2")
    public Integer autowire2_bean(){
        return 2;
    }
    @Bean("resource_name1")
    public String resource_bean1(){
        return "this is resource_bean1";
    }
    @Bean("resource_name2")
    public String resource_name2(){
        return "this is resource_bean2";
    }
}
