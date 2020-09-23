package cn.com.cworks.javanet;

import java.io.*;
import java.net.Socket;

/**
 * @Description Socket Client Demo
 * @Author LuChao
 * @Date 2020/9/4
 * @Version 1.0
 */
public class Client {
    private static final String SERVER_NAME = "localhost";
    public static final Integer PORT = 9009;

    public static void main(String[] args) {
        Socket clientSocket = null;
        try {
            System.out.printf("Connecting to Server: %s:%d%n", SERVER_NAME, PORT);
            clientSocket = new Socket(SERVER_NAME, PORT);
            System.out.println("Success, IP address is: " + clientSocket.getRemoteSocketAddress());

            OutputStream outputStream = clientSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            dataOutputStream.writeUTF("Hello from " + clientSocket.getLocalSocketAddress());
            InputStream inputStream = clientSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println(dataInputStream.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != clientSocket) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
