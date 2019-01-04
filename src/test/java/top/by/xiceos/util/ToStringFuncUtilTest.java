package top.by.xiceos.util;

import org.junit.Test;
import top.by.xiceos.entity.User;

/**
 * <p>Title: ToStringFuncUtilTest</p>
 * <p>Description: toString方法打印</p>
 *
 * @author zwp
 * @date 2019/1/4 11:43
 */
public class ToStringFuncUtilTest {

    @Test
    public void getToStringMethod() {
        try {
            String toString = ToStringFuncUtil.getToStringMethod(User.class, null);
            System.out.println(toString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}