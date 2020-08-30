package com.huang.rpc.rpc01;

import com.huang.rpc.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeLong(123);
        oos.flush();

        ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());
        User user = (User) dis.readObject();
        System.out.println(user);

        dis.close();
        oos.close();
    }
}
