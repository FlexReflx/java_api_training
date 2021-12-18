package navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {
    public static void main(String[] args) throws IOException {
        HttpServer serv = HttpServer.create(new InetSocketAddress(8000), 0);
        ExecutorService es = Executors.newFixedThreadPool(1);
        serv.createContext("/ping", new MyHandler());
        serv.start();
    }
}
class MyHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        byte [] response = "Welcome Real's HowTo test page".getBytes();
        t.sendResponseHeaders(200, response.length);
        OutputStream os = t.getResponseBody();
        os.write(response);
        os.close();
    }
}

