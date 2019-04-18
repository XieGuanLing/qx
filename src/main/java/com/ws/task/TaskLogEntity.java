package com.ws.task;

import com.ws.misc.BaseEntity;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 记录后台定时任务执行情况
 *  Created by gl on 2019/4/1.
 */
@Entity
@Table(name = "sm_task_log")
@SQLDelete(sql = "update sm_task_log t set t.deleted = now() where t.task_log_id=?")
public class TaskLogEntity extends BaseEntity {

    private static final long serialVersionUID = -1L;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskLogId;


    @NotNull
    @Column(nullable = false)
    private Boolean finished = false;

    @NotNull
    @Column(nullable = false)
    private TaskType type;

    @NotNull
    @Column(nullable = false)
    private java.sql.Date workDay = new java.sql.Date(System.currentTimeMillis());

    public TaskLogEntity() {
    }


    public TaskLogEntity(TaskType type) {
        this.type = type;
    }

    public Long getTaskLogId() {
        return taskLogId;
    }

    public void setTaskLogId(Long taskLogId) {
        this.taskLogId = taskLogId;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public java.sql.Date getWorkDay() {
        return workDay;
    }

    public void setWorkDay(java.sql.Date workDay) {
        this.workDay = workDay;
    }


}
