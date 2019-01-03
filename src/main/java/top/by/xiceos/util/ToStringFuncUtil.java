package top.by.xiceos.util;

import java.lang.reflect.Field;

/**
 * <p>Title: ToStringFuncUtil</p>
 * <p>Description: toString() 方法工具类 $ 生成</p>
 *
 * @author zwp
 * @date 2019/1/3 16:59
 */
public class ToStringFuncUtil {
    /**
     * 根据对象获取toString方法的内容
     *
     * @param classz
     * @param formatType
     * @return
     */
    public static <T> String getToStringMethod(Class<T> classz, String formatType) throws Exception {
        // 获取所有的字段属性
        Field[] fields = classz.getDeclaredFields();
        String toString = "\"\\n[ =======\\n\" +";

        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            if(i != fields.length - 1) {
                toString += "\"" + fieldName + ": \" + " + "this." + fieldName + " + \", \\n\" + ";
            } else {
                toString += "\"" + fieldName + ": \" + " + "this." + fieldName;
            }
        }

        toString += "+ \"\\n======= ]\";";

        return toString;
    }
}
