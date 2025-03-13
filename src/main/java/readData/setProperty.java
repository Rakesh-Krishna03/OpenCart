package readData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class setProperty {
	
	public static void main(String[] args) throws IOException {
	
		FileOutputStream file = new FileOutputStream("config1.properties");
		Properties properties = new Properties();
		
		properties.setProperty("key1", "value1");
		properties.setProperty("key2", "value2");
		
		properties.store(file, "comment");
		file.close();
	}	
}
