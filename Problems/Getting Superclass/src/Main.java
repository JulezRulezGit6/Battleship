class SuperClassGetter {

    public static void main(String[] args) throws ClassNotFoundException {
        SuperClassGetter superClassGetter = new SuperClassGetter();
        System.out.println(getSuperClassByInstance(superClassGetter));
        System.out.println(getSuperClassByName("superClassGetter"));

    }

    public static Class getSuperClassByName(String name) throws ClassNotFoundException {
        Class c = Class.forName(name);
        return c.getSuperclass();
    }

    public static Class getSuperClassByInstance(Object object) {

        return object.getClass().getSuperclass();

    }


}