package org.example;
import java.io.*;
import java.net.*;

public class TCPClient {

    private static int BUFFERSIZE = 1024;

    public static void main(String[] args) throws IOException {

        byte[] fromUserBuffer = new byte[BUFFERSIZE];
        byte[] fromServerBuffer = new byte[BUFFERSIZE];

        try (Socket clientSocket = new Socket("localhost", 6789)) {
            int fromUserLength = System.in.read(fromUserBuffer);
            clientSocket.getOutputStream().write(fromUserBuffer, 0, fromUserLength);

            int fromServerLength = clientSocket.getInputStream().read(fromServerBuffer);
            System.out.print("FROM SERVER: ");
            System.out.write(fromServerBuffer, 0, fromServerLength);
        }
    }