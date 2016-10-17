package net.p316.newscrawler;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.p316.newscrawler.util.URLGenerator;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {
		URLGenerator URLgen = new URLGenerator();
        String url = URLgen.getTargetUrl(105);

        Document doc = Jsoup.connect(url).get();
        
        Elements links = doc.select("#main_content .type02 a[href]");
        
        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
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
