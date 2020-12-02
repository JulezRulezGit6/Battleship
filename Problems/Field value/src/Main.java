import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        Class<?> aClass = object.getClass();

        try {
            Field field1 = aClass.getField(fieldName);
            int modifiers = field1.getModifiers();
            if (!Modifier.isPrivate(modifiers)) {
                field1.setAccessible(true);
                return field1.get(object);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }
}
