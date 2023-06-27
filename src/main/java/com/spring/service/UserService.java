package com.spring.service;

import com.spring.pojo.User;

/**
 * 员工管理
 */
public interface UserService {

    void register(User user);
    User loginByUsernameAndPassword(User user);

    User loginByEmailAndPassword(User user);

    User UserSearch(Integer id, String username);

    User searchUserbyName(String username);

    void UpdateUser(User user);
}
