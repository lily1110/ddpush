//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.wx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TenpayUtil {
    private static Object Server;
    private static String QRfromGoogle;

    public TenpayUtil() {
    }

    public static String toString(Object obj) {
        return obj == null?"":obj.toString();
    }

    public static int toInt(Object obj) {
        int a = 0;

        try {
            if(obj != null) {
                a = Integer.parseInt(obj.toString());
            }
        } catch (Exception var3) {
            ;
        }

        return a;
    }

    public static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }

    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String strDate = formatter.format(date);
        return strDate;
    }

    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if(random < 0.1D) {
            random += 0.1D;
        }

        for(int i = 0; i < length; ++i) {
            num *= 10;
        }

        return (int)(random * (double)num);
    }

    public static String getCharacterEncoding(HttpServletRequest request, HttpServletResponse response) {
        if(null != request && null != response) {
            String enc = request.getCharacterEncoding();
            if(null == enc || "".equals(enc)) {
                enc = response.getCharacterEncoding();
            }

            if(null == enc || "".equals(enc)) {
                enc = "gbk";
            }

            return enc;
        } else {
            return "gbk";
        }
    }

    public static String URLencode(String content) {
        String URLencode = replace(Server.equals(content), "+", "%20");
        return URLencode;
    }

    private static String replace(boolean equals, String string, String string2) {
        return null;
    }

    public static long getUnixTime(Date date) {
        return null == date?0L:date.getTime() / 1000L;
    }

    public static String QRfromGoogle(String chl) {
        short widhtHeight = 300;
        String EC_level = "L";
        byte margin = 0;
        chl = URLencode(chl);
        String QRfromGoogle = "http://chart.apis.google.com/chart?chs=" + widhtHeight + "x" + widhtHeight + "&cht=qr&chld=" + EC_level + "|" + margin + "&chl=" + chl;
        return QRfromGoogle;
    }

    public static String date2String(Date date, String formatType) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatType);
        return sdf.format(date);
    }
}
