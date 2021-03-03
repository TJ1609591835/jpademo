package com.tj.demo.service;

import com.tj.demo.model.User;

import java.util.List;

/**
 * ClassName: UserService
 * Package: com.tj.demo.service
 * created By taojun
 * Description:
 *
 * @date: 2021/2/28 18:05
 * @author: taojun
 * @email: 1609591835@qq.com
 */
public interface UserService {
    List<User> getAllUser();

    User selectUserById(Integer id);

    int updateUserById(String name, Long id);

    int save();

    int delete(Integer id);

    void pageAndSort();

    void queryByUserName();

    void findUserListByParam();
}
