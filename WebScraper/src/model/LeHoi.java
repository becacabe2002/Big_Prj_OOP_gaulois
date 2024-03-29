package model;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class LeHoi extends HistoricalItem{
	private int id;
	private String title;
	private String date;
	private String diaDiem;
	private ArrayList<String> nhanVat;
	
	
	
	public LeHoi(String title, String date, String diaDiem, ArrayList<String> nhanVat) {
		super();
		this.title = title;
		this.date = date;
		this.diaDiem = diaDiem;
		this.nhanVat = nhanVat;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return diaDiem;
	}
	public void setLocation(String location) {
		this.diaDiem = location;
	}
	public ArrayList<String> getHistorical_Characters() {
		return nhanVat;
	}
	public void setHistorical_Characters(ArrayList<String> historical_Characters) {
		nhanVat = historical_Characters;
	}
	
	@Override
	public JSONObject createJSON() {
		JSONObject jsonObject = new JSONObject();
	    //Inserting key-value pairs into the json object
	    jsonObject.put("ID", this.id);
	    jsonObject.put("Title", this.title);
	    jsonObject.put("Historical_Places", this.diaDiem);
	    jsonObject.put("Historical_Characters", this.nhanVat);
	    this.jsonFormat = jsonObject;
	    return jsonObject;
	}
	
}
