package org.kurikosu.lang;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.kurikosu.lang.Hiragana.UNICODE_RANGE_END;
import static org.kurikosu.lang.Hiragana.UNICODE_RANGE_START;

import org.junit.Test;

public class HiraganaUnitTest {

	@Test
	public void shouldAcceptHiragana() {
		String testString = "";
		for (int x = UNICODE_RANGE_START; x <= UNICODE_RANGE_END; x++) {
			testString += (char)x;
		}
		
		assertTrue(Hiragana.isHiragana(testString));
	}

	@Test
	public void shouldRejectNonHiragana_LowerBounds() {
		String testString = "";
		
		for (int x = UNICODE_RANGE_START - 1; x < UNICODE_RANGE_END + 5; x++) {
			testString += (char)x;
		}
		
		assertFalse(Hiragana.isHiragana(testString));
	}
	
	@Test
	public void shouldRejectNonHiragana_UpperBounds() {
		String testString = "";
		
		for (int x = UNICODE_RANGE_START - 3; x < UNICODE_RANGE_END + 3; x++) {
			testString += (char)x;
		}
		
		assertFalse(Hiragana.isHiragana(testString));
	}

}
