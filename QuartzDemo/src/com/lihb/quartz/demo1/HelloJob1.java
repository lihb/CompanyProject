package com.lihb.quartz.demo1;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob1 implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("��������ִ�У�ִ��ʱ�䣺"+ Calendar.getInstance().getTime());
	}

}
