package com.tj.demo.dao;

import com.tj.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: StudentRepository
 * Package: com.tj.demo.dao
 * created By taojun
 * Description:
 *
 * @date: 2021/3/1 15:10
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
