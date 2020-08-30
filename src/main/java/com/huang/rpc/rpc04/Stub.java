package com.huang.rpc.rpc04;

import com.huang.rpc.common.User;
import com.huang.rpc.common.UserService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {

    public static UserService getStub() {
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("localhost", 9999);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Info info = new Info();
                info.setMethod(method.getName());
                info.setParameterTypes(method.getParameterTypes());
                info.setParams(args);
                oos.writeObject(info);
                oos.flush();

                ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());
                User user = (User) dis.readObject();
                dis.close();
                oos.close();
                return user;
            }
        };
        return (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, handler);
    }
}
