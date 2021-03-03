package com.tj.demo.service;

import com.tj.demo.dao.RoleRepository;
import com.tj.demo.dao.StudentRepository;
import com.tj.demo.model.Grade;
import com.tj.demo.model.Role;
import com.tj.demo.model.Student;
import com.tj.demo.model.TJUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleRepository roleRepository;

    @Transactional(dontRollbackOn = Exception.class)
    @Override
    public void saveManyToOne(){
        Role role = new Role("角色名");
        // 创建两个用户
        TJUser user1 = new TJUser();
        user1.setUserName("陶军1");
        user1.setRole(role);
        TJUser user2 = new TJUser();
        user2.setUserName("陶军2");
        user2.setRole(role);

        // 设置关系
        role.getUsers().add(user1);
        role.getUsers().add(user2);

        roleRepository.save(role);
    }
}
