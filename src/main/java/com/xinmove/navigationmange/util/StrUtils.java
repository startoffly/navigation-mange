package com.xinmove.navigationmange.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Auther: startoffly
 * @Date: 2020/10/14 19:31
 * @Description:
 */
public class StrUtils {
    private StrUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String getFaviconByUrl(String url){

        try {
            if (!url.contains("http")){
                url = "http://"+ url;
            }
            URI uri = new URI(url);
            return uri.getHost()+"/favicon.ico";
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }


}
