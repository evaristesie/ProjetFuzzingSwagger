package com.fuzzing.main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.fuzzing.casTest.CasTestAttribut;
import com.fuzzing.casTest.CasTestParametre;
import com.fuzzing.casTest.CasTestURL;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class Demarrage extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demarrage frame = new Demarrage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Demarrage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 492);
		setLocationRelativeTo(null); // centrer au demarrage
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFuzzerSwagger = new JLabel("FUZZER SWAGGER");
		lblFuzzerSwagger.setBackground(new Color(255, 255, 255));
		lblFuzzerSwagger.setForeground(new Color(60, 179, 113));
		lblFuzzerSwagger.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuzzerSwagger.setBounds(195, 11, 274, 26);
		lblFuzzerSwagger.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 17));
		contentPane.add(lblFuzzerSwagger);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 177, 589, 9);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 48, 317, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeDonnes = new JLabel("Nombre de Donn\u00E9es");
		lblNombreDeDonnes.setFont(new Font("Calisto MT", Font.BOLD, 12));
		lblNombreDeDonnes.setBounds(10, 14, 112, 14);
		panel.add(lblNombreDeDonnes);
		
		final JSpinner spinNbData = new JSpinner();
		spinNbData.setModel(new SpinnerNumberModel(20, 20, 1000, 1));
		spinNbData.setBounds(147, 10, 70, 20);
		panel.add(spinNbData);
		
		final JComboBox cb_CasTest = new JComboBox();
		cb_CasTest.setModel(new DefaultComboBoxModel(new String[] {"CasTest URL", "CasTest Attribut", "CasTest Parametre"}));
		cb_CasTest.setBounds(147, 44, 160, 20);
		panel.add(cb_CasTest);
		
		final JTextPane ecran = new JTextPane();
		ecran.setBounds(10, 196, 569, 212);
		JScrollPane scrollPane = new JScrollPane(ecran);
		scrollPane.setLocation(10, 202);
		scrollPane.setSize(569, 206);
		contentPane.add(scrollPane,ecran);
		
		final JTextPane ecranStat = new JTextPane();
		ecranStat.setFont(new Font("Calisto MT", Font.PLAIN, 12));
		ecranStat.setBounds(359, 66, 220, 100);
		contentPane.add(ecranStat);
		
		JLabel lblCasDeTest = new JLabel("Cas de Test");
		lblCasDeTest.setFont(new Font("Calisto MT", Font.BOLD, 12));
		lblCasDeTest.setBounds(10, 47, 70, 20);
		panel.add(lblCasDeTest);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TextAreaStyle.writeTextArea(ecran, "", Color.RED);
				Swagger swagger = new SwaggerParser().read("./src/swagger.json");
				int nbData = Integer.parseInt(spinNbData.getValue().toString());
				String choix = cb_CasTest.getSelectedItem().toString();
				switch (choix) {
				case "CasTest URL":
					CasTestURL testURL = new CasTestURL(swagger);
					testURL.startTest(nbData, ecran, ecranStat);
					break;
				
				case "CasTest Attribut":
					CasTestAttribut testAttribut = new CasTestAttribut();
					testAttribut.verifieAttribut(nbData,ecran, ecranStat);
					break;
				case "CasTest Parametre":
					CasTestParametre testParametre = new CasTestParametre();
					testParametre.VerifParametre(nbData,ecran, ecranStat);
					break;	

				default:
					break;
				}
				
			}
		});
		btnValider.setBounds(218, 84, 89, 23);
		panel.add(btnValider);
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ecran.setText("");
				ecranStat.setText("");
			}
		});
		btnClear.setBounds(490, 419, 89, 23);
		contentPane.add(btnClear);
		
		JLabel lblStatistiques = new JLabel("Statistiques");
		lblStatistiques.setFont(new Font("Calisto MT", Font.BOLD, 12));
		lblStatistiques.setBounds(359, 48, 76, 14);
		contentPane.add(lblStatistiques);
		
	}
}
