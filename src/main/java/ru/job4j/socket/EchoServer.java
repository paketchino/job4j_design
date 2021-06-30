package ru.job4j.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader reader = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String read = reader.readLine();
                    while (!read.isEmpty() && read != null) {
                        if (read.contains("?msg=Exit")) {
                            server.close();
                        }
                        if (read.contains("?msg=Hello")) {
                            out.write("Hello, dear friend".getBytes());
                        } else {
                            out.write("What".getBytes());
                        }
                        read = reader.readLine();
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Messages not found", e);
        }
    }
}
