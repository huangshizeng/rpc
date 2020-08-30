package com.huang.rpc.rpc02;

import com.huang.rpc.common.User;
import com.huang.rpc.common.UserService;

public class UserServiceImpl implements UserService {

    public User findUserById(long id) {
        User user = new User();
        user.setId(id);
        user.setName("黄世增" + id);
        return user;
    }
}
