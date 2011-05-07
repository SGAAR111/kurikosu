package org.kurikosu.transcription;

import org.kurikosu.lang.Hiragana;
import org.kurikosu.lang.IPA;

public class Hiragana2IPA {

	public IPA transcribe(Hiragana hiragana) {
		return new Katakana2IPA().transcribe(new Hiragana2Katakana().transcribe(hiragana));
	}

}
