package com.lihb.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihb.MyServices.MyThreadWrite;
import com.lihb.service.UserService;

public class ThreadTest {

	/*
	 * static MyThread myThread;
	 * 
	 * @BeforeClass public static void getThread(){
	 * 
	 * @SuppressWarnings("resource") ApplicationContext context = new
	 * ClassPathXmlApplicationContext("applicationContext.xml"); myThread = new
	 * MyThread(context);
	 * 
	 * 
	 * }
	 * 
	 * @Test public void ReadDB(){ System.out.println("begin");
	 * 
	 * Thread t = new Thread(myThread); t.start(); System.out.println("end");
	 * 
	 * }
	 */

	public static void main(String[] args){
		/*System.out.println("begin");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 MyThread myThread = new MyThread(context);
		 Thread t = new Thread(myThread);
		 t.start();
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println("end");
		*/
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
		long  length = userService.countAll();
		
		MyThreadWrite t1 = new MyThreadWrite(context);
		MyThreadWrite t2 = new MyThreadWrite(context);
		MyThreadWrite t3 = new MyThreadWrite(context);
		MyThreadWrite t4 = new MyThreadWrite(context);
		MyThreadWrite t5 = new MyThreadWrite(context);
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.execute(t1);
		/*pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);*/
	}
}
