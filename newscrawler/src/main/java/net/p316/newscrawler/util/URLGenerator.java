package net.p316.newscrawler.util;

public class URLGenerator {
	private String newsURL = "";
	private String Y = "";
	private String M = "";
	private String D = "";
	private String page = "";
	
	public URLGenerator(){
		newsURL = "http://news.naver.com/main/list.nhn?mid=shm&mode=LS2D&listType=title";
		Y = "2016";
		M = "1";
		D = "1";
	}
	
	public void setDate(int y, int m, int d){
		Y = Integer.toString(y);
		M = String.format("%02d", m);
		D = String.format("%02d", d);
	}
	
	public void setYear(int y){
		Y = Integer.toString(y);
	}
	
	public void setMonth(int m){
		M = String.format("%02d", m);
	}
	
	public void setDay(int d){
		D = String.format("%02d", d);
	}
	
	public void setPage(int p){
		page = Integer.toString(p);
	}
	
	// main
	public String getTargetUrl(){
		String targetUrl = newsURL;
		targetUrl += "&" + "date=" + Y.toString() + M.toString() + D.toString();
		targetUrl += "&" + "page=" + page;
		return targetUrl;
	};
	
	// sid1
	public String getTargetUrl(int sid1){
		String targetUrl = newsURL;
		targetUrl += "&" + "date=" + Y.toString() + M.toString() + D.toString();
		targetUrl += "&" + "sid1=" + Integer.toString(sid1);
		targetUrl += "&" + "page=" + page;
		return targetUrl;
	};
	
	// sid1, sid2
	public String getTargetUrl(int sid1, int sid2){
		String targetUrl = newsURL;newsURL += "&" + "date=" + Y.toString() + M.toString() + D.toString();
		targetUrl += "&" + "sid1=" + Integer.toString(sid1);
		targetUrl += "&" + "sid2=" + Integer.toString(sid2);
		targetUrl += "&" + "page=" + page;
		return targetUrl;
	};
}