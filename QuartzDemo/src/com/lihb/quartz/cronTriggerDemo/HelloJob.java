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
 * �����๤��
 * @author lihb
 *
 */
public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		/*String jobName = context.getJobDetail().getKey().getName();
		System.out.println("����Key"+jobName+"����ִ�У�ִ��ʱ�䣺"+ Calendar.getInstance().getTime());*/
		System.out.println("����ɹ����С�");
		JobEntity jobEntity = (JobEntity) context.getMergedJobDataMap().get("jobEntity");
		System.out.println("�������� = [" +jobEntity.getJobName() + "]");
		List<InternetAddress> list1 = new ArrayList<InternetAddress>();
		//List<InternetAddress> list2 = new ArrayList<InternetAddress>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		try {
			String title="�Է�";
			String start ="2014-05-25 08:30";
			String end ="2014-05-25 10:30";
			String repeat ="ÿ���ظ�";
			String note = "��绰��xxx";
			String foot = "����������Ϊ��һ�¼����������ѣ��������ǰ�ʱ�����˷������ʼ���";
			
			StringBuilder sb = new StringBuilder("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><style type=\"text/css\">");
			sb.append(".content {width:50%;margin-left:10px;clear:both;font-size:14px;color:#999;font-family:\"΢���ź�\"; border:1px #ddd solid;	box-shadow:#999 3px 3px 3px;padding:10px;}");
			sb.append(".content .content-title {	width:100%;	height:40px;	position:relative;	}.content .content-title h3 {	color:#000;}.content .content-title input {	position:absolute;	right:250px;	top:0px;	width:80px;	cursor:pointer;	}");
			sb.append(".content p span{	color:#000;}.content .date {	width:960px;	margin:0 auto;	position:relative;}.content .date span {	position:absolute;	top:0;	right:0;}"
					+ ".footear {	width:50%;	margin-left:10px;	margin-top:10px; height:40px;	background:#ebebeb;	border:1px #ddd solid;padding:0 10px;	}.footear span {padding:0px;"
					+ "	font-size:14px;	font-family:\"΢���ź�\";	line-height:40px;}</style></head>");
			sb.append("<body><div class=\"content\"><div class=\"content-title\"><h3>");
			sb.append(title);         //����title
			sb.append("</h3></div><p>��ʼ:<span>");
			sb.append(start);        //��������ʼʱ��
			sb.append("</span></p><p>����:<span>"); 
			sb.append(end);           //����������ʱ��
			sb.append("</span></p><p>�ظ�:<span>");
			sb.append(repeat);     //�������ظ�
			sb.append("</span></p><p>��ע:<span>");
			sb.append(note);        //��������ע
			sb.append("</span></p><input value=\"�鿴����\" name=\"\" type=\"button\" /></div><div class=\"footear\"><span>");
			sb.append(foot);        //����
			sb.append("</span></div></body></html>");
			
			list1.add(new InternetAddress(jobEntity.getJobName()));
			
			//SimpleEmail email = new SimpleEmail();
			HtmlEmail email = new HtmlEmail();
			email.setFrom("xxxxxx");
			email.setCharset("utf-8");
			email.setSentDate(new Date());
			email.setSubject("�����ʼ����ԡ�");
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
