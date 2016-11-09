package net.p316.newscrawler;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.p316.newscrawler.util.MySQLConnector;
import net.p316.newscrawler.util.URLGenerator;
import net.p316.newscrawler.vo.Title;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class App {
	public static void main(String[] args) throws IOException {
	
		URLGenerator URLgen = new URLGenerator();
		//URLgen에 URLGenerator 객체 생성
		
		Calendar cal = Calendar.getInstance ( );//오늘 날짜를 기준으로 날짜불러오기
		
		int s1 = 100;
		//category를 저장하는 변수 s1에 100 저장(정치카테고리로 지정)
		int s2 = 264;
		//sub_category를 저장하는 변수 s2에 264 저장(정치일반으로 부카테고리 지정)
		URLgen.setMonth(cal.get ( cal.MONTH )+1);
		//Month
		URLgen.setDay(cal.get ( cal.DATE ));
		//Date
		URLgen.setPage(1);
		//1페이지 초기화
      
	
		int argcount=args.length;
		
		if(argcount==1) //sid1만 지정
			s1=Integer.parseInt(args[0]);
		else if(argcount==2) //sid1, sid2 지정
		{
			s1=Integer.parseInt(args[0]);
			s2=Integer.parseInt(args[1]);
		}
		else if(argcount==3) //sid1, MM, DD 지정
		{
			s1=Integer.parseInt(args[0]);
			URLgen.setMonth(Integer.parseInt(args[1]));
			URLgen.setDay(Integer.parseInt(args[2]));
		}
		else if(argcount==4) //sid1, sid2, MM, dd 지정
		{
			s1=Integer.parseInt(args[0]);
			s2=Integer.parseInt(args[1]);
			URLgen.setMonth(Integer.parseInt(args[2]));
			URLgen.setDay(Integer.parseInt(args[3]));
		}
		else if(argcount==5) //sid1, sid2, MM, dd, page 지정
		{
			s1=Integer.parseInt(args[0]);
			s2=Integer.parseInt(args[1]);
			URLgen.setMonth(Integer.parseInt(args[2]));
			URLgen.setDay(Integer.parseInt(args[3]));
			URLgen.setPage(Integer.parseInt(args[4]));
		}
		
		
		String url = URLgen.getTargetUrl();
		//url에 URLgen객체의 getTargetUrl을 저장
		
		ArrayList<Title> titles = new ArrayList<Title>();
		
		MySQLConnector mycon = new MySQLConnector();
		
		mycon.testConn();
		
		// get last page
		// page=999 >> .paging strong:last
		breakOut:
		for(int i = 1; ; i++){
			
			URLgen.setPage(i);
			url=URLgen.getTargetUrl();
			//url = URLgen.getTargetUrl(s1, s2);
		
			/*
			Document doc = Jsoup.connect(url).get();
	        
			Elements items = doc.select("#main_content .type02 li");
	        Elements links = doc.select("#main_content .type02 a[href]");
	        Elements company = doc.select("#main_content .type02 .writing");
	        Elements date = doc.select("#main_content .type02 .date");
	        Elements pageCheck = doc.select(".paging strong");
	        // String strongpagenum=pageCheck.text();
	        
	        print(url);
	        */
	        
	        if(argcount==1) //sid1만 지정
			{
				url = URLgen.getTargetUrl(s1);
			}
			else if(argcount==2) //sid1, sid2 지정
			{
				url = URLgen.getTargetUrl(s1, s2);
			}
			else if(argcount==3) //sid1, MM, DD 지정
			{
				url = URLgen.getTargetUrl(s1, s2);
			}
			else if(argcount==4) //sid1, sid2, MM, DD 지정
			{
				url = URLgen.getTargetUrl(s1, s2);
			}
			else if(argcount==5) //sid1, sid2, MM, dd, page 지정
			{
				URLgen.setPage(Integer.parseInt(args[4]));
				url = URLgen.getTargetUrl(s1, s2);
				
			}
	        Document doc = Jsoup.connect(url).get();
	        
			Elements items = doc.select("#main_content .type02 li");
	        Elements links = doc.select("#main_content .type02 a[href]");
	        Elements company = doc.select("#main_content .type02 .writing");
	        Elements date = doc.select("#main_content .type02 .date");
	        Elements pageCheck = doc.select(".paging strong");
	        // String strongpagenum=pageCheck.text();
	        
	        print(url);
	        
	        String strongpagenum=pageCheck.text();
	        print("스트롱 페이지 : %s 랑 i : %d \n", strongpagenum,i);
	        
	        if(i!=Integer.parseInt(strongpagenum))
	        	break breakOut;
	                	
	        
	        
	        for(Element item : items){
	        	Elements link = item.select("a[href]");
	        	String href = link.attr("abs:href");
	        	String title = link.text();
    			String comp = item.select(".writing").text();
	        	String day = item.select(".date").text();
	        	print("%s\t%s\t%s\t%s", href, title, comp, day);
	        	
	        	mycon.simpleInsertTitle(href, title, comp, day);
	        }
	        
	        
	       
		}
		
		for(Title t : titles){
			//불러온 title이 있을 경우
			
			print("%s,%s,%s,%s", t.getUrl(), t.getDate().toString(), t.getTitle(), t.getCompany());
		   //뉴스 기사의 Url, 기사의 날짜와 시간, 기사제목, 뉴스회사 출력
		}
		
		
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
    

    
}

