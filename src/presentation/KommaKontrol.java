package presentation;

import javafx.scene.control.TextField;

public class KommaKontrol {
	private int cursorPos;
	
	public String kontrol(String s, TextField tf) {
		cursorPos = tf.getCaretPosition();
		
		if (s.contains(",")) {
			s = s.replaceAll(",", ".");
		}
		if (s.indexOf(".") != s.lastIndexOf(".")) {
			s = sletPunktumAtCursorPosition(s,tf);
			
			cursorPos = cursorPos - 1;
			
		}
		return s;
	}

	public int getCursorPos() {
	
		return cursorPos;
	}

	private String sletPunktumAtCursorPosition(String s, TextField tf) {
		String s1 = s.substring(0, tf.getCaretPosition()-1);
		String s2 = s.substring(tf.getCaretPosition(), s.length());
		
		return s1+s2;
	}
}
