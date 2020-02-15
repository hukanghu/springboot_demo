package com.example.demo.controller;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.CronTestConfiguration;
import com.example.demo.utils.MyRunnable1;
import com.example.demo.utils.MyRunnable2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/task")
public class DynamicTaskController {

	@Autowired
	private CronTestConfiguration cronTestConfiguration;
	
	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
	private ScheduledFuture future1;
	
	private ScheduledFuture future2;
	
	
	@RequestMapping(value = "/startCron1", produces = "application/json;charset=UTF-8")
	@ApiOperation("开启定时任务1")
	public String startCrons() {
		
		/**
         * ThreadPoolTaskScheduler：线程池任务调度类，能够开启线程池进行任务调度。
         * ThreadPoolTaskScheduler.schedule()方法会创建一个定时计划ScheduledFuture，在这个方法需要添加两个参数，
         * Runnable（线程接口类） 和CronTrigger（定时任务触发器）
         * YouXinConfiguration：自定义读取yml文件中数据的类，通过该类读取yml文件中cron时间表达式，从而可以达到定时时间可配置的效果。
         * MyRunnable1与MyRunnable2类：这两个类都是实现了Runnable接口，重写了run方法，定时任务的逻辑代码就是在其中实现。
         */
        future1 = threadPoolTaskScheduler.schedule(new MyRunnable1(), new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                return new CronTrigger(cronTestConfiguration.getCron1()).nextExecutionTime(triggerContext);
            }
        });
        System.out.println("DynamicTask.startCron1()");
        //转换为json数据
        JSONObject result = new JSONObject();
        result.put("data","success");
        System.out.println(result.toJSONString());
        return result.toJSONString();
    }

	@RequestMapping(value = "/stopCron1", produces = "application/json;charset=UTF-8")
    @ApiOperation("关闭定时任务1")
    public String stopCron1() {
        if (future1 != null) {
            future1.cancel(true);
        }
        System.out.println("DynamicTask.stopCron1()");
      //转换为json数据
        JSONObject result = new JSONObject();
        result.put("data","success");
        System.out.println(result.toJSONString());
        return result.toJSONString();
    }
	
	@RequestMapping("/startCron2")
	@ApiOperation("开启定时任务 2")
	public String startCrons2() {
		
		/**
         * ThreadPoolTaskScheduler：线程池任务调度类，能够开启线程池进行任务调度。
         * ThreadPoolTaskScheduler.schedule()方法会创建一个定时计划ScheduledFuture，在这个方法需要添加两个参数，
         * Runnable（线程接口类） 和CronTrigger（定时任务触发器）
         * YouXinConfiguration：自定义读取yml文件中数据的类，通过该类读取yml文件中cron时间表达式，从而可以达到定时时间可配置的效果。
         * MyRunnable1与MyRunnable2类：这两个类都是实现了Runnable接口，重写了run方法，定时任务的逻辑代码就是在其中实现。
         */
        future2 = threadPoolTaskScheduler.schedule(new MyRunnable2(), new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                return new CronTrigger(cronTestConfiguration.getCron2()).nextExecutionTime(triggerContext);
            }
        });
        System.out.println("DynamicTask.startCron2()");
        return "success";
    }

	@RequestMapping("/stopCron2")
    @ApiOperation("关闭定时任务2")
    public String stopCron2() {
        if (future2 != null) {
            future2.cancel(true);
        }
        System.out.println("DynamicTask.stopCron2()");
        return "success";
    }
	
	
}
