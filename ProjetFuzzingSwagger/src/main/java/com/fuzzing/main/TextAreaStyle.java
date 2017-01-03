package com.fuzzing.main;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class TextAreaStyle {
	

		 static public void writeTextArea (JTextPane tp, String msg, Color c)
		    {
		        StyleContext sc = StyleContext.getDefaultStyleContext();
		        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

		        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Calisto MT");
		        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);
		        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

		        int len = tp.getDocument().getLength();
		        tp.setCaretPosition(len);
		        tp.setCharacterAttributes(aset, false);
		        tp.replaceSelection(msg);
		    }
			
	
}
