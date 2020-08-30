package com.huang.rpc.rpc02;

import com.huang.rpc.common.User;
import com.huang.rpc.common.UserService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            System.out.println("等待连接...");
            Socket socket = serverSocket.accept();
            System.out.println("接连成功");
            process(socket);
        }
    }

    public static void process(Socket socket) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        long id = ois.readLong();
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(id);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(user);
        oos.flush();
        oos.close();
        ois.close();
    }
}
