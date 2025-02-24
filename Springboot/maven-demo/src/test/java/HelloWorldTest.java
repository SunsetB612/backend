import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import undestiny.HelloWorld;

public class HelloWorldTest {

    @Test
    void helloTest(){
        Assertions.assertEquals("Hello World!",new HelloWorld().hello());
    }
}
