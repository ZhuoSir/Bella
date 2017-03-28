package com.creheart.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.EnumMap;
import java.util.Enumeration;

/**
 *
 * Created by sunny-chen on 2017/3/12.
 */
public class SessonUtil {

    public static void setAttributeInSession(String attrName, Object attribute) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            HttpSession session = request.getSession();
            session.setAttribute(attrName, attribute);
        }
    }

    public static void reSetAttributeInSession(String attrName, Object attribute) {
        setAttributeInSession(attrName, attribute);
    }

    public static Object getAttributeInCurrentSession(String attrName) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            HttpSession session = request.getSession();
            return session.getAttribute(attrName);
        }
        return null;
    }

    public static void removeAttributeInCurrentSession(String attrName) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            HttpSession session = request.getSession();
            session.removeAttribute(attrName);
        }
    }

    public static void clearAllAttrInSession() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            HttpSession session = request.getSession();
            Enumeration<String> enumeration = session.getAttributeNames();
            while (enumeration.hasMoreElements()) {
                removeAttributeInCurrentSession(enumeration.nextElement());
            }
        }
    }
}
