package com.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date 帮助类
 */
public class DateUtils {

    private final static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /** 按照指定格式返回 */
    public static String returnDate(Date date, String pattern) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try{
            return sdf.format(date);
        }catch (Exception e){
            logger.error("DateUtil.Exception.returnDate(pattern =  " + pattern + " )",e);
            throw e;
        }
    }

    /** 取指定日期的前或者后n天，并按照指定日期返回 */
    public static String beforeDateStr(Date date,String pattern,int n) throws Exception{
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - n);

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.format(c.getTime());
        } catch (Exception e) {
            logger.error("DateUtil.Exception.beforeDateStr(" + pattern + ")",e);
            throw e;
        }
    }

    /** 获取当前系统的UTC时间戳 */
    public static long getLongTime(Date date){
        return date.getTime()/1000;
    }

    /**
     * 将时间戳转为Date类型返回
     * @param
     */
    public static Date getDate(Long time) throws ParseException {
        SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String d = format.format(time);

        Date date = null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            logger.error("DateUtil.Exception.getDate(" + time + ")",e);
            throw  e;
        }

        return date;
    }

    /** 判断是否是周末 */
    public static boolean isWeekend(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY){
            return true;
        }
        return false;
    }

    /** 判断是否是对应的星期几 */
    public static boolean isDayOfWeek(Date date, int n){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if(day == n){
            return true;
        }
        return false;
    }

    /** 返回给定时间对应的星期几 1代表星期日 ，7代表星期六 */
    public static int dayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    // 获取当前时间小时数
    public static int getHourOfDay( Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        return hours;
    }
}
