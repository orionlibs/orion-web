package io.github.orionlibs.orion_web.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class XSSWebFilter implements Filter
{
    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        chain.doFilter(new XSSHttpServletRequestWrapper((HttpServletRequest)request), response);
    }
}