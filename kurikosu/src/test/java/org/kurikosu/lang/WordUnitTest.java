package org.kurikosu.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.kurikosu.lang.Substring;
import org.kurikosu.lang.Word;

public class WordUnitTest {

	@Test
	public void shouldReturnFirstSubstring() {

		final Word word = new Word("1-ar-2-ar-3-ar-4");
		
		final Substring substring = word.firstSubstring("ar");
		
		assertEquals("1-", substring.predecessor());
		assertEquals("ar", substring.value());
		assertEquals("-2-ar-3-ar-4", substring.successor());

	}
	
	@Test
	public void shouldReturnAllSubstrings() {
		
		final Word word = new Word("1-ar-2-ar-3-ar-4");
		
		final Substring[] substrings = word.substrings("ar");
		
		assertEquals(3, substrings.length);
		
		assertEquals("1-", substrings[0].predecessor());
		assertEquals("ar", substrings[0].value());
		assertEquals("-2-ar-3-ar-4", substrings[0].successor());
		
		assertEquals("1-ar-2-", substrings[1].predecessor());
		assertEquals("ar", substrings[1].value());
		assertEquals("-3-ar-4", substrings[1].successor());

		assertEquals("1-ar-2-ar-3-", substrings[2].predecessor());
		assertEquals("ar", substrings[2].value());
		assertEquals("-4", substrings[2].successor());
	}
	
	@Test
	public void shouldReplaceLastCharacter() {
		final Word word = new Word("word");
		
		final Word newWord = word.replaceLastCharacterBy("k");
		
		assertEquals("work", newWord.value());
	}
}
