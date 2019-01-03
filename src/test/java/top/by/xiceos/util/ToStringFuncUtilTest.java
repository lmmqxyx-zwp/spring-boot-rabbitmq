package top.by.xiceos.util;

import org.junit.Test;
import top.by.xiceos.entity.User;

import static org.junit.Assert.*;

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