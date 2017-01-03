package com.fuzzing.Oracle;

import java.awt.Color;

import javax.swing.JTextPane;

import org.apache.http.client.methods.CloseableHttpResponse;

import com.fuzzing.main.TextAreaStyle;

public class OracleCasTestURL {
	int good;
	int bad;
	public OracleCasTestURL() {
		good = 0;
		bad = 0;
	}
	
	public void executeOracle(CloseableHttpResponse rep, int codeRep, int nb, JTextPane tp, JTextPane tpStat){
		String msg;
		msg = "Reponse : "+rep.getStatusLine();
		if( rep.getStatusLine().getStatusCode() == codeRep){
			msg = msg + " Bad URL\n";
			TextAreaStyle.writeTextArea(tp, msg, Color.RED);
			TextAreaStyle.writeTextArea(tp, "\n", Color.RED);
			bad++;
		}else{
			msg = msg + " Good URL\n";
			TextAreaStyle.writeTextArea(tp, msg, Color.GREEN);
			TextAreaStyle.writeTextArea(tp, "\n", Color.GREEN);
			good++;
		}
		System.out.println();
		if( (bad + good) == nb ){
			msg = " Bilan sur "+nb+" Requests executées \n";
			TextAreaStyle.writeTextArea(tpStat, msg, Color.black);
			msg = " Good URL : " + good + "\n";
			TextAreaStyle.writeTextArea(tpStat, msg, Color.GREEN);
			msg = " Bad URL : " + bad + "\n";
			TextAreaStyle.writeTextArea(tpStat, msg, Color.red);
		}
	}
}
