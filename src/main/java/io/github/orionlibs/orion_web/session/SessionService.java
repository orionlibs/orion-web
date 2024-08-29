package io.github.orionlibs.orion_web.session;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;

public class SessionService
{
    public static Object getAttribute(HttpServletRequest request, String attributeName)
    {
        return SessionAttributeProvider.getAttribute(request, attributeName);
    }


    public static Object getSessionAttribute(HttpServletRequest request, String attributeName)
    {
        return SessionAttributeProvider.getSessionAttribute(request, attributeName);
    }


    public static String getUsername(HttpServletRequest request)
    {
        return SessionAttributeProvider.getUsername(request);
    }


    public static String getSessionUsername(HttpServletRequest request)
    {
        return SessionAttributeProvider.getSessionUsername(request);
    }


    public static String getSelectedTheme(HttpServletRequest request)
    {
        return SessionAttributeProvider.getSelectedTheme(request);
    }


    public static String getSessionSelectedTheme(HttpServletRequest request)
    {
        return SessionAttributeProvider.getSessionSelectedTheme(request);
    }


    public static String getJWT(HttpServletRequest request)
    {
        return SessionAttributeProvider.getJWT(request);
    }


    public static String getUserID(HttpServletRequest request)
    {
        return SessionAttributeProvider.getUserID(request);
    }


    public static String getSessionUserID(HttpServletRequest request)
    {
        return SessionAttributeProvider.getSessionUserID(request);
    }


    public static String getSessionJWT(HttpServletRequest request)
    {
        return SessionAttributeProvider.getSessionJWT(request);
    }


    public static void setAttribute(HttpServletRequest request, String attributeName, Object attributeValue)
    {
        SessionAttributeModifier.setAttribute(request, attributeName, attributeValue);
    }


    public static CsrfToken getCSRFToken(HttpServletRequest request)
    {
        return SessionAttributeProvider.getCSRFToken(request);
    }
}