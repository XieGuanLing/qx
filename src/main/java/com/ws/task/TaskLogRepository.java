package com.ws.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 *  Created by gl on 2019/4/1.
 */
@Repository
public interface TaskLogRepository extends JpaRepository<TaskLogEntity,Long> {

    TaskLogEntity findByWorkDayAndType(java.sql.Date workDay, TaskType taskType);

    @Modifying
    @Query("update #{#entityName} log set log.lastUpdated=?1 where log.workDay=?2 and log.type=?3")
    Integer updateLastUpdatedByWorkDayAndType( Date lastUpdated, java.sql.Date workDay, TaskType taskType);

    @Transactional
    @Modifying
    @Query("update #{#entityName} log set log.finished=true,log.lastUpdated=?1 where log.workDay=?2 and log.type=?3")
    Integer updateFinishedAndLastUpdatedByWorkDayAndType(Date lastUpdated, java.sql.Date workDay, TaskType taskType);

    @Transactional
    Integer deleteByWorkDayAndType(java.sql.Date workDay, TaskType taskType);

}
