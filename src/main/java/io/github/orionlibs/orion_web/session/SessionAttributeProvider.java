package io.github.orionlibs.orion_web.session;

import io.github.orionlibs.orion_assert.Assert;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

class SessionAttributeProvider
{
    static Object getAttribute(HttpServletRequest request, String attributeName)
    {
        Assert.notNull(request, "The HttpServletRequest input cannot be null.");
        return request.getAttribute(attributeName);
    }


    static Object getSessionAttribute(HttpServletRequest request, String attributeName)
    {
        Assert.notNull(request, "The HttpServletRequest input cannot be null.");
        return request.getSession().getAttribute(attributeName);
    }


    static String getUsername(HttpServletRequest request)
    {
        return (String)getAttribute(request, SessionAttribute.currentUsername);
    }


    static String getSessionUsername(HttpServletRequest request)
    {
        return (String)getSessionAttribute(request, SessionAttribute.currentUsername);
    }


    static String getSelectedTheme(HttpServletRequest request)
    {
        return (String)getAttribute(request, SessionAttribute.currentSelectedTheme);
    }


    static String getSessionSelectedTheme(HttpServletRequest request)
    {
        return (String)getSessionAttribute(request, SessionAttribute.currentSelectedTheme);
    }


    static String getJWT(HttpServletRequest request)
    {
        return (String)getAttribute(request, SessionAttribute.currentUserJWTToken);
    }


    static String getUserID(HttpServletRequest request)
    {
        return (String)getAttribute(request, SessionAttribute.currentUserID);
    }


    static String getSessionUserID(HttpServletRequest request)
    {
        return (String)getSessionAttribute(request, SessionAttribute.currentUserID);
    }


    static String getSessionJWT(HttpServletRequest request)
    {
        return (String)getSessionAttribute(request, SessionAttribute.currentUserJWTToken);
    }


    static CsrfToken getCSRFToken(HttpServletRequest request)
    {
        return new HttpSessionCsrfTokenRepository().loadToken(request);
    }
}