package com.lihb.quartz.demo1;


import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleExample1 {
	
	public static void main(String[] args) throws Exception{
		
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		
		JobDetail job = JobBuilder.newJob(HelloJob1.class).withIdentity("job1", "group1").build();
		
		Date runTime = DateBuilder.evenMinuteDate(new Date());
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
		
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
		Thread.sleep(65L * 1000L);
		scheduler.shutdown();
		
		
	}
}
