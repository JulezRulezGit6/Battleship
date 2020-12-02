import java.io.PrintStream;
import java.lang.reflect.Method;

public class Invocation {
    public static void main(String[] args) throws Exception {
        Method hello = Invocation.class.getMethod("hello");
        hello.invoke(null);


    }

    public static void hello(){
        System.out.println("Hello World");
    }
}
