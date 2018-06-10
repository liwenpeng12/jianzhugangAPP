package com.jlkg.jzg.baselibrary.utils;

import java.math.BigDecimal;

/**
 * @autor zcs
 * @time 2017/12/6
 * @describe
 */

public class NumUtils {
    /**
     * 取整
     *
     * @return
     */
    public static int IntegerNum(double d) {

        BigDecimal b = new BigDecimal(d);
        double f1 = b.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        return (int) f1;
    }
}
