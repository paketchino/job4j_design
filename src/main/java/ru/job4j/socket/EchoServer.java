package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader reader = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    for (String str = reader.readLine(); str != null && !str.isEmpty(); str = reader.readLine()) {
                        System.out.println(str);
                        if (str.contains("=Hello")) {
                            out.write("HTTP/1.1 200 HELLO\r\n".getBytes());
                        }
                        if (str.contains("=Exit")) {
                            server.isClosed();
                        }
                        if (str.contains("WHAT")) {
                            out.write("HTTP/1.1 200 WHAT\r\n".getBytes());
                        }
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Hello, dear friend.".getBytes());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}