package com.atexo.atexotechbackend.common;

import com.atexo.atexotechbackend.common.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTest {


    @Test
    public void testSafeSubStringStart0End0() {
        String test = "ABCD";
        Assertions.assertEquals("", StringUtil.safeSubString(test, 0, 0));
    }
    @Test
    public void testSafeSubStringStart0End1() {
        String test = "ABCD";
        Assertions.assertEquals("A", StringUtil.safeSubString(test, 0, 1));
    }
    @Test
    public void testSafeSubStringStart1End1() {
        String test = "ABCD";
        Assertions.assertEquals("", StringUtil.safeSubString(test, 1, 1));
    }
    @Test
    public void testSafeSubStringStartOutOfBound() {
        String test = "ABCD";
        StringIndexOutOfBoundsException thrown = Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            StringUtil.safeSubString(test, -1, 2);
        });
    }
}
