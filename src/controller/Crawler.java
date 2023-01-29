package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Crawler {
	
	public abstract Elements listElementCard(String url, String elmClass) throws IOException;
	
	public abstract Document getSubPage(Element element) throws IOException;
	
	public Elements getHeaderCards(Document documentPage) {
		Elements elms = documentPage.getElementsByClass("card mb-3");
		return elms;
	}
	
	public ArrayList<String> getInnerDataCardsTitles(Element headerCard) {
		Elements dataCardsTitles = headerCard.getElementsByClass("card-title");
		ArrayList<String> titles = new ArrayList<String>();
		for (Iterator<Element> i = dataCardsTitles.iterator(); i.hasNext();) {
		    String item = i.next().text();
		    titles.add(item);
		}
		return titles;
	}
	
	public Element getCategoryHeaderCard(String titleYouWant, Elements headerCards) {
		Iterator<Element> it = headerCards.iterator();
		while(it.hasNext()) {
			Element headerCard = it.next();
			if(this.checkCategoryHeaderCard(titleYouWant, headerCard) == true) {
				return headerCard;
			}
		}
		return null;
		
	}
	
	public boolean checkCategoryHeaderCard(String titleYouWant, Element headerCard) {
		String headerTitle = headerCard.getElementsByClass("header-edge").text();
		if(headerTitle.equals(titleYouWant) == true) {
			return true;
		}
		return false;
	}
	
	public ArrayList<String> getBeginEndYear(String string){
		ArrayList<String> output = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\((\\d+)\\s-\\s(\\d+)\\)");
		Matcher matcher = pattern.matcher(string);
		matcher.find();
		String beginYear = matcher.group(1);
		String endYear = matcher.group(2);
		output.add(beginYear);
		output.add(endYear);
		return output;
	}
}
