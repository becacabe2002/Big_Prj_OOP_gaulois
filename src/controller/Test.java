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
		//Creating a JSONObject object
//	      JSONObject jsonObject = new JSONObject();
	      //Inserting key-value pairs into the json object
//	      jsonObject.put("ID", "1");
//	      jsonObject.put("First_Name", "Shikhar");
//	      jsonObject.put("Last_Name", "Dhawan");
//	      jsonObject.put("Date_Of_Birth", "1981-12-05");
//	      jsonObject.put("Place_Of_Birth", "Delhi");
//	      jsonObject.put("Country", "India");
//		  String path = "C:\\\\Users\\\\quang\\\\Desktop\\\\semester1-year3\\\\OOP-lythuyet\\\\baitaplon\\\\WebScraper\\\\WebScraper\\\\src\\\\model/output.json";
		  String path = "src/model/output.json";
		  HistoricalItem testItem = new TrieuDai("Nha Ngo");
		  HistoricalItem testItem2 = new TrieuDai("Nha Le");
		  JSONObject jsonObject = testItem.createJSON();
		  JSONObject jsonObject2 = testItem2.createJSON();
		  Database db = new Database();
		  db.addData(jsonObject);
		  db.addData(jsonObject2);
		  db.saveData(path);
//		  JSONArray list = new JSONArray();
//		  list.add(jsonObject);
//		  list.add(jsonObject2);
//	      try {
//	         FileWriter file = new FileWriter("C:\\Users\\quang\\Desktop\\semester1-year3\\OOP-lythuyet\\baitaplon\\WebScraper\\WebScraper\\src\\model/output.json");
//	         file.write(list.toJSONString());
//	         file.close();
//	      } catch (IOException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }
	      System.out.println("JSON file created: "+jsonObject);
	   }
	}

