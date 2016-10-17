package net.p316.newscrawler.util;

public class URLGenerator {
	private String newsUrl = "";
	private String Y = "";
	private String M = "";
	private String D = "";
	private int page;
	
	public URLGenerator(){
		newsUrl = "http://news.naver.com/main/list.nhn?mode=LSD&listType=title";
		Y = "2016";
		M = "10";
		D = "17";
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
	
	// main
	public String getTargetUrl(){
		String targetUrl = newsUrl;
		newsUrl += "&" + Y.toString() + M.toString() + D.toString();
		return targetUrl;
	};
	
	// sid1
	public String getTargetUrl(int sid1){
		String targetUrl = newsUrl;
		newsUrl += "&" + "date=" + Y.toString() + M.toString() + D.toString();
		newsUrl += "&" + "sid1=" + Integer.toString(sid1);
		return targetUrl;
	};
	
	// sid1, sid2
	public String getTargetUrl(int sid1, int sid2){
		String targetUrl = newsUrl;newsUrl += "&" + "date=" + Y.toString() + M.toString() + D.toString();
		newsUrl += "&" + "sid1=" + Integer.toString(sid1);
		newsUrl += "&" + "sid2=" + Integer.toString(sid2);
		return targetUrl;
	};
}