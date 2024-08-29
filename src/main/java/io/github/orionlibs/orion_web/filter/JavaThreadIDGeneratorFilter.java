package io.github.orionlibs.orion_web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;

public class JavaThreadIDGeneratorFilter extends OncePerRequestFilter
{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        JavaThreadIDGenerator.generateThreadID();
        //HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        //BufferedResponseWrapper bufferedResponse = new BufferedResponseWrapper(httpServletResponse);
        //filterChain.doFilter(request, bufferedResponse);
        filterChain.doFilter(request, response);
        /*if(bufferedResponse.getContent() != null)
        {
            final StringBuilder resMessage = new StringBuilder();
            resMessage.append(" [RESPONSE:")
                            .append(bufferedResponse.getContent())
                            .append("]");
            System.out.println(resMessage);
        }*/
    }
    /*public class TeeServletOutputStream extends ServletOutputStream
    {
        private final TeeOutputStream targetStream;
    
    
        public TeeServletOutputStream(OutputStream one, OutputStream two)
        {
            targetStream = new TeeOutputStream(one, two);
        }
    
    
        @Override
        public void write(int arg0) throws IOException
        {
            this.targetStream.write(arg0);
        }
    
    
        public void flush() throws IOException
        {
            super.flush();
            this.targetStream.flush();
        }
    
    
        public void close() throws IOException
        {
            super.close();
            this.targetStream.close();
        }
    
    
        @Override
        public boolean isReady()
        {
            return false;
        }
    
    
        @Override
        public void setWriteListener(WriteListener writeListener)
        {
        }
    }
    
    
    public class BufferedResponseWrapper implements HttpServletResponse
    {
        HttpServletResponse original;
        TeeServletOutputStream teeStream;
        PrintWriter teeWriter;
        ByteArrayOutputStream bos;
    
    
        public BufferedResponseWrapper(HttpServletResponse response)
        {
            original = response;
        }
    
    
        public String getContent()
        {
    
            if(bos == null)
            {
                return null;
            }
    
            return bos.toString();
        }
    
    
        @Override
        public PrintWriter getWriter() throws IOException
        {
    
            if(this.teeWriter == null)
            {
                this.teeWriter = new PrintWriter(new OutputStreamWriter(
                                getOutputStream()));
            }
    
            return this.teeWriter;
        }
    
    
        @Override
        public ServletOutputStream getOutputStream() throws IOException
        {
    
            if(teeStream == null)
            {
                bos = new ByteArrayOutputStream();
                teeStream = new TeeServletOutputStream(
                                original.getOutputStream(), bos);
            }
    
            return teeStream;
        }
    
    
        @Override
        public String getCharacterEncoding()
        {
            return original.getCharacterEncoding();
        }
    
    
        @Override
        public String getContentType()
        {
            return original.getContentType();
        }
    
    
        @Override
        public void setCharacterEncoding(String charset)
        {
            original.setCharacterEncoding(charset);
        }
    
    
        @Override
        public void setContentLength(int len)
        {
            original.setContentLength(len);
        }
    
    
        @Override
        public void setContentType(String type)
        {
            original.setContentType(type);
        }
    
    
        @Override
        public void setBufferSize(int size)
        {
            original.setBufferSize(size);
        }
    
    
        @Override
        public int getBufferSize()
        {
            return original.getBufferSize();
        }
    
    
        @Override
        public void flushBuffer() throws IOException
        {
    
            if(teeStream != null)
            {
                teeStream.flush();
            }
    
            if(this.teeWriter != null)
            {
                this.teeWriter.flush();
            }
    
        }
    
    
        @Override
        public void resetBuffer()
        {
            original.resetBuffer();
        }
    
    
        @Override
        public boolean isCommitted()
        {
            return original.isCommitted();
        }
    
    
        @Override
        public void reset()
        {
            original.reset();
        }
    
    
        @Override
        public void setLocale(Locale loc)
        {
            original.setLocale(loc);
        }
    
    
        @Override
        public Locale getLocale()
        {
            return original.getLocale();
        }
    
    
        @Override
        public void addCookie(Cookie cookie)
        {
            original.addCookie(cookie);
        }
    
    
        @Override
        public boolean containsHeader(String name)
        {
            return original.containsHeader(name);
        }
    
    
        @Override
        public String encodeURL(String url)
        {
            return original.encodeURL(url);
        }
    
    
        @Override
        public String encodeRedirectURL(String url)
        {
            return original.encodeRedirectURL(url);
        }
    
    
        @SuppressWarnings("deprecation")
        @Override
        public String encodeUrl(String url)
        {
            return original.encodeUrl(url);
        }
    
    
        @SuppressWarnings("deprecation")
        @Override
        public String encodeRedirectUrl(String url)
        {
            return original.encodeRedirectUrl(url);
        }
    
    
        @Override
        public void sendError(int sc, String msg) throws IOException
        {
            original.sendError(sc, msg);
        }
    
    
        @Override
        public void sendError(int sc) throws IOException
        {
            original.sendError(sc);
        }
    
    
        @Override
        public void sendRedirect(String location) throws IOException
        {
            original.sendRedirect(location);
        }
    
    
        @Override
        public void setDateHeader(String name, long date)
        {
            original.setDateHeader(name, date);
        }
    
    
        @Override
        public void addDateHeader(String name, long date)
        {
            original.addDateHeader(name, date);
        }
    
    
        @Override
        public void setHeader(String name, String value)
        {
            original.setHeader(name, value);
        }
    
    
        @Override
        public void addHeader(String name, String value)
        {
            original.addHeader(name, value);
        }
    
    
        @Override
        public void setIntHeader(String name, int value)
        {
            original.setIntHeader(name, value);
        }
    
    
        @Override
        public void addIntHeader(String name, int value)
        {
            original.addIntHeader(name, value);
        }
    
    
        @Override
        public void setStatus(int sc)
        {
            original.setStatus(sc);
        }
    
    
        @SuppressWarnings("deprecation")
        @Override
        public void setStatus(int sc, String sm)
        {
            original.setStatus(sc, sm);
        }
    
    
        @Override
        public void setContentLengthLong(long len)
        {
        }
    
    
        @Override
        public int getStatus()
        {
            return 0;
        }
    
    
        @Override
        public String getHeader(String name)
        {
            return original.getHeader(name);
        }
    
    
        @Override
        public Collection<String> getHeaders(String name)
        {
            return original.getHeaders(name);
        }
    
    
        @Override
        public Collection<String> getHeaderNames()
        {
            return original.getHeaderNames();
        }
    }*/
}