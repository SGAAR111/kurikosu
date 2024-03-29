/**
 * 
 */
package org.kurikosu.lang;

import java.io.Serializable;

/**
 * @author anla
 *
 */
@SuppressWarnings("serial")
public class IPA implements Serializable {

	private String value;
	
	public IPA(String value) {
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
		return this.getValue();
	}
}