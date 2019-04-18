package com.ws.task;

import com.ws.advice.JsonResponse;
import com.ws.config.EnvironmentHelper;
import com.ws.misc.BaseController;
import com.ws.platform.DateUtil;
import org.joda.time.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * create by gl
 * on 2019/4/4
 */

@Controller
@ResponseBody
@RequestMapping(value = "/test")
public class TestTaskLogController extends BaseController {


    private Logger logger = LoggerFactory.getLogger(TestTaskLogController.class);


    @Autowired
    private TaskLogService taskLogService;

    @Autowired
    private TaskLogRepository taskLogRepository;

    @Autowired
    private EnvironmentHelper environmentHelper;


    /**
     *   传入的时间格式      yyyy/MM/dd
      curl -XGET http://127.0.0.1:9000/test/updateTaskLog?date=2017/03/18
     *
     * @param date
     * @return
     */
    @RequestMapping(value = "/updateTaskLog", method = RequestMethod.GET)
    public JsonResponse updateTaskLog(String date){
        Date workDay = DateUtil.parseSqlDate(date);
        taskLogRepository.deleteByWorkDayAndType(new java.sql.Date(workDay.getTime()), TaskType.ONE);
        DateTimeUtils.setCurrentMillisFixed(workDay.getTime());

        new Thread(() -> {
            taskLogService.execute("Test", TaskType.ONE, ()->{
                logger.debug("-------------TaskType.ONE---------------");
            });
        }).start();

        return responseVoid();
    }

    /**
     *
     curl -XGET http://127.0.0.1:9000/test/currentEnvironment
     *
     *
     * @return
     */
    @RequestMapping(value = "/currentEnvironment", method = RequestMethod.GET)
    public JsonResponse currentEnvironment(){
        logger.debug(environmentHelper.currentEnvironment());
        return responseVoid();
    }

}
