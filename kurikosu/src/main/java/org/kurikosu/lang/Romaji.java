package org.kurikosu.lang;

import java.io.Serializable;

import org.apache.commons.codec.language.RefinedSoundex;
import org.apache.commons.codec.language.Soundex;

/**
 * @author anla
 *
 */
@SuppressWarnings("serial")
public class Romaji implements Serializable {

	private String value;
	
	public Romaji(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String soundex() {
		return new Soundex().soundex(simpleValue());
	}

	public String refinedSoundex() {
		return new RefinedSoundex().soundex(simpleValue());
	}

	private String simpleValue() {
		String v = getValue();

		v = v.replaceAll("ā", "aa");
		v = v.replaceAll("ī", "ii");
		v = v.replaceAll("ē", "ee");
		v = v.replaceAll("ō", "oo");
		v = v.replaceAll("ū", "uu");
		return v;
	}
	
	@Override
	public int hashCode() {
		return value.replaceAll("･", "").hashCode();
	}

	@Override
	public boolean equals(Object arg0) {
		return this.getClass().isAssignableFrom(arg0.getClass()) ? 
				this.hashCode() == arg0.hashCode() : 
					super.equals(arg0);
	}
	
	@Override
	public String toString() {
		return this.getValue();
	}
}
