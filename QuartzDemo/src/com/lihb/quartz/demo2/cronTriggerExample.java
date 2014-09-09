package com.lihb.quartz.demo2;


import java.util.Date;

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
import org.quartz.impl.StdSchedulerFactory;

public class cronTriggerExample {
	
	public static void main(String[] args) throws Exception{
		
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		
		JobDetail job = JobBuilder.newJob(HelloJob2.class).withIdentity("job1", "group1").build();
		CronTrigger cronTrigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("4/5 * * * * ?")).build();
		scheduler.scheduleJob(job, cronTrigger);
		
		
		scheduler.start();
		
		/*Thread.sleep(65L * 1000L);
		
		scheduler.shutdown();
		*/
	}
}
