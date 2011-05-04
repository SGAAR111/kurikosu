/**
 * 
 */
package org.kurikosu.transcription;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.LabeledParameterized;
import org.junit.runners.LabeledParameterized.NamePattern;
import org.junit.runners.LabeledParameterized.Parameters;
import org.kurikosu.lang.Hiragana;
import org.kurikosu.lang.Romaji;

/**
 * @author anla
 *
 */
@RunWith(value=LabeledParameterized.class)
public class Hiragana2RomajiAcceptanceTest {

	private final Romaji romaji;
	
	private final Hiragana hiragana;

	/**
	 * @param romaji
	 * @param hiragana
	 */
	public Hiragana2RomajiAcceptanceTest(String spec, Hiragana hiragana, Romaji romaji) {
		this.romaji = romaji;
		this.hiragana = hiragana;
	}

	@Test
	public void shouldTranscribeToKatakana() throws Exception {
		assertEquals(romaji, new Hiragana2Romaji().transcribe(hiragana));
	}

	@NamePattern
	public static String testNamePattern() {
		return "{0} [ {1} -> {2} ]";
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		
		Object[][] params = new Object[][] {
			new Object[] { "", new Hiragana("ぁ"), new Romaji("a") },
			new Object[] { "", new Hiragana("おーともびる"), new Romaji("ōtomobiru") },
			new Object[] { "", new Hiragana("でぃあ"), new Romaji("dia") },
			new Object[] { "", new Hiragana("ながぐつをはいたねこ"), new Romaji("nagagutsu･o･haita･neko") },
			new Object[] { "", new Hiragana("とうきょう"), new Romaji("tōkyō") },
			new Object[] { "", new Hiragana("てーぶる"), new Romaji("tēburu") },
			new Object[] { "", new Hiragana("ざたく"), new Romaji("za･taku") },
			new Object[] { "", new Hiragana("てーぶるくろーす"), new Romaji("tēburu･kurōsu") },
			new Object[] { "", new Hiragana("たくじょうかれんだー"), new Romaji("takujō･karendā") },
			new Object[] { "Includes N - n Rule", new Hiragana("いんすい"), new Romaji("in･sui") },
			new Object[] { "Includes N - n Rule", new Hiragana("ぜんぎ"), new Romaji("zengi") },
			new Object[] { "Includes N - m Rule", new Hiragana("ぐんま"), new Romaji("gumma") },
		};
		
		return Arrays.asList(params);
	}
}
