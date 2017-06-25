package com.xuefei.util;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	
	private static final long serialVersionUID = 1L;
	
	protected Map<String, Object> requestMap;
	protected Map<String, Object> sessionMap;
	protected Map<String, Object> contextMap;
	@Override
	public void setApplication(Map<String, Object> contextMap) {
		this.contextMap=contextMap;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap=requestMap;
	}

}
