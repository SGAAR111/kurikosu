package org.kurikosu.transcription;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.kurikosu.lang.IPA;
import org.kurikosu.lang.Katakana;

@RunWith(value = Parameterized.class)
public class Katakana2IPAAcceptanceTest {

	private final String katakana;
	
	private final String ipa;

	/**
	 * @param katakana
	 * @param ipa
	 */
	public Katakana2IPAAcceptanceTest(String katakana, String ipa) {
		this.katakana = katakana;
		this.ipa = ipa;
	}

	@Test
	public void shouldEncodePhonetic() throws Exception {
		assertEquals(new IPA(ipa), new Katakana2IPA().transcribe(new Katakana(katakana)));
	}
	
	@Parameters
	public static Collection<String[]> data() {
		
		String[][] params = new String[][] {
			new String[] { "カガミ", "kaŋami" },		// [01] kaŋami, kaɡami, kaɣami
			new String[] { "アブナイ", "abɯnai" },	// [02]
			new String[] { "カザリ", "kazaɾi" },		// [03]
			new String[] { "ザリガニ", "dzaɾiɡaɲi" },	// [04]
			new String[] { "シンブン", "ɕimbɯɴ" },	// [05]
			new String[] { "ジブン", "dʑibɯɴ" },		// [06]
			new String[] { "ヒカク", "hikakɯ" },		// [07] hi̥kakɯ
			new String[] { "ツヅク", "tsɯzɯkɯ" },		// [08] tsɯ̥zɯkɯ
			new String[] { "ハジ", "haʑi" }, 		// [09] hadʑi
			new String[] { "ハチ", "hatɕi" },		// [10]
			new String[] { "コンニャク", "koɲɲakɯ"},	// [11]
			new String[] { "ダイチ", "daitɕi" }, 		// [12] daitɕi̥
			new String[] { "イソガイ", "isoŋai" },	// [13]
			new String[] { "フッサ", "ɸɯssa" }, 		// [14] ɸɯ̥s̚sa
			new String[] { "イッポン", "ippoɴ" },		// [15] ip̚poɴ
			new String[] { "マルイ", "maɾɯi" }		// [16]
		};
		
		return Arrays.asList(params);
	}
}