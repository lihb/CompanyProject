package com.lihb.quartz.cronTriggerDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * ���������õ���
 * @author lihb
 *
 */
public class DataWork {
	
	/** �ƻ�����map������ */
	private static Map<String, JobEntity> jobMap = new HashMap<String, JobEntity>();
	 
	static {
		/*for (int i = 0; i < 5; i++) {
			JobEntity job = new JobEntity();
			job.setJobId("10001" + i);
			job.setJobName("data_import" + i);
			job.setJobGroup("dataWork");
			job.setJobStatus("1");
			job.setCronExpression("0/5 * * * * ?");
			job.setDesc("���ݵ�������");
			addJob(job);
		}*/
		JobEntity job1 = new JobEntity();
		job1.setJobId("10001");
		job1.setJobName("xxxxxx@126.com");
		job1.setJobGroup("dataWork");
		job1.setJobStatus("1");
		job1.setCronExpression("0 0/2 * * * ?");
		job1.setDesc("�����ʼ�....");
		addJob(job1);
		
		JobEntity job2 = new JobEntity();
		job2.setJobId("10002");
		job2.setJobName("5xxxxx@qq.com");
		job2.setJobGroup("dataWork");
		job2.setJobStatus("1");
		job2.setCronExpression("0 0/4 * * * ?");
		job2.setDesc("�����ʼ�����.....");
//		addJob(job2);
		
		
	}
	 
	/**
	 * �������
	 * @param scheduleJob
	 */
	public static synchronized void addJob(JobEntity jobEntity) {
		jobMap.put(jobEntity.getJobGroup() + "_" + jobEntity.getJobName(), jobEntity);
	}
	
	/*public static synchronized JobEntity getJob(){
		
		//return jobMap.get(arg0);
	}*/

	public static synchronized List<JobEntity> getAllJob() {
		// TODO Auto-generated method stub
		List<JobEntity> list = new ArrayList<JobEntity>();
		Iterator<String> it = jobMap.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			list.add(jobMap.get(key));
			
		}
		return list;
	}

}
