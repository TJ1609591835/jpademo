package com.tj.demo.service;

import com.tj.demo.dao.StudentRepository;
import com.tj.demo.model.Grade;
import com.tj.demo.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * ClassName: StudentServiceImpl
 * Package: com.tj.demo.service
 * created By taojun
 * Description:
 *
 * @date: 2021/3/1 15:11
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentRepository studentRepository;

    @Override
    public void save() {
        Grade grade = new Grade();
        grade.setGradeName("n年级");
        Student student = new Student("陶军");
        student.setGrade(grade);
        studentRepository.save(student);
    }

    @Override
    public void selectPersist() {
        Optional<Student> student = studentRepository.findById(1);
        System.out.println(student.toString());
        System.out.println(student.get().getGrade());
    }
}
