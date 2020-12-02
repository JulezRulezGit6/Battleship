import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Get list of public fields the object declares (inherited fields should be skipped).11:18
 */
class FieldGetter {

    public String[] getPublicFields(Object object) {
        Class<?> aClass = object.getClass();
        int count = 0;
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields
        ) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                count++;
            }

        }

        int index = 0;
        String[] strings = new String[count];
        for (Field field : fields
        ) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                strings[index] = field.getName();
                index++;
            }
        }

        return strings;
    }

}