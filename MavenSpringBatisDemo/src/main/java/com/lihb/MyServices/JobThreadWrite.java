package com.lihb.MyServices;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JobThreadWrite implements Job{

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("开始读取数据。"+new Date());
		ApplicationContext context1 = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		int nThread = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(nThread * 2); //采用java线程池管理线程
		
		System.out.println("开始往redis放数据。。。Job");
		MyThreadWrite toRedis = null;
		
		GetThreadNum getThreadNum = (GetThreadNum) context1.getBean("getThreadNum");
		getThreadNum.getNumAndResidue();
		int num = getThreadNum.getNum();//获取线程数目
		int residue = getThreadNum.getResidue(); //获取余数
		int sum = getThreadNum.getSum();
		System.out.println("sum:"+sum+",num:"+num+",residue:"+residue);
		if(num < 1){             //数据条数小于RECORD_NUM,单线程处理  
			toRedis = new MyThreadWrite(1, sum);  
			toRedis.start = 1;  
			toRedis.end = sum;  
            Thread t1=new Thread(toRedis);  
            t1.start();  
        }else{         //大于RECORD_NUM时
        	for (int i = 0; i < num + 1; i++) {
        		pool.execute(new MyThreadWrite(i));  //将线程放入线程池
			}
        } 
		pool.shutdown();
		System.out.println("读取完毕。"+new Date());
		
		
		//处理掉余数  
		/*toRedis=new MyThreadWrite(num * GetThreadNum.RECORD_NUM + 1, sum);  
        Thread t1=new Thread(toRedis);  
        t1.start(); */
        
	}

}
