package cn.com.cworks.javanet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description SocketServer
 * @Author LuChao
 * @Date 2020/9/4
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            Socket server = null;
            try {
                ServerSocket serverSocket = new ServerSocket(Client.PORT);
                System.out.printf("Server started. %d Waiting ...%n", serverSocket.getLocalPort());
                server = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
                System.out.println("Get message: " + dataInputStream.readUTF());
                DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
                outputStream.writeUTF("Get Your Message.Bye.");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != server) {
                    try {
                        server.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
