package org.kurikosu.lang;

import org.kurikosu.transcription.Hiragana2IPA;
import org.kurikosu.transcription.Hiragana2Katakana;
import org.kurikosu.transcription.Hiragana2Romaji;
import org.kurikosu.transcription.Katakana2IPA;
import org.kurikosu.transcription.Katakana2Romaji;

public class JapaneseWord {

	private int primaryReading = 0;
	
	private Katakana katakana;
	
	private Hiragana hiragana;
	
	private IPA ipa;
	
	private Romaji romaji;
	
	public JapaneseWord(String kana) {
		if (Katakana.isKatakana(kana)) {
			this.primaryReading = 0;
			this.katakana = new Katakana(kana);
			this.ipa = new Katakana2IPA().transcribe(katakana);
			this.romaji = new Katakana2Romaji().transcribe(katakana);
		} else if (Hiragana.isHiragana(kana)) {
			this.primaryReading = 1;
			this.hiragana = new Hiragana(kana);
			this.katakana = new Hiragana2Katakana().transcribe(hiragana);
			this.ipa = new Hiragana2IPA().transcribe(hiragana);
			this.romaji = new Hiragana2Romaji().transcribe(hiragana);
		} else {
			throw new RuntimeException();
		}
	}

	public Object getPrimaryReading() {
		return primaryReading == 0 ? katakana : hiragana;
	}
	
	public Katakana getKatakana() {
		return katakana;
	}

	public Hiragana getHiragana() {
		return hiragana;
	}

	public IPA getIpa() {
		return ipa;
	}

	public Romaji getRomaji() {
		return romaji;
	}
	
	
	
}
