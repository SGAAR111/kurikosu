package org.yomikomi.reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.kurikosu.lang.JapaneseWord;
import org.yomikomi.xml.Entry;
import org.yomikomi.xml.JMdict;


public class ReaderTest {

	@Test
	public void testRead() throws Throwable {
		JAXBContext ctx = JAXBContext.newInstance("org.yomikomi.xml");
        Unmarshaller um = ctx.createUnmarshaller();
        JMdict bugs = (JMdict) um.unmarshal(ClassLoader.getSystemResource("JMDict_e").openStream());

        List<Entry> entries = bugs.getEntry();
        
        Map<String, Integer> sc = new HashMap<String, Integer>();
        
        Map<String, List<String>> cm = new HashMap<String, List<String>>();
        
        for (Entry entry : entries) {
        	try {

        		JapaneseWord w = new JapaneseWord(entry.getREle().get(0).getReb());
        		
				String soundex = w.getRomaji().soundex();
				
				System.out.println(entry.getEntSeq() + ": " + w.getPrimaryReading() + ", " + w.getIpa() + ", " + w.getRomaji() + ", " + soundex);
		
				if (!cm.containsKey(soundex)) {
					cm.put(soundex, new ArrayList<String>());
				}
				
				cm.get(soundex).add(w.getRomaji().getValue());
				
				if (!sc.containsKey(soundex)) {
					sc.put(soundex, 0);
				}
				
				sc.put(soundex, sc.get(soundex) + 1);
				
        	} catch (Exception ex) {
        		System.out.println(entry.getEntSeq() + ": " + ex.getMessage());
        	}
		}
        
        List<java.util.Map.Entry<String, Integer>> entrySet = new ArrayList<java.util.Map.Entry<String,Integer>>(sc.entrySet());
        
        Collections.sort(entrySet, new Comparator<java.util.Map.Entry<String, Integer>>() {
			@Override
			public int compare(java.util.Map.Entry<String, Integer> o1,	java.util.Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
        
        for (java.util.Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
        
        for (String k : cm.get(entrySet.get(0).getKey())) {
        	System.out.println(k);
        }
        
        
	}

}
