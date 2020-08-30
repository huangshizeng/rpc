package com.huang.rpc.rpc03;

import com.huang.rpc.common.UserService;

public class Client {

    public static void main(String[] args) throws Exception {
        UserService userService = Stub.getStub();
        System.out.println(userService.findUserById(123L));
    }
}
