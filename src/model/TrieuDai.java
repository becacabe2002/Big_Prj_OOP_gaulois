package model;
import java.util.ArrayList;

import org.json.simple.JSONObject;


public class TrieuDai extends HistoricalItem{
	private String title;
	private ArrayList<String> suKien = new ArrayList<String>();
	private ArrayList<String> nhanVat = new ArrayList<String>();
	private ArrayList<String> diaDiem = new ArrayList<String>();
	
	public TrieuDai() {
		super();
	}
	
	
	
	public TrieuDai(String title, String beginYear, String endYear, ArrayList<String> suKien, ArrayList<String> nhanVat,
			ArrayList<String> diaDiem) {
		super();
		this.title = title;
		this.suKien = suKien;
		this.nhanVat = nhanVat;
		this.diaDiem = diaDiem;
	}
	public TrieuDai(String title, String beginYear, String endYear, ArrayList<String> suKien, ArrayList<String> nhanVat) {
		super();
		this.title = title;
		this.suKien = suKien;
		this.nhanVat = nhanVat;
	}


	public TrieuDai(String title, ArrayList<String> suKien) {
		super();
		this.title = title;
		this.suKien = suKien;
	}
	
	public TrieuDai(String title) {
		super();
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public ArrayList<String> getSuKien() {
		return suKien;
	}
	
	public void setSuKien(ArrayList<String> suKien) {
		this.suKien = suKien;
	}
	
	
	
	public ArrayList<String> getNhanVat() {
		return nhanVat;
	}
	public void setNhanVat(ArrayList<String> nhanVat) {
		this.nhanVat = nhanVat;
	}
	public ArrayList<String> getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(ArrayList<String> diaDiem) {
		this.diaDiem = diaDiem;
	}
	public void getWebUrl() {
		String url = "https://thuvienlichsu.com/thoi-ky";
	}
	
	@Override
	public JSONObject createJSON() {
		JSONObject jsonObject = new JSONObject();
	    //Inserting key-value pairs into the json object
	    jsonObject.put("ID", this.id);
	    jsonObject.put("Title", this.title);
	    jsonObject.put("Historical_Events", this.suKien);
	    jsonObject.put("Historical_Places", this.diaDiem);
	    jsonObject.put("Historical_Characters", this.nhanVat);
	    this.jsonFormat = jsonObject;
	    return jsonObject;
	}

}
