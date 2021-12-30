package fr.lernejo.navy_battle;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Integer.parseInt;

public class Launcher {
    static class MyHandler implements HttpHandler {

        private final String RESPONSE = "OK";

        public void handle(HttpExchange t) throws IOException {
            t.sendResponseHeaders(200, RESPONSE.length());
            OutputStream os = t.getResponseBody();
            os.write(RESPONSE.getBytes());
            os.close();
        }
    }
    static class JsonHandler implements HttpHandler {

        private final String RESPONSE = "OK";

        public void handle(HttpExchange t) throws IOException {
            t.sendResponseHeaders(200, RESPONSE.length());
            OutputStream os = t.getResponseBody();
            os.write(RESPONSE.getBytes());
            os.close();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(args.length);
        if (args.length > 0) {
            if (args.length == 1) {
                if (parseInt(args[0]) < 10000) {
                    HttpServer serv = HttpServer.create(new InetSocketAddress(parseInt(args[0])), 0);
                    ExecutorService es = Executors.newFixedThreadPool(1);
                    serv.createContext("/ping", new MyHandler());
                    serv.createContext("/api/game/start", new JsonHandler());
                    System.out.println("heeeee");
                    serv.start();
                }else{
                    throw new IllegalArgumentException("port trop grand");
                }
            }


        }else{
            throw new IOException();
        }
    }
}



