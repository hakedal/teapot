/*
 * Build: 
 * $ javac App.java && jar cfe app.jar App App.class
 * Run: 
 * $ java -jar app.jar
 */ 

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class App {
    public static void main(String[] args) throws Exception{
        new App().run(8080);
    }
    private void run(final int port) throws Exception{
        final HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", (HttpExchange exchange) -> {
            final String response = "I'm a teapot";
            exchange.sendResponseHeaders(418, response.length());
            try (final OutputStream stream = exchange.getResponseBody()) {
                stream.write(response.getBytes());
                stream.close();
            }
        } );
        server.start();
    }
}