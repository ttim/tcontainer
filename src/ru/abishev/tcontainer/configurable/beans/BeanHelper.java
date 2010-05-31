package ru.abishev.tcontainer.configurable.beans;

import ru.abishev.tcontainer.main.Bean;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: Apr 2, 2010
 * Time: 1:50:43 AM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class BeanHelper {
    private static final String SET_PREFIX = "set";

    private static Map<String, Class> builtInMap = new HashMap<String, Class>();
    static {
        builtInMap.put("int", Integer.class);
        builtInMap.put("long", Long.class);
        builtInMap.put("double", Double.class);
        builtInMap.put("float", Float.class);
        builtInMap.put("bool", Boolean.class);
        builtInMap.put("char", Character.class);
        builtInMap.put("byte", Byte.class);
        builtInMap.put("void", Void.class);
        builtInMap.put("short", Short.class);
    }

    private static Class primitiveClassToObjectClass(Class clazz) {
        if (clazz.isPrimitive()) {
            return builtInMap.get(clazz.getCanonicalName());
        } else {
            return clazz;
        }
    }

    public static boolean isCastable(Class clazz, Class castedTo) {
        return primitiveClassToObjectClass(castedTo).isAssignableFrom(primitiveClassToObjectClass(clazz));
    }

    public static Object createObjectFrom(Class clazz, Map<String, Bean> parameters) {
        try {
            Object object = clazz.newInstance();

            for (String parameter : parameters.keySet()) {
                Bean currentBean = parameters.get(parameter);

                for (Method method : clazz.getMethods()) {
                    if (method.getName().equals(SET_PREFIX + parameter)) {
                        if ((method.getParameterTypes().length == 1) &&
                                isCastable(currentBean.getClazz(), method.getParameterTypes()[0])) {
                            method.invoke(object, currentBean.getInstance());
                            break;
                        }
                    }
                }
            }

            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkCreatingPosibility(Class clazz, Map<String, Bean> parameters) {
        try {
            for (String parameter : parameters.keySet()) {
                Bean currentBean = parameters.get(parameter);
                boolean isSetted = false;

                for (Method method : clazz.getMethods()) {
                    if (method.getName().equals(SET_PREFIX + parameter)) {
                        if ((method.getParameterTypes().length == 1) &&
                                isCastable(currentBean.getClazz(), method.getParameterTypes()[0])) {
                            isSetted = true;
                            break;
                        }
                    }
                }

                if (!isSetted) {
                    return false;
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
