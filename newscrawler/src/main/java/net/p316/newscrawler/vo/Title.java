package net.p316.newscrawler.vo;

import java.util.Date;

public class Title {
	private int idx_category;
	private String url;
	private Date date;
	private String title;
	private String company;
	
	public int getIdx_category() {
		return idx_category;
	}
	public void setIdx_category(int idx_category) {
		this.idx_category = idx_category;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
