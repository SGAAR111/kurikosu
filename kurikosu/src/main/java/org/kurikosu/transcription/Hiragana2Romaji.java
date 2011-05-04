package org.kurikosu.transcription;

import org.kurikosu.lang.Hiragana;
import org.kurikosu.lang.Romaji;

public class Hiragana2Romaji {
	public Romaji transcribe(Hiragana hiragana) {
		return new Katakana2Romaji().transcribe(new Hiragana2Katakana().transcribe(hiragana));
	}
}
