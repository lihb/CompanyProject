package com.lihb.MyServices;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihb.service.UserService;

public class JobThreadRead implements Job{

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(new Date());
		
		//从redis中读取数据
		MyThreadRead t1 = new MyThreadRead();
		/*MyThreadWrite t2 = new MyThreadWrite(context1);
		MyThreadWrite t3 = new MyThreadWrite(context1);
		MyThreadWrite t4 = new MyThreadWrite(context1);
		MyThreadWrite t5 = new MyThreadWrite(context1);*/
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.execute(t1);              //启动线程
		/*pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);*/
		
	}

}
