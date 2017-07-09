package cn.wust.task;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by root on 17-5-15.
 */
public class TaskTest {


    private final static String JOB_GROUP_NAME = "QUARTZ_JOBGROUP_NAME";//任务组
    private final static String TRIGGER_GROUP_NAME = "QUARTZ_TRIGGERGROUP_NAME";//触发器组

    public static void addJob (String jobName, String triggerName, Class<?extends Job> jobClass,int seconds) throws SchedulerException {

        //创建一个工厂实例
        SchedulerFactory sf = new StdSchedulerFactory();

        //通过SchedulerFactory构建Scheduler对象
        Scheduler scheduler = sf.getScheduler();

        //用于描述Job实现类及其他的一些静态信息，构建一个作业实例
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobName,JOB_GROUP_NAME).build();

        //构建一个触发器，规定出发的规则
        Trigger trigger = TriggerBuilder.newTrigger()//创建一个新的TriggerBuilder来规范一个触发器
                .withIdentity(triggerName,TRIGGER_GROUP_NAME)//给触发器起一个名字和组名
                .startNow()//立即执行
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(seconds)//时间间隔秒
                        .repeatForever()//一直执行
                ).build();//产生触发器

        //向Scheduler中添加job任务和trigger触发器
        scheduler.scheduleJob(jobDetail,trigger);

        //启动
        scheduler.start();
    }

    public static void main(String[] args) {
        try {
            addJob("job1","trigger1",TestOne.class,2);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
