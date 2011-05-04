package org.kurikosu.transcription;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.LabeledParameterized;
import org.junit.runners.LabeledParameterized.NamePattern;
import org.junit.runners.LabeledParameterized.Parameters;
import org.kurikosu.lang.Katakana;
import org.kurikosu.lang.Romaji;

@RunWith(value=LabeledParameterized.class)
public class Katakana2RomajiAcceptanceTest {

	private final Romaji romaji;
	
	private final Katakana katakana;

	/**
	 * @param romaji
	 * @param katakana
	 */
	public Katakana2RomajiAcceptanceTest(String spec, Katakana katakana, Romaji romaji) {
		this.romaji = romaji;
		this.katakana = katakana;
	}

	@Test
	public void shouldTranscribeToKatakana() throws Exception {
		assertEquals(romaji, new Katakana2Romaji().transcribe(katakana));
	}
	
	@NamePattern
	public static String testName() {
		return "{0}: [ {1} -> {2} ]"; 
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		
		Object[][] params = new Object[][] {
			new Object[] { "Random Word", new Katakana("ヨロシク"), new Romaji("yoroshiku") },
			new Object[] { "Contains N 'ン'", new Katakana("ジン"), new Romaji("jin") },
			new Object[] { "Contains Choopun", new Katakana("イツァーク・パールマン"), new Romaji("itsāku pāruman") },
			new Object[] { "Contains Sukoun", new Katakana("キック"), new Romaji("kikku") },
			new Object[] { "Random Word", new Katakana("ジンス"), new Romaji("jinsu") },
			
		};
		
		return Arrays.asList(params);
	}
	
}
