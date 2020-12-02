import java.lang.reflect.Method;

public class TestingReflection {

    public static void main(String[] args) throws ClassNotFoundException {
        Class student = Class.forName("Student");
        Student.class.getSuperclass()
        Method[] declaredMethods = student.getDeclaredMethods();
        for (Method method : declaredMethods
        ) {
            System.out.println(method.getName());
        }
        Method[] methods = student.getMethods();
        for (Method method:methods
             ) {
            System.out.println(method.getName());
        }
    }
}
