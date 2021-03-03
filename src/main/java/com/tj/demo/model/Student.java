package com.tj.demo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: Student
 * Package: com.tj.demo.model
 * created By taojun
 * Description:
 *
 * @date: 2021/3/1 15:05
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Entity
@Table(name = "t_student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
