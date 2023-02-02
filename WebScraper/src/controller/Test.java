package controller;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Database;
import model.HistoricalItem;
import model.TrieuDai;

public class Test {
	
	public void crawlDataTrieuDai() {
		
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.loadData("src/model/DiaDiem.json");
	   }
	}

