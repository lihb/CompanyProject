package com.lihb.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class SmsTest {

	@Test
	public void smsToYangge() throws UnsupportedEncodingException {

		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		
		
		//String test = URLEncoder.encode(urlStr,"gbk");
		//System.out.println(test);
		String urlStr = "http://121.14.53.168:5100/axis/sendservlet?src=10659189\\&des=18902499968\\&type=GBK\\&content=test";
		try {
			URL url = new URL(urlStr);
			URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
			
			HttpGet httpGet = new HttpGet(uri);
			System.out.println(httpGet.getRequestLine());
			// 执行get请求
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			// 获取响应消息实体
			HttpEntity entity = httpResponse.getEntity();
			// 响应状态
			System.out.println("status:" + httpResponse.getStatusLine());
			// 判断响应实体是否为空
			if (entity != null) {
				System.out.println("contentEncoding:"
						+ entity.getContentEncoding());
				System.out.println("response content:"
						+ EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流并释放资源
				closeableHttpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
