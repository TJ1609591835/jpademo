package com.tj.demo.controller;

import com.tj.demo.service.RoleService;
import com.tj.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: StudentController
 * Package: com.tj.demo.controller
 * created By taojun
 * Description:
 *
 * @date: 2021/3/1 15:13
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/saveManyToOne", produces = {"application/json;charset=UTF-8"})
    public void saveManyToOne(){
        roleService.saveManyToOne();
    }

}
