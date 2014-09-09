package com.lihb.quartz.demo2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob2 implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String jobName = context.getJobDetail().getKey().getName();
		System.out.println("任务Key"+jobName+"正在执行，执行时间："+ sdf.format(Calendar.getInstance().getTime()));
	}

}
