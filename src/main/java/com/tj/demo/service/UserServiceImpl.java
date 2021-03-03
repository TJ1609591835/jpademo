package com.tj.demo.service;

import com.tj.demo.dao.UserRepository;
import com.tj.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * ClassName: UserService
 * Package: com.tj.demo.service
 * created By taojun
 * Description:
 *
 * @date: 2021/2/28 18:03
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User selectUserById(Integer id) {
//        Optional<User> a = userRepository.findById(1);
//        System.out.println(a.get().getId());
        return userRepository.selectUserById(id);
    }

    @Override
    @Transactional(dontRollbackOn = Exception.class)
    @SuppressWarnings(value={"unchecked"})
    public int updateUserById(String name, Long id) {
        return userRepository.updateUserById(name, id);
    }

    @Override
    public int save(){
        User user = new User();
        user.setUserId("111");
        user.setUserName("测试插入");
        userRepository.save(user);
        return 1;
    }

    @Override
    public int delete(Integer id) {
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
        return 1;
    }

    @Override
    public void pageAndSort() {
        // 创建用户
        User user = new User();
        user.setUserName("te");

        int pageNo = 1; // 当前页码
        int pageSize = 3;// 每页显示数量

        // 定义分页对象
        // 无需排序
        // PageRequest.of(pageNo - 1, pageSize);
        // 此为降序
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.DESC, "id");
        // 调用查询的方法
        Page<User> page = userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                // 获取条件对象
                Predicate perdicate = cb.conjunction();
                if (null != user) {
                    // 用户名
                    if (null != user.getUserName() && !user.getUserName().equals("")) {
                        // root.get("实体类属性名")
                        perdicate.getExpressions().add(cb.like(root.get("userName"), "%" + user.getUserName() + "%"));
                    }
                }
                return perdicate;
            }
        }, pageable);
        List<User> userList = page.getContent();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }
    }

    @Override
    public void queryByUserName() {
        User user = userRepository.queryByUserName("test");
        System.out.println(user.toString());
    }

    @Override
    public void findUserListByParam() {
        List<User> userList = userRepository.findUserListByParam("test");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }
    }
}
