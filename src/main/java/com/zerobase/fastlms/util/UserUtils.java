package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;

public class UserUtils {
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null) {
            ip = request.getRemoteAddr();;
        }
        return ip;
    }

    public static String getUserAgent(HttpServletRequest request) {
        // 에이전트
        String agent = request.getHeader("User-Agent");
        // 브라우져 구분
        String browser = null;
        if (agent != null) {
            if (agent.indexOf("Trident") > -1) {
                browser = "MSIE";
            } else if (agent.indexOf("Chrome") > -1) {
                browser = "Chrome";
            } else if (agent.indexOf("Opera") > -1) {
                browser = "Opera";
            } else if (agent.indexOf("iPhone") > -1 && agent.indexOf("Mobile") > -1) {
                browser = "iPhone";
            } else if (agent.indexOf("Android") > -1 && agent.indexOf("Mobile") > -1) {
                browser = "Android";
            }
        }
        return browser;
    }
}
