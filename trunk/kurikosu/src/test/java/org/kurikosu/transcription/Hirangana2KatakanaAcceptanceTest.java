/**
 * 
 */
package org.kurikosu.transcription;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.kurikosu.lang.Hiragana;
import org.kurikosu.lang.Katakana;

/**
 * @author anla
 *
 */
@RunWith(value = Parameterized.class)
public class Hirangana2KatakanaAcceptanceTest {

	private final Katakana katakana;
	
	private final Hiragana hiragana;

	/**
	 * @param katakana
	 * @param hiragana
	 */
	public Hirangana2KatakanaAcceptanceTest(Hiragana hiragana, Katakana katakana) {
		this.katakana = katakana;
		this.hiragana = hiragana;
	}

	@Test
	public void shouldTranscribeToKatakana() throws Exception {
		assertEquals(katakana, new Hiragana2Katakana().transcribe(hiragana));
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		
		Object[][] params = new Object[][] {
			new Object[] { new Hiragana("ぁ"), new Katakana("ァ") },
			new Object[] { new Hiragana("きゃ"), new Katakana("キャ") },
			new Object[] { new Hiragana("きゅ"), new Katakana("キュ") },
			new Object[] { new Hiragana("きょ"), new Katakana("キョ") },
			new Object[] { new Hiragana("びゃ"), new Katakana("ビャ") },
			new Object[] { new Hiragana("ぴゅ"), new Katakana("ピュ") },
			new Object[] { new Hiragana("じょ"), new Katakana("ジョ") }
		};
		
		return Arrays.asList(params);
	}
}
