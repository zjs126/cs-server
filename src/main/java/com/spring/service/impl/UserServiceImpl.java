package com.spring.service.impl;


import com.spring.mapper.UserMapper;
import com.spring.pojo.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //    @Override
//    public PageBean page(Integer page, Integer pageSize, String name, Short gender, String begin, String end) {
//        PageHelper.startPage(page,pageSize);
//
//        List<Emp> empList =empMapper.list(name, gender, begin, end);
//        Page<Emp> p =(Page<Emp>) empList;
//
//        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
//        return pageBean;
//    }
//

    @Override
    public void register(User user) {
        userMapper.register(user);
        return;
    }

    @Override
    public User loginByUsernameAndPassword(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public User loginByEmailAndPassword(User user) {
        return userMapper.getByEmailAndPassword(user);
    }

    @Override
    public User UserSearch(Integer id, String username) {
        return userMapper.UserSearch(id, username);
    }

    @Override
    public User searchUserbyName(String username) {
        return userMapper.searchUserbyName(username);
    }

    @Override
    public void UpdateUser(User user) {
        userMapper.updateById(user);
    }
}
