package com.lihb.quartz.cronTriggerDemo;


import java.util.Date;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * ´¥·¢Æ÷Àà
 * @author lihb
 *
 */
public class SimpleExample {
	
	public static void main(String[] args) throws Exception{
		
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();	
		
		List<JobEntity> jobList = DataWork.getAllJob();
		
		for (JobEntity jobEntity : jobList) {
			TriggerKey triggerKey = TriggerKey.triggerKey(jobEntity.getJobName(), jobEntity.getJobGroup());
			
			CronTrigger trigger =(CronTrigger)scheduler.getTrigger(triggerKey);
			
			if(null == trigger){
				
				JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
						.withIdentity(jobEntity.getJobName(), jobEntity.getJobGroup()).build();
				
				jobDetail.getJobDataMap().put("jobEntity", jobEntity);
				
				//CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobEntity.getCronExpression());
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/2 * * * ?");
				
				trigger = TriggerBuilder.newTrigger()
						.withIdentity(jobEntity.getJobName(), jobEntity.getJobGroup())
						.withSchedule(scheduleBuilder).build();
				
				scheduler.scheduleJob(jobDetail, trigger);
				
			}else{
				
				//CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobEntity.getCronExpression());
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/2 * * * ?");
				
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				
				scheduler.rescheduleJob(triggerKey, trigger);
			}
		}
		
		scheduler.start();
		
		/*
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();		
		
		Date runTime = DateBuilder.nextGivenSecondDate(null, 3);		
		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();			
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();		
		scheduler.scheduleJob(job, trigger);
		
		job = JobBuilder.newJob(HelloJob.class).withIdentity("job2","group1").build();
		trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1").startAt(runTime).build();
		scheduler.scheduleJob(job, trigger);
		
		job = JobBuilder.newJob(HelloJob.class).withIdentity("job3","group1").build();
		trigger = TriggerBuilder.newTrigger().withIdentity("trigger3", "group1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(3)).startAt(runTime).build();
		scheduler.scheduleJob(job, trigger);
		
		scheduler.start();
		
		Thread.sleep(65L * 1000L);
		
		scheduler.shutdown();*/
		
		
		
	}
}
