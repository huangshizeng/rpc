package com.huang.rpc.rpc02;

import com.huang.rpc.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Stub {

    public User findUserById(Long id) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeLong(123);
        oos.flush();

        ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());
        User user = (User) dis.readObject();
        dis.close();
        oos.close();
        return user;
    }
}
