package org.kurikosu.lang;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.kurikosu.lang.Katakana.UNICODE_RANGE_END;
import static org.kurikosu.lang.Katakana.UNICODE_RANGE_START;

import org.junit.Test;

public class KatakanaUnitTest {

	@Test
	public void shouldAcceptKatakana() {
		String testString = "";
		for (int x = UNICODE_RANGE_START; x <= UNICODE_RANGE_END; x++) {
			testString += (char)x;
		}
		
		assertTrue(Katakana.isKatakana(testString));
	}

	@Test
	public void shouldRejectNonKatakana_LowerBounds() {
		String testString = "";
		
		for (int x = UNICODE_RANGE_START - 1; x < UNICODE_RANGE_END + 5; x++) {
			testString += (char)x;
		}
		
		assertFalse(Katakana.isKatakana(testString));
	}
	
	@Test
	public void shouldRejectNonKatakana_UpperBounds() {
		String testString = "";
		
		for (int x = UNICODE_RANGE_START - 3; x < UNICODE_RANGE_END + 3; x++) {
			testString += (char)x;
		}
		
		assertFalse(Katakana.isKatakana(testString));
	}

}
