package io.github.orionlibs.orion_web.filter;

import io.github.orionlibs.orion_cryptology.encoding.xss.XSSEncodingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.util.stream.IntStream;

public class XSSHttpServletRequestWrapper extends HttpServletRequestWrapper
{
    public XSSHttpServletRequestWrapper(HttpServletRequest request)
    {
        super(request);
    }


    @Override
    public String[] getParameterValues(String parameter)
    {
        String[] values = super.getParameterValues(parameter);
        if(values == null)
        {
            return null;
        }
        String[] encodedValues = new String[values.length];
        IntStream.range(0, values.length).forEach(i -> encodedValues[i] = XSSEncodingService.encodeWithXSS(values[i]));
        return encodedValues;
    }


    @Override
    public String getParameter(String parameter)
    {
        return XSSEncodingService.encodeWithXSS(super.getParameter(parameter));
    }


    @Override
    public String getHeader(String name)
    {
        return XSSEncodingService.encodeWithXSS(super.getHeader(name));
    }
}