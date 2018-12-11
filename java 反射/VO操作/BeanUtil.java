package VO;

import java.lang.reflect.Method;

public class BeanUtil {
    public static void setBeanValue(Object obj, String str) throws Exception {
        String[] temp = str.split("\\|");
        for (int i = 0; i < temp.length; i++) {
            String[] result = temp[i].split(":");
            String realValue = result[1];

            String className = result[0].split("\\.")[0];
            String attrName = result[0].split("\\.")[1];
            Object realObj = getRealObj(obj, className);
            setRealValue(realObj, attrName, realValue);

        }

    }

    private static void setRealValue(Object object, String attrName, String value) throws Exception {
        Class<?> cls = object.getClass();
        String MethodName = "set" + initCap(attrName);
        Method setMethod = cls.getMethod(MethodName, String.class);
        setMethod.invoke(object, value);
    }

    private static Object getRealObj(Object obj, String className) throws Exception {
        //取得Class
        Class<?> cls = obj.getClass();
        //瓶装方法名
        String ClassName = "get" + initCap(className);
        //实例化对象，并invok调用
        Method method = cls.getMethod(ClassName);
        return method.invoke(obj);
    }

    private static String initCap(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
