package model;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class SuKien extends HistoricalItem{
	private String title;
	private ArrayList<String> nhanVat = new ArrayList<String>();
	private ArrayList<String> diaDiem = new ArrayList<String>();
	
	
	
	public SuKien() {
		super();
	}

	public SuKien(String title, ArrayList<String> nhanVat, ArrayList<String> diaDiem) {
		super();
		this.title = title;
		this.nhanVat = nhanVat;
		this.diaDiem = diaDiem;
	}
	
	public SuKien(String title) {
		super();
		this.title = title;
	}

	public SuKien(String title,  ArrayList<String> nhanVat) {
		super();
		this.title = title;
		this.nhanVat = nhanVat;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
