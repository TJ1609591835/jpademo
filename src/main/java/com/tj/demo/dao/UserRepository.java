package com.tj.demo.dao;

import com.tj.demo.model.User;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: UserRepository
 * Package: com.tj.demo.dao
 * created By taojun
 * Description:
 *
 * @date: 2021/2/28 18:03
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    @Query(value = "select s from User s where s.id = ?1")
    User selectUserById(Integer id);

    @Query(value = "update User s set s.userName = ?1 where s.id = ?2")
    @Modifying
    int updateUserById(String name, Long id);

    /* 根据类型进行全检索 */
//    List<User> queryByUserNameLike(String userName);
    User queryByUserName(String userName);

    @Query("from User where userName like %:userName%")
    List<User> findUserListByParam(@Param("userName")String userName);
}
