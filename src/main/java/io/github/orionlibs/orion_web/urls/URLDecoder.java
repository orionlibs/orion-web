package io.github.orionlibs.orion_web.urls;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import lombok.Builder;

// @NoArgsConstructor
// @AllArgsConstructor
@Builder
                //@Getter
                //@Setter
class URLDecoder
{
    String decodeWithUTF8(String url)
    {
        try
        {
            return java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());
        }
        catch(UnsupportedEncodingException e)
        {
            return "";
        }
    }
}