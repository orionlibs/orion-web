package io.github.orionlibs.orion_web.urls;

import io.github.orionlibs.orion_string.StringsService;
import java.util.Arrays;
import java.util.List;

public class URLService
{
    public static String encodeURLWithUTF8(String URLToEncode)
    {
        return new URLEncoder().encodeWithUTF8(URLToEncode);
    }


    public static String decodeURLWithUTF8(String URLToEncode)
    {
        return new URLDecoder().decodeWithUTF8(URLToEncode);
    }


    public static String encodeURLRemovingSymbolsWithUTF8(String URLToEncode)
    {
        return new URLEncoder().encodeRemovingSymbolsWithUTF8(URLToEncode);
    }


    public static String encodeURLRemovingSymbolsExceptForHyphenAndSpaceWithUTF8(String URLToEncode)
    {
        return new URLEncoder().encodeRemovingSymbolsExceptForHyphenAndSpaceWithUTF8(URLToEncode);
    }


    public static boolean doesURLStartWithAny(String url, List<String> prefixesToCheck)
    {
        return StringsService.doesStartWithAny(url, prefixesToCheck);
    }


    public static boolean doesURLStartWith(String url, String prefixToCheck)
    {
        return StringsService.doesStartWithAny(url, Arrays.asList(prefixToCheck));
    }


    public static String shortenURL(String url)
    {
        /*private static final String BITLY_API_URL = "https://api-ssl.bitly.com/v4/shorten";
        private static final String BITLY_ACCESS_TOKEN = "YOUR_BITLY_ACCESS_TOKEN";
        
        public static String shortenURL(String longURL) throws Exception {
            HttpClient httpClient = HttpClient.newHttpClient();
        
            Map<Object, Object> data = new HashMap<>();
            data.put("long_url", longURL);
        
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BITLY_API_URL))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + BITLY_ACCESS_TOKEN)
                    .POST(buildFormDataFromMap(data))
                    .build();
        
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        
            // Parse the response and get the shortened URL
            // Note: You should add proper error handling and response parsing here
            System.out.println("Bitly API Response: " + response.body());
        
            return response.body();
        }
        
        private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
            var builder = new StringBuilder();
            for (Map.Entry<Object, Object> entry : data.entrySet()) {
                if (builder.length() > 0) {
                    builder.append("&");
                }
                builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
                builder.append("=");
                builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
            }
            return HttpRequest.BodyPublishers.ofString(builder.toString());
        }
        
        public static void main(String[] args) {
            try {
                String longURL = "YOUR_LONG_URL_HERE";
                String shortenedURL = shortenURL(longURL);
                System.out.println("Shortened URL: " + shortenedURL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        return null;
    }
}