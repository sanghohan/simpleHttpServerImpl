package com;

import com.httpserver.httpRequset.SimpleHttpRequest;
import com.httpserver.httpRequset.SimpleHttpResponse;
import com.httpserver.requestHandler.SimpleHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by 1002074 on 2016. 4. 30..
 */
public class Hello implements SimpleHandler {

    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    @Override
    public void service(SimpleHttpRequest req, SimpleHttpResponse response) {

        logger.info("Start service...");

        try {
            Date now = new Date();
            String body = new StringBuilder("<HTML>\r\n").append("<HEAD><TITLE>test Servlet</TITLE>\r\n").append("</HEAD>\r\n")
                    .append("<BODY>")
                    .append("<H1>HTTP Test </H1>\r\n")
                    .append("Hello "+ now.toString())
                    .append("</BODY></HTML>\r\n").toString();
            if (req.getVersion().startsWith("HTTP/")) { // send a MIME header
                response.sendHeader("HTTP/1.0 200 OK",
                        "text/html; charset=utf-8", body.length());
            }

            logger.info("wirte sokect : " + body);
            response.writeBody(body);

        }catch (Exception e) {

        }

    }
}