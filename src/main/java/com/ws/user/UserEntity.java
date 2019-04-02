package com.ws.user;

import com.ws.misc.BaseEntity;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gl on 2019/4/1.
 */
@Entity
@Table(name = "sm_user")
@SQLDelete(sql = "update sm_user t set t.deleted = now() where t.user_id=?")
public class UserEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 用户名
     */
    @Column
    private String userName;

    /**
     * 电话
     */
    @Column
    private String phone;

    /**
     * 密码
     */
    @Column
    private String password;


    @ManyToOne
    private UserGroupEntity userGroup;

    public UserGroupEntity getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupEntity userGroup) {
        this.userGroup = userGroup;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
