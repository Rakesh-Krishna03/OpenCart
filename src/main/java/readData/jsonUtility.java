package readData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonUtility {
	public static JSONObject readJsonFile(String filePath) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonData = (JSONObject) parser.parse(new FileReader(filePath));
		
		return jsonData;
	}
	
	public static void main(String[] args) {
		System.out.println(5.0/2.0);
	}
}