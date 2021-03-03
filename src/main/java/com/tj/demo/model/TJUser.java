package com.tj.demo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: TJUser
 * Package: com.tj.demo.model
 * created By taojun
 * Description:
 *
 * @date: 2021/3/1 16:26
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Entity
@Table(name = "t_user")
public class TJUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;

    // 多个用户对应一个角色(多对一)
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public TJUser(String userName) {
        this.userName = userName;
    }

    public TJUser() {
    }

    @Override
    public String toString() {
        return "TJUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
