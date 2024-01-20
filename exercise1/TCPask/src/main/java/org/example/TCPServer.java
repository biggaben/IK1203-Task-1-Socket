package org.example;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class TCPServer {

    static int BUFFERSIZE = 1024;

    public static void main(String[] args) throws IOException {

        try (ServerSocket welcomeSocket = new ServerSocket(6789)) {

            while (true) {
                try (Socket connectionSocket = welcomeSocket.accept()) {
                    byte[] fromClientBuffer = new byte[BUFFERSIZE];
                    int fromClientLength = connectionSocket.getInputStream().read(fromClientBuffer);

                    String clientSentence = new String(fromClientBuffer, 0, fromClientLength, StandardCharsets.UTF_8);
                    String capitalizedSentence = clientSentence.toUpperCase();
                    byte[] toClientBuffer = capitalizedSentence.getBytes(StandardCharsets.UTF_8);

                    connectionSocket.getOutputStream().write(toClientBuffer);
                }
            }
        }
    }
}
