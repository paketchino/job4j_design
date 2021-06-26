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
                    String read = reader.readLine();
                    while (!read.isEmpty() && read != null) {
                        if (read.contains("msg=Exit")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            server.close();
                        }
                        if (read.contains("msg=Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello, dear friend".getBytes());
                        } else {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("What".getBytes());
                        }
                        read = reader.readLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
