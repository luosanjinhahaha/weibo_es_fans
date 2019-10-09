package com.roshine.weibo_es_fans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Msg {
	private int code;
	private String msg;
	
	//返回给用户的数据
	public Map<String, Object> extend = new HashMap<>();
	
	public static Msg success(){
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("处理成功！");
		return result;
	} 
	
	public static Msg fail(){
		Msg result = new Msg();
		result.setCode(400);
		result.setMsg("处理失败！");
		return result;
	} 
	
	public Msg add(String key, Object value) {
		// TODO 自动生成的方法存根
		this.getExtend().put(key, value);
		return this;
	}
}
