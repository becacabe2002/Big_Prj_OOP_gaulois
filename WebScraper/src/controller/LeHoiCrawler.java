package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Database;
import model.LeHoi;

public class LeHoiCrawler extends WikipediaCrawler{
	private String originalUrl;
	private String subUrl;
	
	public LeHoiCrawler() {
		super();
		originalUrl = "https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam"; 
	}
	
	public String getOriginalUrl() {
		return originalUrl;
	}
	
	public Element getDataTable(Document document) {
		Element table = document.getElementsByTag("table").get(1);
		return table;
	}
	
	public Elements getDataTableRows(Element table) {
		Elements tableRows = table.getElementsByTag("tr");
		return tableRows;
	}
	
	public LeHoi getDataFromRow(Element row) {
		String title = row.getElementsByTag("td").get(2).text();
		String date = row.getElementsByTag("td").get(0).text();
		String diaDiem = row.getElementsByTag("td").get(1).text();
		ArrayList<String> nhanVat = new ArrayList<String>();
		nhanVat.add(row.getElementsByTag("td").get(4).text());
		LeHoi leHoiItem = new LeHoi(title, date, diaDiem, nhanVat);
		return leHoiItem;
	}
	
	public static void main(String[] args) {
		LeHoiCrawler crawler = new LeHoiCrawler(); 
		Document document;
		Database db = new Database();
		try {
			document = Jsoup.connect(crawler.getOriginalUrl()).get();
//			System.out.println(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			document = null;
			e.printStackTrace();
		} 
		Element leHoiTable = crawler.getDataTable(document);
		Elements leHoiTableRows = crawler.getDataTableRows(leHoiTable);
		leHoiTableRows.remove(0);
		System.out.println(leHoiTableRows);
		for(Iterator<Element> iter = leHoiTableRows.iterator();iter.hasNext();) {
			Element row = iter.next();
			LeHoi leHoiItem = crawler.getDataFromRow(row);
			db.addData(leHoiItem.createJSON());
		}
		db.saveData("src/model/LeHoi.json");
	}

	@Override
	public void crawl() {
		// TODO Auto-generated method stub
		
	}
}
