package com.inspur.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 商品实体类
 * @author kenn
 *
 */
public class Goods implements Serializable{
	private int g_id;
	private String g_name;
	private double g_price;
	private int g_quantity;
	private String g_remark;
	private int sale_qunitity;
	private String sale_date;
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public double getG_price() {
		return g_price;
	}
	public void setG_price(double g_price) {
		this.g_price = g_price;
	}
	public int getG_quantity() {
		return g_quantity;
	}
	public void setG_quantity(int g_quantity) {
		this.g_quantity = g_quantity;
	}
	public String getG_remark() {
		return g_remark;
	}
	public void setG_remark(String g_remark) {
		this.g_remark = g_remark;
	}
	public int getSale_qunitity() {
		return sale_qunitity;
	}
	public void setSale_qunitity(int sale_qunitity) {
		this.sale_qunitity = sale_qunitity;
	}
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	
	
}
