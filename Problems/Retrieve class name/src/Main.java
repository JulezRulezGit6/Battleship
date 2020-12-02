/**
 * Get name of the class for the object provided.
 */
class ClassGetter {

    public String getObjectClassName(Object object) {
        Class<?> aClass = object.getClass();


     return aClass.getName();
    }

}