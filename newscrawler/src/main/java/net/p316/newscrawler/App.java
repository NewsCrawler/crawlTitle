package net.p316.newscrawler;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.p316.newscrawler.util.URLGenerator;
import net.p316.newscrawler.vo.Title;

import java.io.IOException;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) throws IOException {
		URLGenerator URLgen = new URLGenerator();

		int s1 = 105;
		int s2 = 230;
		URLgen.setMonth(10);
		URLgen.setDay(17);
		URLgen.setPage(1);
		String url = URLgen.getTargetUrl();
		
		ArrayList<Title> titles = new ArrayList<Title>();
		
		// get last page
		// page=999 >> .paging strong:last
		for(int i = 1; i <= 11; i++){
			URLgen.setPage(i);
			url = URLgen.getTargetUrl(s1, s2);
			
			Document doc = Jsoup.connect(url).get();
	        
			Elements items = doc.select("#main_content .type02 li");
	        Elements links = doc.select("#main_content .type02 a[href]");
	        Elements company = doc.select("#main_content .type02 .writing");
	        Elements date = doc.select("#main_content .type02 .date");
	        
	        //print("\nItems: (%d)", items.size());
	        for(Element item : items){
	        	Elements link = item.select("a[href]");
	        	String href = link.attr("abs:href");
	        	String title = link.text();
    			String comp = item.select(".writing").text();
	        	String day = item.select(".date").text();
	        	print("%s, %s, %s, %s", href, title, comp, day);
	        }
	        
	        /*
	        print("\nLink: (%d)", links.size());
	        for (Element link : links) {
	        	print("%s", link.attr("abs:href"));
	        }
	        
	        print("\nTitle: (%d)", links.size());
	        for (Element link : links) {
	        	print("%s", link.text());
	        }
	        
	        print("\nCompany: (%d)", company.size());
	        for(Element comp : company) {
	        	print("%s", comp.text());
	        }
	        
	        print("\nDate: (%d)", date.size());
	        for(Element day : date) {
	        	print("%s", day.text());
	        }
	        */
		}
		
		for(Title t : titles){
			print("%s,%s,%s,%s", t.getUrl(), t.getDate().toString(), t.getTitle(), t.getCompany());
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
