import java.lang.reflect.Method;

class MethodFinder {

    public static void main(String[] args) throws ClassNotFoundException {
        String abs = "abs";
        String[] classNames = {"java.lang.String", "java.lang.StringBuffer", "java.lang.Math"};

        System.out.println(findMethod(abs, classNames));

    }

    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException {
        for (int i = 0; i < classNames.length; i++) {
            String classCandidate = classNames[i];
            Class<?> candidate = Class.forName(classCandidate);
            Method[] declaredMethods = candidate.getMethods();
            for (Method method : declaredMethods
            ) {
                if (method.getName().contains(methodName)) {
                    return classCandidate;
                }

            }
        }
        return "Jolly";
    }
}