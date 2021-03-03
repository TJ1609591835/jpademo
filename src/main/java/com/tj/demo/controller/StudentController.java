package com.tj.demo.controller;

import com.tj.demo.model.Student;
import com.tj.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 保存学生的时候, 保存年级
     * 猜想: 先保存年级回显给学生表的字段, 在添加学生对象
     */
    @GetMapping(value = "/save1", produces = {"application/json;charset=UTF-8"})
    public void save1(){
        studentService.save();
    }

    @GetMapping(value = "/selectPersist", produces = {"application/json;charset=UTF-8"})
    public void selectPersist() {
        studentService.selectPersist();
    }

}
