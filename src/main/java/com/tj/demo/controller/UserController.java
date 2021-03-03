package com.tj.demo.controller;

import com.tj.demo.model.User;
import com.tj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: UserController
 * Package: com.tj.demo.controller
 * created By taojun
 * Description:
 *
 * @date: 2021/2/28 18:07
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 得到所有用户
     */
    @GetMapping(value = "/getAllUser", produces = {"application/json;charset=UTF-8"})
    public void getAllUser() {
        List<User> userList = userService.getAllUser();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    /**
     * 根据id查询用户
     */
    @GetMapping(value = "/selectUserById", produces = {"application/json;charset=UTF-8"})
    public void selectUserById() {
        User user = userService.selectUserById(1);
        System.out.println(user);
    }

    /**
     * 更新操作
     */
    @GetMapping(value = "/updateUserById", produces = {"application/json;charset=UTF-8"})
    public void updateUserById() {
        int count = userService.updateUserById("测试jpa修改", 1L);
        System.out.println(count);
    }

    /**
     * 保存操作
     */
    @GetMapping(value = "/save", produces = {"application/json;charset=UTF-8"})
    public void save(){
        System.out.println(userService.save());
    }

    /**
     * 删除操作
     */
    @GetMapping(value = "/delete/{id}", produces = {"application/json;charset=UTF-8"})
    public void delete(@PathVariable("id") Integer id){
        System.out.println(userService.delete(id));
    }

    /**
     * 分页操作
     */
    @GetMapping(value = "/pageAndSort", produces = {"application/json;charset=UTF-8"})
    public void pageAndSort(){
        userService.pageAndSort();
    }

    @GetMapping(value = "/queryByUserName", produces = {"application/json;charset=UTF-8"})
    public void queryByUserName(){
        userService.queryByUserName();
    }

    @GetMapping(value = "/findUserListByParam", produces = {"application/json;charset=UTF-8"})
    public void findUserListByParam(){
        userService.findUserListByParam();
    }

}
