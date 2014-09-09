package com.lihb.quartz.cronTriggerDemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 任务类工厂
 * @author lihb
 *
 */
public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		/*String jobName = context.getJobDetail().getKey().getName();
		System.out.println("任务Key"+jobName+"正在执行，执行时间："+ Calendar.getInstance().getTime());*/
		System.out.println("任务成功运行。");
		JobEntity jobEntity = (JobEntity) context.getMergedJobDataMap().get("jobEntity");
		System.out.println("任务名称 = [" +jobEntity.getJobName() + "]");
		List<InternetAddress> list1 = new ArrayList<InternetAddress>();
		//List<InternetAddress> list2 = new ArrayList<InternetAddress>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		try {
			String title="吃饭";
			String start ="2014-05-25 08:30";
			String end ="2014-05-25 10:30";
			String repeat ="每天重复";
			String note = "打电话给xxx";
			String foot = "您在日历中为这一事件设置了提醒，所以我们按时发出此封提醒邮件。";
			
			StringBuilder sb = new StringBuilder("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><style type=\"text/css\">");
			sb.append(".content {width:50%;margin-left:10px;clear:both;font-size:14px;color:#999;font-family:\"微软雅黑\"; border:1px #ddd solid;	box-shadow:#999 3px 3px 3px;padding:10px;}");
			sb.append(".content .content-title {	width:100%;	height:40px;	position:relative;	}.content .content-title h3 {	color:#000;}.content .content-title input {	position:absolute;	right:250px;	top:0px;	width:80px;	cursor:pointer;	}");
			sb.append(".content p span{	color:#000;}.content .date {	width:960px;	margin:0 auto;	position:relative;}.content .date span {	position:absolute;	top:0;	right:0;}"
					+ ".footear {	width:50%;	margin-left:10px;	margin-top:10px; height:40px;	background:#ebebeb;	border:1px #ddd solid;padding:0 10px;	}.footear span {padding:0px;"
					+ "	font-size:14px;	font-family:\"微软雅黑\";	line-height:40px;}</style></head>");
			sb.append("<body><div class=\"content\"><div class=\"content-title\"><h3>");
			sb.append(title);         //参数title
			sb.append("</h3></div><p>开始:<span>");
			sb.append(start);        //参数：开始时间
			sb.append("</span></p><p>结束:<span>"); 
			sb.append(end);           //参数：结束时间
			sb.append("</span></p><p>重复:<span>");
			sb.append(repeat);     //参数：重复
			sb.append("</span></p><p>备注:<span>");
			sb.append(note);        //参数：备注
			sb.append("</span></p><input value=\"查看详情\" name=\"\" type=\"button\" /></div><div class=\"footear\"><span>");
			sb.append(foot);        //参数
			sb.append("</span></div></body></html>");
			
			list1.add(new InternetAddress(jobEntity.getJobName()));
			
			//SimpleEmail email = new SimpleEmail();
			HtmlEmail email = new HtmlEmail();
			email.setFrom("xxxxxx");
			email.setCharset("utf-8");
			email.setSentDate(new Date());
			email.setSubject("发送邮件测试。");
			email.setHostName("smtp-ent.xxxxx.com");
			email.setAuthentication("xxxxx", "xxxx");
			email.setTo(list1);
			email.setContent(sb.toString(),"text/html;charset=utf-8");
			email.send();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	/*public static void main(String[] args){
		SimpleEmail email3 = new SimpleEmail();
		SimpleEmail email4 = new SimpleEmail();
		System.out.println(email3==email4);
		
		
	}
*/
}
