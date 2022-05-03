package com.example.socket.client;



import java.net.*;
import java.io.*;
/**
 * @ClassName GreetingClient
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/4/25 20:22
 * @Version 1.0
 **/
public class GreetingClient {
    public static void main(String[] args) {
        String serverName = "127.0.0.1";
        int port = 8080;
        try {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
//            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}