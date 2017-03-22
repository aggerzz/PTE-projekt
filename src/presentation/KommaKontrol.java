package presentation;

import javafx.scene.control.TextField;

public class KommaKontrol {
	public String kontrol(String s, TextField tf) {
		if (s.contains(",")) {
			s = s.replaceAll(",", ".");
		}
		if (s.indexOf(".") != s.lastIndexOf(".")) {
			s = sletPunktumAtCursorPosition(s,tf);
			tf.selectPositionCaret(tf.getCaretPosition());

		}
		return s;
	}

	private String sletPunktummer(String s) {
		String s1 = s.substring(0, s.indexOf("."));
		String s2 = s.substring(s.indexOf("."), s.lastIndexOf("."));
		String s3 = s.substring(s.lastIndexOf("."), s.length());
		return s = s1 + s3;
	}

	private String sletPunktumAtCursorPosition(String s, TextField tf) {
		String s1 = s.substring(0, tf.getCaretPosition()-1);
		String s2 = s.substring(tf.getCaretPosition(), s.length());
		
		return s1+s2;
	}
}
