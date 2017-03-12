package com.creheart.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            Object object = session.getAttribute(attrName);
            return object;
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
}
