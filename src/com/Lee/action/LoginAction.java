package com.Lee.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.Lee.domain.User;
import com.Lee.service.LoginService;
import com.Lee.util.BaseUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	
	public User getModel() {
		return user;
	}

	private LoginService loginservice;
	
	
	public void setLoginservice(LoginService loginservice) {
		this.loginservice = loginservice;
	}



	/**
	 * 登录执行的方法
	 * @return
	 * @throws IOException 
	 */
		public String login() throws IOException{
//			System.out.println("login方法执行了。。。");
			//调用业务层的类
			User existUser= loginservice.login(user);
			
			if(existUser==null){
				//登录失败
				Map<String, Object>	dataMap = new HashMap<String,Object>();
				dataMap.put("ret", 1);
				dataMap.put("description", "登录失败");
				BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
			}else{
				//登录成功
				ActionContext.getContext().getSession().put("existEmployee", existUser);
				Map<String,Object> dataMap=new HashMap<String,Object>();
				dataMap.put("ret", 0);
				dataMap.put("description", "登录成功");
				BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
				
			}
			return null;
		}
	
}
