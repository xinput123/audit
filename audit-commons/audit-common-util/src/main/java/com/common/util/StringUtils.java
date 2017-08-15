package com.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * String 常用工具类
 */
public class StringUtils {

    private final static Logger logger = LoggerFactory.getLogger(StringUtils.class);

    /**
     * @Description:   判断str是否为null或空
     * @return:        ture(为null或者为空)  false(不为null且不为空)
     */
    public static boolean isNullOrEmpty(String str) {
        if (null==str || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 如果传入的多个str有一个为空或者null，返回true
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String... str){
        if(null==str || str.length==0){
            return true;
        }
        for(String ss : str){
            if(isNullOrEmpty(ss)){
                return true;
            }
        }
        return false;
    }

    /**如果是null，替换成"" */
    public static String replaceNullToEmpty(String str) {
        if(str==null) {
            return "";
        }
        return str;
    }

    /** 如果str1为null或者空则替换成str2*/
    public static String replaceNullOrEmptyToStr(String str1, String str2) {
        if(isNullOrEmpty(str1)) {
            return str2;
        }
        else {
            return str1;
        }
    }

    /** 如果str等于str1 则返回str2 否则返回str*/
    public static String replaceStr(String str, String str1, String str2) {
        if(str==null && str1==null) {
            return str2;
        }
        else if(str1 !=null && str2!=null && str.equals(str1)) {
            return str2;
        }
        else {
            return str;
        }
    }

    /**
     * @Description:   判断str是否在String[] strArray中，区分大小写
     * @return:        true在 false不在
     */
    public static boolean in(String str, String[] strArray) {
        if (str==null) {
            return false;
        }
        for (String s : strArray) {
            if (s != null && s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**截取字符串*/
    public static String substring(String str,int length) {
        if(isNullOrEmpty(str)) {
            return str;
        }
        if(str.length()<=length) {
            return str;
        }
        else {
            return str.substring(0, length);
        }
    }

    /**删除最后一个字符*/
    public static String deleteLastChar(String str) {
        if(isNullOrEmpty(str)) {
            return str;
        }
        return substring(str,str.length()-1);
    }

    /** 使用指定格式编码 */
    public String encode(String message) throws UnsupportedEncodingException{
        if(isNullOrEmpty(message)){
            return message;
        }
        try {
            return URLEncoder.encode(message,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("Exception : StringUtils.encode.message = " + message ,e);
            throw new UnsupportedEncodingException();
        }
    }

    public String decode(String message) throws UnsupportedEncodingException{
        if(isNullOrEmpty(message)){
            return message;
        }
        try {
            return URLDecoder.decode(message,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("Exception : StringUtils.decode.message = " + message ,e);
            throw new UnsupportedEncodingException();
        }
    }



    public static void main(String[] args) {
        String str = null;
        System.out.println(str==null);
    }
}
