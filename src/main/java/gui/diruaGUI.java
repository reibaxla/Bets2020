package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import businessLogic.BLFacade;
import domain.Erabiltzaile;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class diruaGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Erabiltzaile logeatuta;
	private JTextField textFieldDiru;
	private JTextField textIzena;
	private JTextField textTxartela;
	private JTextField textHilabetea;
	private JTextField textUrtea;
	private JTextField textCVV;
	private JLabel jLabelMezu = new JLabel(" ");
	private JLabel jLabelErrore = new JLabel(" ");
	
	public diruaGUI(Erabiltzaile logeatuta)
	{
		try
		{
			this.logeatuta=logeatuta;
			jbInit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void jbInit() throws Exception{
		getContentPane().setLayout(null);
		this.setSize(new Dimension(422, 297));
		
		JLabel Kantitatea = new JLabel("Sartu nahi duzun kantitatea");
		Kantitatea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Kantitatea.setBounds(26, 60, 192, 34);
		getContentPane().add(Kantitatea);
		
		textFieldDiru = new JTextField();
		textFieldDiru.setBounds(251, 67, 86, 22);
		getContentPane().add(textFieldDiru);
		textFieldDiru.setColumns(10);
		
		JLabel euro = new JLabel("\u20AC");
		euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		euro.setBounds(349, 69, 56, 16);
		getContentPane().add(euro);
		
		JLabel lblIzenabizena = new JLabel("Izen-Abizena:");
		lblIzenabizena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIzenabizena.setBounds(27, 43, 127, 16);
		getContentPane().add(lblIzenabizena);
		
		textIzena = new JTextField();
		textIzena.setColumns(10);
		textIzena.setBounds(132, 41, 240, 22);
		getContentPane().add(textIzena);
		
		JLabel lblTxartelarenZenbakia = new JLabel("Txartelaren zenbakia");
		lblTxartelarenZenbakia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTxartelarenZenbakia.setBounds(26, 98, 146, 16);
		getContentPane().add(lblTxartelarenZenbakia);
		
		textTxartela = new JTextField();
		textTxartela.setColumns(10);
		textTxartela.setBounds(171, 96, 201, 22);
		getContentPane().add(textTxartela);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 127, 42, 16);
		getContentPane().add(lblNewLabel);
		
		textHilabetea = new JTextField();
		textHilabetea.setColumns(10);
		textHilabetea.setBounds(77, 125, 49, 22);
		getContentPane().add(textHilabetea);
		
		textUrtea = new JTextField();
		textUrtea.setColumns(10);
		textUrtea.setBounds(147, 125, 49, 22);
		getContentPane().add(textUrtea);
		
		JLabel label = new JLabel("/");
		label.setBounds(132, 128, 13, 16);
		getContentPane().add(label);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCvv.setBounds(26, 156, 42, 16);
		getContentPane().add(lblCvv);
		
		textCVV = new JTextField();
		textCVV.setColumns(10);
		textCVV.setBounds(76, 154, 78, 22);
		getContentPane().add(textCVV);
		
		jLabelMezu.setBounds(162, 220 ,276, 22);
		getContentPane().add(jLabelMezu);
		jLabelErrore.setForeground(Color.RED);
		jLabelErrore.setBounds(162, 220, 276, 14);
		getContentPane().add(jLabelErrore);
		
		JButton btnSartu = new JButton("SARTU");
		btnSartu.setBounds(147, 185, 127, 22);
		getContentPane().add(btnSartu);
		
		
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dirukant = textFieldDiru.getText();
								
				if(dirukant.length()>0) { //Zerbait sartu da
					double quantity = Double.parseDouble(textFieldDiru.getText());
					if (quantity<=10 || quantity>=500) {
						jLabelMezu.setText("");
						jLabelErrore.setText("Sartu duzun kantitatea ez da 10 eta 500 artekoa");
					}else {
						String hila = textHilabetea.getText();
						String urte = textUrtea.getText();
						String txart = textTxartela.getText();
						String zenb = textCVV.getText();
						
						if(txart.length()==16) {
							if (hila.length()==2) {
								if( urte.length()==2) {
								int hila1 = Integer.parseInt(hila);
								int urte1 = Integer.parseInt(urte);
								if (hila1> 0 && hila1<= 12 && urte1>=20) {
									if (zenb.length()==3) {
										
										BLFacade b = MainGUI.getBusinessLogic();
										b.updateUser(logeatuta, quantity);
											
										jLabelErrore.setText("");
										jLabelMezu.setText("Dirua sartu da.");
																
									}else {
										jLabelErrore.setText("Errore bat dago, cvv-rekin. ");
										jLabelMezu.setText("");
									}
									
								}else {
									jLabelErrore.setText("Errore bat dago, urtea edo hilabetearekin ");
									jLabelMezu.setText("");
								}
								
							}else {
								jLabelErrore.setText("Errore bat dago, urtearekin. ");
								jLabelMezu.setText("");
							}
							}else {
								jLabelErrore.setText("Errore bat dago, hilabetearekin. ");
								jLabelMezu.setText("");
							}
								
							}else {
								jLabelErrore.setText("Errore bat dago, txartel zenbakiarekin. ");
								jLabelMezu.setText("");
							}
						}
					}else {
						jLabelErrore.setText("Errore bat dago, diru kantitatearekin. ");
						jLabelMezu.setText("");
					}			
			}
		});
	}
}

