package com.wcc.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * @param date      日期
     * @param dateModel 日期格式
     * @return String    返回类型
     * @title: DateToString
     * @description: 将日期转成字符串
     */
    public static String DateToString(Date date, String dateModel) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateModel);
        return sdf.format(date);
    }

    /**
     * @return String    yyyy-MM-dd HH:mm:ss
     * @title: DateToString
     * @description: 获取当前系统时间的字符串形式 yyyy-MM-dd HH:mm:ss
     */
    public static String getSystemDateTimeString() {
        return DateToString(new Date(), YYYY_MM_DD_HH_MM_SS);
    }

}
