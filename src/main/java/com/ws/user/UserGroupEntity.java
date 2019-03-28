package com.ws.user;

import com.ws.misc.BaseEntity;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

/**
 * create by gl
 * on 2019/3/25
 */
@Entity
@Table(name = "sm_user_group")
@SQLDelete(sql = "update sm_user_group t set t.deleted = now() where t.user_group_id=?")
public class UserGroupEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    /**
     * 用户名
     */
    @Column
    private String groupName;


    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
