package com.gdpu.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.gdpu.common.vo.Result;
import com.gdpu.common.vo.UserQuery;
import com.gdpu.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    User login(User param);

    User getUserById(String id);

    User getUserById(Integer id);

    List<User> getUserList(UserQuery param);

    Long getUserListNum(UserQuery param);

    User getUserByUsername(String username);

    boolean isAdmin(User user);

    int deleteUserByIds(Integer[] ids);

    int updateUser(User param);

    int register(User param);
}
