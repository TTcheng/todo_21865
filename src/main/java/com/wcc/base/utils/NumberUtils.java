package com.wcc.base.utils;

import java.util.regex.Pattern;

/**
 * 数字相关的工具类
 */
public class NumberUtils {
    /**
     * 判断字符串是否是纯数字
     * @param string 源字符串
     * @return true or false
     */
    public static boolean isNumber(String string){
        return string.chars().allMatch(Character::isDigit);
    }

    /**
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断字符串是否是Short数字
     * @param string 源字符串
     * @return true or false
     */
    public static boolean isShort(String string){
        if (isInteger(string)){
            int anInt = Integer.parseInt(string);
            return !(anInt > Short.MAX_VALUE || anInt < Short.MIN_VALUE);
        }
        return false;
    }
}
