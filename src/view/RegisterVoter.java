package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.RegisterController;
import dominio.Session;
import dominio.Technician;
import dominio.Voter;
import dominio.Zone;
import exceptions.UserAlreadyExists;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterVoter extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private RegisterController registerController = new RegisterController();
	/**
	 * Create the frame.
	 */
	public RegisterVoter() {
		JButton btnCadastrar = new JButton("Cadastrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel lblCadastroDoEleitor = new JLabel("Cadastro do Eleitor");
		lblCadastroDoEleitor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDoEleitor.setBounds(140, 12, 177, 21);
		contentPane.add(lblCadastroDoEleitor);
		
		JTextPane inputNumRegister = new JTextPane();
		inputNumRegister.setBounds(95, 86, 288, 30);
		contentPane.add(inputNumRegister);
		
		JLabel lblNmeroDeCadastro = new JLabel("Número de Cadastro");
		lblNmeroDeCadastro.setBounds(95, 71, 159, 15);
		contentPane.add(lblNmeroDeCadastro);
		
		JTextPane name = new JTextPane();
		name.setBounds(95, 143, 288, 30);
		contentPane.add(name);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(105, 128, 159, 15);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(95, 182, 159, 15);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 196, 288, 30);
		contentPane.add(passwordField);
		
		
		btnCadastrar.setBounds(174, 305, 117, 25);
		contentPane.add(btnCadastrar);
		
		JLabel lblGeolocalizao = new JLabel("Geolocalização");
		lblGeolocalizao.setBounds(95, 224, 159, 15);
		contentPane.add(lblGeolocalizao);
		
		JTextPane inputX = new JTextPane();
		inputX.setBounds(95, 264, 137, 30);
		contentPane.add(inputX);
		
		JTextPane inputY = new JTextPane();
		inputY.setBounds(244, 264, 139, 30);
		contentPane.add(inputY);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(95, 238, 38, 15);
		contentPane.add(lblX);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(244, 237, 159, 15);
		contentPane.add(lblY);
		
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				int id = Integer.parseInt(inputNumRegister.getText());
				int x = Integer.parseInt(inputX.getText());
				int y = Integer.parseInt(inputY.getText());
				//var voter = new Voter(Voter.count++, passwordField.getText(), getName(), new Point(x, y));
				try {
					if(Zone.getZones().size() <=0) {
						var z =  new Zone( new Point(1, 2));
						var z2 = new Zone(new Point(7,8));
						var s1 = new Session(1 , new Point(2,3));
						var s2 = new Session(2 , new Point(7,3));
						z.addSession(s1);
						z2.addSession(s2);
						Zone.addZone(z);
						Zone.addZone(z2);
					}
					RegisterController.registerVoter(id, passwordField.getText(), name.getText(), new Point(x, y));
					System.out.println(Voter.voters.size());						
					dispose();
					new TechnicalInterface().setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				//int y = Integer.parseInt(getWarningString())
				//RegisterController.registerVoter();
				//Technician.technical.add( new Technician( Integer.parseInt( inputNumRegister.getText() ) , passwordField.getText()) );
				
			}
		});
	}
}
