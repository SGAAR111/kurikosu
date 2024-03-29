package org.kurikosu.lang;

import java.io.Serializable;

import org.kurikosu.util.StringUtils;

@SuppressWarnings("serial")
public class Katakana implements Serializable {

	public final static String CHOONPU = "ー";
	
	public final static String SOKUON = "ッ";
	
	public final static String[] KURIKAESHI = new String[] { "ヽ",  };
	
	public final static String N = "ン";
	
	public final static String[] VOWEL_MONOGRAPHS = new String[] { "ア", "イ", "ウ", "エ", "オ" };

	public final static String[] K_MONOGRAPHS = new String[] {"カ", "キ", "ク", "ケ", "コ"};

	public final static String[] S_MONOGRAPHS = new String[] {"サ", "シ", "ス", "セ", "ソ"};

	public final static String[] T_MONOGRAPHS = new String[] {"タ", "チ", "ツ", "テ", "ト"};

	public final static String[] N_MONOGRAPHS = new String[] {"ナ", "ニ", "ヌ", "ネ", "ノ"};

	public final static String[] H_MONOGRAPHS = new String[] {"ハ", "ヒ", "フ", "ヘ", "ホ"};
	
	public final static String[] M_MONOGRAPHS = new String[] {"マ", "ミ", "ム", "メ", "モ"};
	
	public final static String[] Y_MONOGRAPHS = new String[] {"ヤ", "ユ", "ヨ"};
	
	public final static String[] R_MONOGRAPHS = new String[] {"ラ", "リ", "ル", "レ", "ロ"};

	public final static String[] W_MONOGRAPHS = new String[] {"ワ", "ヰ", "ヱ", "ヲ"};

	public final static String[] G_MONOGRAPHS = new String[] {"ガ", "ギ", "グ", "ゲ", "ゴ"};
	
	public final static String[] Z_MONOGRAPHS = new String[] {"ザ", "ジ", "ズ", "ゼ", "ゾ"};

	public final static String[] D_MONOGRAPHS = new String[] {"ダ", "ヂ", "ヅ", "デ", "ド"};

	public final static String[] B_MONOGRAPHS = new String[] {"バ", "ビ", "ブ", "ベ", "ボ"};

	public final static String[] P_MONOGRAPHS = new String[] {"パ", "ピ", "プ", "ペ", "ポ"};
	
	public final static String[] N_DIGRAPHS   = new String[] {"ニャ", "ニュ", "ニョ" };
	
	// ---
	
	public final static String[] A_MONOGRAPHS = new String[] { "ア", "ャ", "カ", "サ", "タ", "ナ", "ハ", "マ", "ヤ", "ラ", "ワ", "ガ", "ザ", "ダ", "バ", "パ"};

	public final static String[] I_MONOGRAPHS = new String[] {"イ", "ィ", "キ", "シ", "チ", "ニ", "ヒ", "ミ", "リ", "ヰ", "ギ", "ジ", "ヂ", "ビ", "ピ", "リ゜"};

	public final static String[] U_MONOGRAPHS = new String[] { "ウ", "ゥ", "ュ", "ク", "ス", "ツ", "ヌ", "フ", "ム", "ユ", "ル", "グ", "ズ", "ヅ", "ブ", "プ"};

	public final static String[] E_MONOGRAPHS = new String[] { "エ", "ケ", "セ", "テ", "ネ", "ヘ", "メ", "レ", "ヱ", "ゲ", "ゼ", "デ", "ベ", "ペ"};

	public final static String[] O_MONOGRAPHS = new String[] { "オ", "ョ", "コ", "ソ", "ト", "ノ", "ホ", "モ", "ヨ", "ロ", "ヲ", "ゴ", "ゾ", "ド", "ボ", "ポ", "ロ"};

	public static final char UNICODE_RANGE_START = '\u30A0';

	public static final char UNICODE_RANGE_END = '\u30FF';

	private String value;

	/**
	 * @param value
	 */
	public Katakana(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object arg0) {
		return this.getClass().isAssignableFrom(arg0.getClass()) ? 
				this.hashCode() == arg0.hashCode() : 
					super.equals(arg0);
	}
	
	@Override
	public String toString() {
		return this.getValue();
	}
	
	public static boolean isKatakana(String string) {
		return StringUtils.isWithinUnicodeRange(string, UNICODE_RANGE_START, UNICODE_RANGE_END);
	}
}