package model;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Database {
	private JSONArray list;
	public Database() {
		list = new JSONArray();
	}
	public void addData(JSONObject jsonObject) {
		list.add(jsonObject);
	}
	public void saveData(String filePath) {
		try {
	         FileWriter file = new FileWriter(filePath);
	         file.write(list.toJSONString());
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}
	public void loadData(String filePath) {
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader(filePath))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

}
