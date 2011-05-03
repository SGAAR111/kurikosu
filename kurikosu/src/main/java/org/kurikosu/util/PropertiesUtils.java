package org.kurikosu.util;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {
	
	private static Map<String, Properties> files = new HashMap<String, Properties>();
	
	public static Properties get(String propsName) {
		if (files.containsKey(propsName)) {
			return files.get(propsName);
		} else {
			Properties file = load(propsName);
			files.put(propsName, file);
			return file;
		}
    }
	
	private static Properties load(String propsName) {
		try {
	        Properties props = new Properties();
	        URL url = ClassLoader.getSystemResource(propsName);
	        props.loadFromXML(url.openStream());
	        return props;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
