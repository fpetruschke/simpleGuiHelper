package simpleGuiHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class GetGlobal {

	public static Map<String,String>properties = new Hashtable<String,String>();
	
	public Properties prop; 
	
	public GetGlobal() {
		Properties prop = new Properties();
		this.prop = prop;
    	InputStream input = null;
    	try {
    		String filename = "config.properties";
    		input = getClass().getClassLoader().getResourceAsStream(filename);
    		if (input == null) {
    			System.out.println("Sorry, unable to find " + filename);
    			return;
    		}
    		prop.load(input);
    		Enumeration<?> e = prop.propertyNames();
    		while (e.hasMoreElements()) {
    			String key = (String) e.nextElement();
    			String value = prop.getProperty(key);
    			GetGlobal.properties.put(key, value);
    		}
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
	}
	
	public void setGlobal(String key, String value) throws IOException {
		FileOutputStream out = new FileOutputStream("First.properties");
		this.prop.setProperty(key, value);
		this.prop.store(out, null);
		out.close();
	}
}
