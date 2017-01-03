package com.fuzzing.Oracle;

import java.awt.Color;

import javax.swing.JTextPane;

import org.apache.http.client.methods.CloseableHttpResponse;

import com.fuzzing.main.TextAreaStyle;

public class OracleCasTestParametre {

	public int good = 0, bad = 0;

	public void OracleVerifParametre(CloseableHttpResponse rep, int codestatut, int a, int nbParamGenerer, JTextPane tp,
			JTextPane tpStat) {
		String msg;
		if (rep.getStatusLine().getStatusCode() == codestatut) {
			bad++;
			msg = " Bad Parameter \n";
			TextAreaStyle.writeTextArea(tp, msg, Color.RED);
		} else {
			good++;
			msg = " Good Parameter \n";
			TextAreaStyle.writeTextArea(tp, msg, Color.GREEN);
		}

		if (a == nbParamGenerer - 1) {
			a = nbParamGenerer;
			msg = " Bilan sur "+a+" paramètres générés de façon aléatoire: \n";
			TextAreaStyle.writeTextArea(tpStat, msg, Color.black);
			msg = "Good parameter=" + good + "\n";
			TextAreaStyle.writeTextArea(tpStat, msg, Color.GREEN);
			msg = " Bad parameter : " + bad + "\n";
			TextAreaStyle.writeTextArea(tpStat, msg, Color.red);

		}
	}
}
