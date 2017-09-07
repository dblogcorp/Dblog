package io.dblog.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Pelin on 17/7/26.
 */
public class HttpUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static String getJson(String urlStr, Integer timeOut) {
        if (StringUtils.isBlank(urlStr)) {
            return null;
        }

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        HttpURLConnection httpUrlConn = null;

        try {
            URL url = new URL(urlStr);

            httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setConnectTimeout(timeOut);
            httpUrlConn.setReadTimeout(timeOut);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder builder = new StringBuilder();
            String str;
            while (null != (str = bufferedReader.readLine())) {
                builder.append(str).append("\n");
            }

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Occurred an Exception in HttpUtils, url is " + urlStr);
            return null;
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (httpUrlConn != null) {
                    httpUrlConn.disconnect();
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
