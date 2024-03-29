package org.kurikosu.transcription;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.kurikosu.lang.Katakana;
import org.kurikosu.transcription.Katakana2IPA;
import org.kurikosu.transcription.TranscriptionException;
public class KatakanaSokuonUnitTest {

	@Test(expected=TranscriptionException.class)
	public void shouldRejectSokuonAtBeginningOfWord() {
		new Katakana2IPA().transcribeSokuon("ッヂ");
	}

	@Test
	public void shouldRejectSokuonBeforeVowel() {
		checkFailing("vowel", Katakana.VOWEL_MONOGRAPHS);
	}
	
	@Test
	public void shouldRejectSokuonBeforeNMRWY() {
		checkFailing("n", Katakana.N_MONOGRAPHS);
		checkFailing("m", Katakana.M_MONOGRAPHS);
		checkFailing("r", Katakana.R_MONOGRAPHS);
		checkFailing("w", Katakana.W_MONOGRAPHS);
		checkFailing("y", Katakana.Y_MONOGRAPHS);
	}
	
	@Test
	public void shouldRejectSokuonBeforeGZDB() {
		checkFailing("g", Katakana.G_MONOGRAPHS);
		checkFailing("z", Katakana.Z_MONOGRAPHS);
		checkFailing("d", Katakana.D_MONOGRAPHS);
		checkFailing("b", Katakana.B_MONOGRAPHS);
	}

	private void checkFailing(final String character, final String[] characters) {
		for (String n : characters) {
			try {
				new Katakana2IPA().transcribeSokuon("タッ" + n);
				fail("Expected to fail before '" + character + "'!");
			} catch (TranscriptionException ex) {}
		}
	}
	
}
