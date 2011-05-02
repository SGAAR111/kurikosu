package org.kurikosu.lang;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Katakana implements Serializable {

	public final static String SOKUON = "ッ";
	
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
	
	public final static String[] I_MONOGRAPHS = new String[] {"イ", "ィ", "キ", "シ", "チ", "ニ", "ヒ", "ミ", "リ", "ヰ", "ギ", "ジ", "ヂ", "ビ", "ピ", "リ゜"};
	
	public final static String[] N_DIGRAPHS   = new String[] {"ニャ", "ニュ", "ニョ" };
	
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
}
