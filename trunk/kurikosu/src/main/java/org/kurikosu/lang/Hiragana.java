package org.kurikosu.lang;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hiragana implements Serializable {

	private String value;
	
	public Hiragana(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object arg0) {
		return this.getClass().isAssignableFrom(arg0.getClass()) ? 
				this.hashCode() == arg0.hashCode() : 
					super.equals(arg0);
	}
	
	@Override
	public String toString() {
		return "{ Hirangana : '" + this.getValue() + "' }";
	}
}