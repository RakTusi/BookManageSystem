package com.gdpu.mapper;

import com.gdpu.common.vo.UserQuery;
import com.gdpu.entity.User;

import java.util.List;

public interface UserMapper {
    User getUserByUsername(String username);

    User getUserById(Integer id);

    List<User> find(UserQuery param);

    Long findNum(UserQuery param);

    int deleteUserByIds(Integer[] ids);

    int updateUser(User param);

    int addUser(User param);
}
