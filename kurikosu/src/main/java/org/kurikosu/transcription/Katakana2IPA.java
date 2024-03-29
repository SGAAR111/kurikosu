package org.kurikosu.transcription;

import static org.kurikosu.lang.Katakana.B_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.D_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.G_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.H_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.I_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.K_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.M_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.N;
import static org.kurikosu.lang.Katakana.N_DIGRAPHS;
import static org.kurikosu.lang.Katakana.N_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.P_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.R_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.SOKUON;
import static org.kurikosu.lang.Katakana.S_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.T_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.VOWEL_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.W_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.Y_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.Z_MONOGRAPHS;

import java.util.Properties;

import org.kurikosu.lang.IPA;
import org.kurikosu.lang.Katakana;
import org.kurikosu.lang.Substring;
import org.kurikosu.lang.Word;
import org.kurikosu.util.PropertiesUtils;

public class Katakana2IPA {

	public interface ReplacementRule {
		public String apply(String word);
	}

	public IPA transcribe(Katakana katakana) {
		
		Word ipa = new Word(katakana.getValue());

		ipa = transcribeSokuon(ipa);
		ipa = transcribeN_Kana(ipa);
		ipa = ipa.replaceAll(digraphs());
		ipa = ipa.replaceAll(monographs());
		
		return new IPA(ipa.value());
	}
	
	private Word transcribeN_Kana(Word ipa) {
		return new Word(transcribeN_Kana(ipa.value()));
	}

	Word transcribeSokuon(Word word) {
		
		if (word.startsWith(SOKUON)) {
			throw new TranscriptionException("Sokuon must not appear at the beginning of a word!", word.value());
		}
		
		while (word.hasSubstring(SOKUON)) {
			
			final Substring sokuon = word.firstSubstring(SOKUON);

			if (sokuon.isFollowedBy(VOWEL_MONOGRAPHS)) {
				throw new TranscriptionException("Sokuon must not appear before vowel", word.value());
			} else if (sokuon.isFollowedBy(N_MONOGRAPHS, M_MONOGRAPHS, R_MONOGRAPHS, W_MONOGRAPHS, Y_MONOGRAPHS)) {
				throw new TranscriptionException("Sokuon must not appear before N, M, R, W or Y", word.value());
			} else if (sokuon.isFollowedBy(G_MONOGRAPHS, Z_MONOGRAPHS, D_MONOGRAPHS, B_MONOGRAPHS)) {
				throw new TranscriptionException("Sokuon must not appear before G, Z, D, or B", word.value());
			} else if (sokuon.isFollowedBy(K_MONOGRAPHS)) {
				word = word.replace(sokuon, "k");
			} else if (sokuon.isFollowedBy(S_MONOGRAPHS)) {
				word = word.replace(sokuon, "s");
			} else if (sokuon.isFollowedBy(T_MONOGRAPHS)) {
				word = word.replace(sokuon, "t");
			} else if (sokuon.isFollowedBy(H_MONOGRAPHS)) {
				word = word.replace(sokuon, "h");
			} else if (sokuon.isFollowedBy(P_MONOGRAPHS)) {
				word = word.replace(sokuon, "p");
			} else {
				throw new TranscriptionException("No rule to transcribe Sokuon!", word.value());
			}
		}
		
		return word;
	}

	String transcribeSokuon(String value) {
		
		Word word = new Word(value);

		return transcribeSokuon(word).value();
	}
	
	/**
	 * http://en.wikipedia.org/wiki/N_%28kana%29
	 * 
	 * @param value
	 * @return
	 */
	protected static String transcribeN_Kana(String value) {

		Word word = new Word(value);
		
		if (word.endsWith(N)) {
			word = word.replaceLastCharacterBy("ɴ");
		}
		
		while (word.hasSubstring(N)) {
			
			Substring n = word.firstSubstring(N);
			
			if (n.isFollowedBy(T_MONOGRAPHS, D_MONOGRAPHS, Z_MONOGRAPHS, N_MONOGRAPHS, R_MONOGRAPHS) && n.isNotFollowedBy(N_DIGRAPHS)) {
				word = word.replace(n, "n");
			} else if (n.isFollowedBy(M_MONOGRAPHS, P_MONOGRAPHS, B_MONOGRAPHS)) {
				word = word.replace(n, "m");
			} else if (n.isFollowedBy(K_MONOGRAPHS, G_MONOGRAPHS, N_DIGRAPHS)) {
				word = word.replace(n, "ŋ");
			} else if (n.isFollowedBy(VOWEL_MONOGRAPHS, H_MONOGRAPHS, S_MONOGRAPHS, W_MONOGRAPHS) && n.isPreceededBy(I_MONOGRAPHS)) {
				word = word.replace(n, "ĩ");
			} else if (n.isFollowedBy(VOWEL_MONOGRAPHS, H_MONOGRAPHS, S_MONOGRAPHS, W_MONOGRAPHS)) {
				word = word.replace(n, "ũ͍");
			} else {
				throw new TranscriptionException("No rule to transcribe '" + N + "'!", value);
			}
		}
		
		return word.value();
	}

	private Properties digraphs() {
		return PropertiesUtils.get("org/kurikosu/transcription/DigraphsPhonetic.wiki.xml");
	}
	
	private Properties monographs() {
		return PropertiesUtils.get("org/kurikosu/transcription/MonographsPhonetic.xml");
	}
}