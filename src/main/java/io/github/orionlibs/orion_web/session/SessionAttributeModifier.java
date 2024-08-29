package io.github.orionlibs.orion_web.session;

import io.github.orionlibs.orion_assert.Assert;
import jakarta.servlet.http.HttpServletRequest;

class SessionAttributeModifier
{
    static void setAttribute(HttpServletRequest request, String attributeName, Object attributeValue)
    {
        Assert.notNull(request, "The HttpServletRequest input cannot be null.");
        request.setAttribute(attributeName, attributeValue);
    }
}