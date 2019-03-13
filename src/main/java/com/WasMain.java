package com;

import com.config.ConfigGetter;
import com.httpserver.HttpServer;
import com.httpserver.requestHandler.RequestHandlerManager;

import java.io.IOException;

/**
 * Created by 1002074 on 2016. 4. 29..
 */
public class WasMain {

    public static void main(String[] args) {

        try {
            HttpServer server = new HttpServer();
            server.setConfig(ConfigGetter.getConfig("/httpTest/serverConfig.json"));

            RequestHandlerManager manager = new RequestHandlerManager();
            manager.putServlet(new Hello());

            server.setRequestHandlerManager(manager);
            server.start();

        }catch (IOException e) {

        }

    }



}
