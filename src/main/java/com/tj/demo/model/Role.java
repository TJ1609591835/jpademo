package com.tj.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Role
 * Package: com.tj.demo.model
 * created By taojun
 * Description:
 *
 * @date: 2021/3/1 16:23
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private Set<TJUser> users = new HashSet<TJUser>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<TJUser> getUsers() {
        return users;
    }

    public void setUsers(Set<TJUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }
}
