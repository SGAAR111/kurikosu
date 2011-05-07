package org.kurikosu.lang;

import java.io.Serializable;

import org.kurikosu.util.StringUtils;

@SuppressWarnings("serial")
public class Hiragana implements Serializable {

	public static final char UNICODE_RANGE_START = '\u3040';
	public static final char UNICODE_RANGE_END = '\u309F';
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
		return this.getClass().isAssignableFrom(arg0.getClass()) ? this
				.hashCode() == arg0.hashCode() : super.equals(arg0);
	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public static boolean isHiragana(String string) {
		return StringUtils.isWithinUnicodeRange(string, UNICODE_RANGE_START, UNICODE_RANGE_END);
	}
}