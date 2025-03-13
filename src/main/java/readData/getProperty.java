package readData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class getProperty {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(file);
		
		System.out.println(properties.get("db.password"));
		System.out.println(properties.get("browser"));
		
		file.close();
	}
}