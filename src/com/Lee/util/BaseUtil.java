package com.Lee.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class BaseUtil {
		
	/**
	 * 获取exception详情信息
	 * @param e
	 */
	public static String getExceptionDetail(Exception e) {
		StringBuffer msg = new StringBuffer("null");
		if (e != null) {
			msg = new StringBuffer("");
			int length = e.getStackTrace().length;
			if (length > 0) {
				for (int i = 0; i < length; i++) {
					msg.append(e.getStackTrace()[i] + "\n");
				}
			} 
		}
		return msg.toString();
	}
	
	// json输出
	public static void toJson(HttpServletResponse response, Object data) 
	        throws IOException {
	        Gson gson = new Gson();
	        String result = gson.toJson(data);
	        response.setContentType("text/json; charset=utf-8");
	        response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
	        PrintWriter out = response.getWriter();
	        out.print(result);
	        out.flush();
	        out.close();
	    }
	
	
	// json输出
/*	private void sendJson(String json, HttpServletResponse response) {
		try {
			PrintWriter toClientOutStream = response.getWriter();
			toClientOutStream.write(json.toString());
			toClientOutStream.flush();
			toClientOutStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}*/
	
}
