package net.p316.newscrawler.util;

public class URLGenerator {
	//URL의 정보(year, month, date 등)를 담는 class URLGenerator
	
	private String newsURL = "";
	 //website의 url을 저장할 string newsURL 선언
	private String Y = "";
	 //year을 저장할 string Y 선언
	private String M = "";
	 //month를 저장할 string M 선언
	private String D = "";
	 //date를 저장할 string D 선언
	private String page = "";
	 //page를 저장할 string page 선언
	
	public URLGenerator(){
		 //URL의 정보(newsURL와 Y,M,D)를 초기화해주는 메소드 URLGenerator
		newsURL = "http://news.naver.com/main/list.nhn?mid=sec&mode=LSD&listType=title";
		 //네이버 뉴스의 속보 홈의 url 저장
		Y = "2016";
		 //Y를 2016년으로 초기화
		M = "1";
		 //M을 1월으로 초기화
		D = "1";
		 //D를 1월으로 초기화
	}
	
	public void setDate(int y, int m, int d){
		//년도,월,일을 받아 각각 변수 Y,M,D에 저장해주는 메소드 setDate
		Y = Integer.toString(y);
		//int형 변수 y를 string형으로 변환하여 Y에 저장
		M = String.format("%02d", m);
		//자릿수를 2자리로 0을 채워서 맞춰주고 string형으로 M에 저장
		D = String.format("%02d", d);
		//자릿수를 2자리로 0을 채워서 맞춰주고 string형으로 D에 저장
	}
	
	public void setYear(int y){
		//int형 변수 y를 string형으로 변환하여 Y에 저장해주는 메소드 setYear
		Y = Integer.toString(y);
	}
	
	public void setMonth(int m){
		//int형 변수 md을 string형으로 변환하고 2자리수로(0을 채워서) M에 저장해주는 메소드 setYear
		M = String.format("%02d", m);
	}
	
	public void setDay(int d){
		//int형 변수 d를 string형으로 변환하고 2자리수로(0을 채워서) D에 저장해주는 메소드 setYear
		D = String.format("%02d", d);
	}
	
	public void setPage(int p){
		//매개변수로 받은 정수형 변수 p를 string형으로 바꾸어 page에 저장해주는 메소드 setPage
		page = Integer.toString(p);
	}
	
	// main
	public String getTargetUrl(){
		//TargetUrl의 형식을 만들어주는 메소드 getTargetUrl
		
		String targetUrl = newsURL;
		//위에서 저장해준 newsURL을 불러온다
		targetUrl += "&" + "date=" + Y.toString() + M.toString() + D.toString();
		//targetUrl에 year과 month와 date 정보를 추가하여 그 날에 해당하는 뉴스기사의 url을 얻는다
		targetUrl += "&" + "page=" + page;
		//page도 설정해준다
		
		return targetUrl; //string형 targetUrl 반환
	};
	
	// sid1
	public String getTargetUrl(int sid1){
		//웹사이트에서 sid1을 이용해 뉴스의 카테고리를 분류해주므로 이를 이용해 TargetUrl을 저장해주는 메소드

		String targetUrl = newsURL;
		//targetUrl 초기화
		targetUrl += "&" + "date=" + Y.toString() + M.toString() + D.toString();
		//Y,M,D를 입력받아 url 지정
		targetUrl += "&" + "sid1=" + Integer.toString(sid1);
		//sid1을 입력받아 카테고리가 분류된 url 지정
		targetUrl += "&" + "page=" + page;
		//페이지도 지정
		
		return targetUrl; //string형 targetUrl 반환
	};
	
	// sid1, sid2
	public String getTargetUrl(int sid1, int sid2){
		//웹사이트에서 sid1을 이용해 뉴스의 카테고리를 분류하고 sid2를 이용해 세부카테고리를 분류해주므로 이를 이용해 TargetUrl을 저장해주는 메소드
		
		String targetUrl = newsURL;
		//targetUrl 초기화
		targetUrl += "&" + "date=" + Y.toString() + M.toString() + D.toString();
		//Y,M,D를 입력받아 url 지정
		targetUrl += "&" + "sid1=" + Integer.toString(sid1);
		//sid1을 입력받아 카테고리가 분류된 url 지정
		targetUrl += "&" + "sid2=" + Integer.toString(sid2);
		//sid2을 입력받아 세부카테고리가 분류된 url 지정
		targetUrl += "&" + "page=" + page;
		//페이지도 지정
		
		return targetUrl; //string형 targetUrl 반환 
	};
}