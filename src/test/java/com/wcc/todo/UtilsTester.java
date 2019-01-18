package com.wcc.todo;

import com.wcc.base.utils.NumberUtils;
import org.junit.Test;

/**
 *
 * @author chuncheng.wang@hand-china.com 19-1-18 下午5:28
 */
public class UtilsTester {
    @Test
    public void testNumberUtils(){
        boolean isNumber = NumberUtils.isNumber("123.31241");
        System.out.println("isNumber = " + isNumber);
    }
}
