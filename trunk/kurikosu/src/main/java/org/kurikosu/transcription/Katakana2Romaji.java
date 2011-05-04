package org.kurikosu.transcription;

import static org.kurikosu.lang.Katakana.A_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.B_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.CHOONPU;
import static org.kurikosu.lang.Katakana.D_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.E_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.G_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.H_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.I_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.K_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.M_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.N;
import static org.kurikosu.lang.Katakana.N_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.O_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.P_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.R_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.SOKUON;
import static org.kurikosu.lang.Katakana.S_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.T_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.U_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.VOWEL_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.W_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.Y_MONOGRAPHS;
import static org.kurikosu.lang.Katakana.Z_MONOGRAPHS;

import java.util.Properties;

import org.kurikosu.lang.Katakana;
import org.kurikosu.lang.Romaji;
import org.kurikosu.lang.Substring;
import org.kurikosu.lang.Word;
import org.kurikosu.util.PropertiesUtils;

public class Katakana2Romaji {

	public Romaji transcribe(Katakana katakana) {
		Word word = new Word(katakana.getValue());
		
		word = transcribeN_Kana(word);
		
		word = transcribeSokuon(word);
		
		word = word.replaceAll(digraphs());
		
		word = word.replaceAll(monographs());
		
		word = transcribeDoubleVowel(word);
		
		return new Romaji(word.value());
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
	
	private Word transcribeDoubleVowel(Word word) {
		
		Properties properties = new Properties();
		
		properties.put("aa", "ā");
		
		properties.put("aー", "ā");
		
		properties.put("ii", "ī");

		properties.put("iー", "ī");

		properties.put("uu", "ū");

		properties.put("uー", "ū");

		properties.put("ee", "ē");
		
		properties.put("ei", "ē");

		properties.put("eー", "ē");

		properties.put("oo", "ō");

		properties.put("ou", "ō");
		
		properties.put("oー", "ō");

		word = word.replaceAll(properties);
		
		return word;
	}

	Word transcribeChoonpu(Word word) {
		
		if (word.startsWith(CHOONPU)) {
			throw new TranscriptionException("Choonpu must not appear at the beginning of a word!", word.value());
		}
		
		while (word.hasSubstring(CHOONPU)) {
			
			final Substring choonpu = word.firstSubstring(CHOONPU);

			if (choonpu.isPreceededBy(A_MONOGRAPHS)) {
				word = word.replace(choonpu, "a");
			} else if (choonpu.isPreceededBy(I_MONOGRAPHS)) {
				word = word.replace(choonpu, "i");
			} else if (choonpu.isPreceededBy(U_MONOGRAPHS)) {
				word = word.replace(choonpu, "u");
			} else if (choonpu.isPreceededBy(E_MONOGRAPHS)) {
				word = word.replace(choonpu, "e");
			} else if (choonpu.isPreceededBy(O_MONOGRAPHS)) {
				word = word.replace(choonpu, "o");
			} else {
				throw new TranscriptionException("No rule to transcribe Choonpu!", word.value());
			}
		}
		
		return word;
	}

	Word transcribeN_Kana(final Word w) {

		Word word = w;
		
		if (word.endsWith(N)) {
			word = word.replaceLastCharacterBy("n");
		}
		
		while (word.hasSubstring(N)) {
			Substring n = word.firstSubstring(N);
			if (n.isFollowedBy(M_MONOGRAPHS, P_MONOGRAPHS, B_MONOGRAPHS)) {
				word = word.replace(n, "m");
			} else {
				word = word.replace(n, "n");
			}
		}
		
		return word;
	}
	
	private Properties monographs() {
		return PropertiesUtils.get("org/kurikosu/transcription/MonographsKatakana2Romanji.hepburn.xml");
	}

	private Properties digraphs() {
		return PropertiesUtils.get("org/kurikosu/transcription/DigraphsKatakana2Romanji.hepburn.xml");
	}

}
