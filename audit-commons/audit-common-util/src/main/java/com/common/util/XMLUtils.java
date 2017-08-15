package com.common.util;

/**
 * Created by HP on 2017-08-13.
 */
public class XMLUtils {
    /**
     * 去除回车
     * @param in
     * @return 返回处理后字符串
     */
    public static String formatXML(String in){
        if(StringUtils.isNullOrEmpty(in.trim())){
            return "";
        }
        StringBuilder out = new StringBuilder();
        in = in.trim();
        int length =in.length();
        char[] ch;
        ch=new char[length+1];
        ch=in.toCharArray() ;
        for(int i=0;i<ch.length ;i++){
            if(ch[i]!='\r' && ch[i]!='\t' && ch[i]!='\n'){
                out.append(ch[i]);
            }
        }
        return out.toString();
    }
}
