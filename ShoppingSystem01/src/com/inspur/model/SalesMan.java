package com.inspur.model;

import java.io.Serializable;
/**
 * 售货员实体
 * @author kenn
 *
 */
public class SalesMan implements Serializable{
	private int s_id;
	private String s_name;
	private String s_password;
	private String s_type;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_password() {
		return s_password;
	}
	public void setS_password(String s_password) {
		this.s_password = s_password;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
	
}
