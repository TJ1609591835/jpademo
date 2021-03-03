package com.tj.demo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: Grade
 * Package: com.tj.demo.model
 * created By taojun
 * Description:
 *
 * @date: 2021/3/1 15:02
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Entity
@Table(name = "t_grade")
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String gradeName;

    // 一对一
    // 维护外键关联关系
    @OneToOne(mappedBy = "grade")
    private Student student;

    public Grade(String gradeName) {
        this.gradeName = gradeName;
    }

    public Grade() {
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
