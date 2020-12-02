import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Get sorted list of private fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public List<String> getPrivateFields(Object object) {
        Class<?> aClass = object.getClass();
        List<String> list = new ArrayList<>();

        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields
        ) {
            int modifiers = field.getModifiers();
            if (Modifier.isPrivate(modifiers)) {
                list.add(field.getName());
            }
        }
        Collections.sort(list);
        return list;
    }

}