package org.kurikosu.transcription;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.kurikosu.transcription.Katakana2IPA;

@RunWith(value=Parameterized.class)
public class KatakanaN_KanaUnitTest {
	
	private String a;
	
	private String b;

	/**
	 * @param a
	 * @param b
	 */
	public KatakanaN_KanaUnitTest(String a, String b) {
		this.a = a;
		this.b = b;
	}

	@Test
	public void testNEncoding() {
		assertEquals(b, Katakana2IPA.transcribeN_Kana(a));
	}
	
	@Parameters
	public static Collection<String[]> data() {
		String[][] data = new String[][] {
			// Followed by 
			new String[] { "ンタ", "nタ" },
			new String[] { "ミンハ", "ミĩハ"},
			new String[] { "タンハ", "タũ͍ハ"}
		};
		
		return Arrays.asList(data);
	}
}
