package com.chen;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by sunny-chen on 17/3/3.
 */
public class StringUtil {

    private StringUtil() {}

    /**
     * 检查字符串是否为null或者空
     *
     * */
    public static boolean isNotNullOrEmpty(String str) {
        return null != str && !"".equals(str);
    }

    /**
     * 检查字符串是否为null或者空
     *
     * */
    public static boolean isNullOrEmpty(String str) {
        return !isNotNullOrEmpty(str);
    }


    /**
     * 颠倒字符串
     * */
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length-1; i < j; i++, j--) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }

        return new String(chars);
    }


    /**
     * 判断字符串是不是数字
     *
     * */
    public static boolean isNumberic(String str) {
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum   = pattern.matcher(str);
        return isNum.matches();
    }


    /**
     * 判断字符串是不是中文
     *
     * */
    public static boolean isChinese(String str) {
        Pattern pattern = Pattern.compile("^[\\u4e00-\\u9fa5]*$");
        Matcher isCh    = pattern.matcher(str);
        return isCh.matches();
    }


    /**
     * MD5加密
     *
     * @param str 加密字符串
     * @return 加密结果
     */
    public static String EncodeByMD5(String str) {
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BASE64Encoder base64Encoder = new BASE64Encoder();
        String newStr = null;
        try {
            newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return newStr;
    }


    /**
     * 将字符串分割成数组
     *
     * @param separator 分割符号
     * @param str 被分割字符串
     *
     * @return 返回数组
     * */
    public static ArrayList<String> strToArrayList(final String str, final String separator) {
        ArrayList<String> ret = new ArrayList<>();
        String[] array = str.split(separator);
        Collections.addAll(ret, array);
        return ret;
    }
}
