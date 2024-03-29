package org.kurikosu.lang;

import java.io.Serializable;

@SuppressWarnings("serial")
public final class Substring implements Serializable {
	
	private String word;
	
	private Integer indexBegin;
	
	private Integer indexEnd;
	
	/**
	 * @param word
	 * @param indexBegin
	 * @param indexEnd
	 */
	public Substring(String word, Integer indexBegin, Integer indexEnd) {
		this.word = word;
		this.indexBegin = indexBegin;
		this.indexEnd = indexEnd;
	}

	public String substring() {
		return word.substring(indexBegin, indexEnd);
	}
	
	public String predecessor() {
		return word.substring(0, indexBegin);
	}

	public String successor() {
		return word.substring(indexEnd);
	}

	public boolean isPreceededBy(String... strings) {
		for (String string : strings) {
			if (predecessor().endsWith(string)) {
				return true;
			}
		}
		return false;
	}

	public boolean isNotFollowedBy(String[]... strings) {
		for (String[] strings2 : strings) {
			if (isNotFollowedBy(strings2)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isNotFollowedBy(String... strings) {
		for (String string : strings) {
			if (successor().startsWith(string)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFollowedBy(String[]... strings) {
		for (String[] strings2 : strings) {
			if (isFollowedBy(strings2)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isFollowedBy(String... strings) {
		for (String string : strings) {
			if (successor().startsWith(string)) {
				return true;
			}
		}
		return false;
	}

	public String value() {
		return word.substring(indexBegin, indexEnd);
	}

	public String replaceValue(String string) {
		return predecessor() + string + successor();
	}
}