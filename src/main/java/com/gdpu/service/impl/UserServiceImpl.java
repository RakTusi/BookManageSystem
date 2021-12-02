package com.gdpu.service.impl;

import com.gdpu.common.vo.UserQuery;
import com.gdpu.entity.User;
import com.gdpu.mapper.UserMapper;
import com.gdpu.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User param) {
        User user = userMapper.getUserByUsername(param.getUsername());
        if (user != null) {
            //1. 找到该用户，比对密码
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(param.getPassword(), user.getPassword())) {
                //2. 比对成功，登录成功
                //保证用户隐私安全，去除原生密码
                user.setPassword(null);
                return user;
            } else {
                //3. 比对失败，登录失败
                return null;
            }
        } else {
            //4. 未找到该用户，登录失败
            return null;
        }

    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(Integer.parseInt(id));
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUserList(UserQuery param) {
        return userMapper.find(param);
    }

    @Override
    public Long getUserListNum(UserQuery param) {
        return userMapper.findNum(param);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public boolean isAdmin(User user) {
        return user.getStatus() != null && user.getStatus() == User.STATUS_ADMIN;
    }

    @Override
    public int deleteUserByIds(Integer[] ids) {
        return userMapper.deleteUserByIds(ids);
    }

    @Override
    public int updateUser(User param) {
        return userMapper.updateUser(param);
    }

    @Override
    public int register(User param) {
        User user = userMapper.getUserByUsername(param.getUsername());
        if (user != null) {
            return -1;
        }
        //设置默认信息
        param.setState(User.STATE_NORMAL);
        param.setStatus(User.STATUS_USER);
        param.setBalance(0);
        param.setCredit(100);
        //给密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        param.setPassword(passwordEncoder.encode(param.getPassword()));
        //添加注册时间
        param.setRegisterTime(new Date());
        return userMapper.addUser(param);
    }
}