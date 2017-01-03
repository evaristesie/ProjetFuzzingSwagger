package com.fuzzing.Oracle;

import java.awt.Color;

import javax.swing.JTextPane;

import org.apache.http.client.methods.CloseableHttpResponse;

import com.fuzzing.main.TextAreaStyle;

public class OracleCasTestAttribut {
	public int good = 0, bad = 0;

	public void OracleVerifAttribut(CloseableHttpResponse rep, int codestatut, int a, int nombreAttribGenerer, JTextPane tp, JTextPane tpStat) {
		String msg;
		// verifie si le code retourné par la requette correspond code attendu
		if (rep.getStatusLine().getStatusCode() == codestatut) {
			msg = " Good Attribut \n";
			TextAreaStyle.writeTextArea(tp, msg, Color.GREEN);
			good++;

		} else {
			msg = " Bad Attribut \n";
			TextAreaStyle.writeTextArea(tp, msg, Color.RED);
			bad++;
		}

		if (a == nombreAttribGenerer - 1) {
			a = nombreAttribGenerer;
			msg = " Bilan sur "+a+" attribut générés de façon aléatoire: \n";
			TextAreaStyle.writeTextArea(tpStat, msg, Color.black);
			msg = "Good Attribut=" + good + "\n";
			TextAreaStyle.writeTextArea(tpStat, msg, Color.GREEN);
			msg = " Bad Attribut : " + bad + "\n";
			TextAreaStyle.writeTextArea(tpStat, msg, Color.red);

		}
	}
}
