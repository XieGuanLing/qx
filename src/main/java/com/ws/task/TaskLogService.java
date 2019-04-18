package com.ws.task;

import com.ws.cache.LockService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * create by gl
 * on 2019/4/4
 */
@Service
public class TaskLogService {

    private Logger logger = LoggerFactory.getLogger(TaskLogService.class);

    @Autowired
    private LockService lockService;


    @Autowired
    private TaskLogRepository taskLogRepository;

    /**
     * 先检查是否已经执行
     *
     * @param lockKey
     * @param taskType
     * @param task
     */
    @Transactional
    public void execute(String lockKey, TaskType taskType, Runnable task) {

        logger.debug("schedule task[" + taskType + "] started.");

        lockService.lockOnWrite(lockKey,
                () -> {
                    //使用DateTimeUtils.setCurrentMillisFixed()设置当前时间，这样就可以重复执行
                    java.sql.Date currentDay = new java.sql.Date(new DateTime().getMillis());
                    if (taskLogRepository.findByWorkDayAndType(currentDay, taskType) != null)
                        return;

                    taskLogRepository.saveAndFlush(new TaskLogEntity(taskType));

                    task.run();

                    java.sql.Date workDay = new java.sql.Date(System.currentTimeMillis());
                    taskLogRepository.updateFinishedAndLastUpdatedByWorkDayAndType(new Date(),
                            workDay,
                            taskType);
                });
        logger.debug("schedule task[" + taskType + "] finished.");

    }



}
