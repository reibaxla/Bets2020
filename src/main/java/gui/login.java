package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import domain.Admin;
import domain.Bezero;
import domain.Erabiltzaile;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField postaString;
	private JPasswordField passString;
	private JLabel erroreaLB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel posta = new JLabel("Posta");
		posta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		posta.setBounds(60, 54, 78, 27);
		contentPane.add(posta);
		
		JLabel pasahitza = new JLabel("Pasahitza");
		pasahitza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pasahitza.setBounds(60, 136, 78, 14);
		contentPane.add(pasahitza);
		
		postaString = new JTextField();
		postaString.setBounds(190, 59, 179, 20);
		contentPane.add(postaString);
		postaString.setColumns(10);
		
		passString = new JPasswordField();
		passString.setBounds(190, 135, 179, 20);
		contentPane.add(passString);
		
		JButton sartu = new JButton("Log in");
		sartu.setBounds(89, 179, 89, 23);
		contentPane.add(sartu);
		sartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sartu_actionPerformed(e);
			}
		});
		
		
		erroreaLB = new JLabel("");
		erroreaLB.setBounds(136, 218, 255, 14);
		contentPane.add(erroreaLB);
		
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(254, 176, 115, 29);
		contentPane.add(btnErregistratu);
		btnErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erreg_actionPerformed(e);
			}
		});
	}

	private void sartu_actionPerformed(ActionEvent e) {
			
		BLFacade log1 = MainGUI.getBusinessLogic();
			
		String pass=new String(passString.getPassword());
		Erabiltzaile logina = log1.isLogin(postaString.getText(), pass);
		
		if(pass.isEmpty() || postaString.getText().isEmpty()) {
			erroreaLB.setText("Posta edo pasahitza okerra da");
		}
		else if(logina!=null) {
			if(logina instanceof Bezero) {
				BezeroaGUI a = new BezeroaGUI(logina);
				a.setVisible(true);
				this.setVisible(false);
			}
			else if(logina instanceof Admin) {
				MainGUI a = new MainGUI(logina);
				a.setVisible(true);
				this.setVisible(false);
			}
		}
		else {
			erroreaLB.setText("Posta edo pasahitza okerra da");
		}
	}
	public void erreg_actionPerformed(ActionEvent e) {
			erreg a = new erreg();
			a.setVisible(true);
			this.setVisible(false);
	}
}
