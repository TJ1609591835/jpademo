package com.tj.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: User
 * Package: com.tj.demo.model
 * created By taojun
 * Description:
 *
 * @date: 2021/2/28 17:58
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Entity // jpa的注解, 需要加
@Table(name = "sys_user")
@Data
public class User implements Serializable {

    @Id
    /*@GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")*/
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_info")
    private String userInfo;

    @Column(name = "head_img")
    private byte[] headImg;

    @Column(name = "create_time")
    private Date createTime;
    public User(){}
}
