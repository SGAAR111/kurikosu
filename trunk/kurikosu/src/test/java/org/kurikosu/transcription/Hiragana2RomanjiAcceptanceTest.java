/**
 * 
 */
package org.kurikosu.transcription;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.kurikosu.lang.Hiragana;
import org.kurikosu.lang.Romanji;

/**
 * @author anla
 *
 */
public class Hiragana2RomanjiAcceptanceTest {

	private final Romanji katakana;
	
	private final Hiragana hiragana;

	/**
	 * @param katakana
	 * @param hiragana
	 */
	public Hiragana2RomanjiAcceptanceTest(Hiragana hiragana, Romanji katakana) {
		this.katakana = katakana;
		this.hiragana = hiragana;
	}

	@Test
	public void shouldTranscribeToKatakana() throws Exception {
		assertEquals(katakana, new Hiragana2Romanji().transcribe(hiragana));
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		
		Object[][] params = new Object[][] {
			new Object[] { new Hiragana("ぁ"), new Romanji("ァ") },
		};
		
		return Arrays.asList(params);
	}
}
