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
import org.kurikosu.lang.Hirangana;
import org.kurikosu.lang.Katakana;

/**
 * @author anla
 *
 */
@RunWith(value = Parameterized.class)
public class Hirangana2KatakanaAcceptanceTest {

	private final Katakana katakana;
	
	private final Hirangana hirangana;

	/**
	 * @param katakana
	 * @param hirangana
	 */
	public Hirangana2KatakanaAcceptanceTest(Hirangana hirangana, Katakana katakana) {
		this.katakana = katakana;
		this.hirangana = hirangana;
	}

	@Test
	public void shouldTranscribeToKatakana() throws Exception {
		assertEquals(katakana, new Hirangana2Katakana().transcribe(hirangana));
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		
		Object[][] params = new Object[][] {
			new Object[] { new Hirangana(""), new Katakana("") }
		};
		
		return Arrays.asList(params);
	}
}
