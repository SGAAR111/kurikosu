package org.kurikosu.lang;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import org.kurikosu.transcription.Katakana2IPA.ReplacementRule;


@SuppressWarnings("serial")
public class Word implements Serializable {
	
	private final String state;

	/**
	 * @param state
	 */
	public Word(String state) {
		this.state = state;
	}

	public Substring substring(Integer begin, Integer end) {
		return new Substring(state, begin, end);
	}

	public boolean endsWith(String value) {
		return this.state.endsWith(value);
	}
	
	public boolean hasSubstring(String substringValue) {
		return firstSubstring(substringValue) != null;
	}
	
	public Substring firstSubstring(String substringValue) {

		Integer index = 0;
		
		if (state.indexOf(substringValue, index) > - 1) {
			
			final int indexBegin = state.indexOf(substringValue, index);
			final int indexEnd = indexBegin + substringValue.length();
			
			return new Substring(state, indexBegin, indexEnd);
			
		} else {
			
			return null;
			
		}
	}
	
	public Substring[] substrings(String substringValue) {
		
		List<Substring> substrings = new ArrayList<Substring>();
		
		Integer index = 0;
		
		while (state.indexOf(substringValue, index) > - 1) {
			
			final int indexBegin = state.indexOf(substringValue, index);
			final int indexEnd = indexBegin + substringValue.length();
			
			substrings.add(new Substring(state, indexBegin, indexEnd));
			
			index = indexEnd;
		}
		
		return substrings.toArray(new Substring[0]);
	}
	
	public Word apply(String substring, ReplacementRule rule) {
		return new Word(rule.apply(state));
	}

	public Word replaceLastCharacterBy(String string) {
		return new Word(withoutLast() + string);
	}

	private String withoutLast() {
		return state.substring(0, state.length() - 1);
	}

	public String value() {
		return this.state;
	}

	public Word replace(Substring n, String string) {
		return new Word(n.replaceValue(string));
	}

	public boolean startsWith(String value) {
		return this.state.startsWith(value);
	}
	
	public Word replaceAll(Properties regexReplacementMap) {
			
		String workingString = state;
		
		for (Entry<Object, Object> entry : regexReplacementMap.entrySet()) {
			
			String regex = String.valueOf(entry.getKey());
			String replacement = String.valueOf(entry.getValue());
		
			workingString = workingString.replaceAll(regex, replacement);
			
		}
			
		return new Word(workingString);
	}
}