package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.RegisterController;
import controllers.UpdateController;
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

public class EditVoter extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private RegisterController registerController = new RegisterController();
	/**
	 * Create the frame.
	 */
	public EditVoter() {
		JButton btnCadastrar = new JButton("Salvar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel lblCadastroDoEleitor = new JLabel("Editar Eleitor");
		lblCadastroDoEleitor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDoEleitor.setBounds(123, 12, 137, 21);
		contentPane.add(lblCadastroDoEleitor);
		
		JTextPane inputNumRegister = new JTextPane();
		inputNumRegister.setBounds(50, 86, 152, 30);
		contentPane.add(inputNumRegister);
		
		JLabel lblNmeroDeCadastro = new JLabel("Número de Cadastro");
		lblNmeroDeCadastro.setBounds(50, 71, 159, 15);
		contentPane.add(lblNmeroDeCadastro);
		
		JTextPane name = new JTextPane();
		name.setBounds(50, 143, 288, 30);
		name.setVisible(false);
		contentPane.add(name);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 127, 159, 15);
		lblNome.setVisible(false);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 182, 159, 15);
		lblSenha.setVisible(false);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 196, 288, 30);
		passwordField.setVisible(false);;
		contentPane.add(passwordField);
		
		
		btnCadastrar.setBounds(131, 330, 117, 25);
		btnCadastrar.setVisible(false);
		contentPane.add(btnCadastrar);
		
		JLabel lblGeolocalizao = new JLabel("Geolocalização");
		lblGeolocalizao.setBounds(50, 238, 159, 15);
		lblGeolocalizao.setVisible(false);
		contentPane.add(lblGeolocalizao);
		
		JTextPane inputX = new JTextPane();
		inputX.setBounds(50, 278, 137, 30);
		inputX.setVisible(false);
		contentPane.add(inputX);
		
		JTextPane inputY = new JTextPane();
		inputY.setBounds(199, 278, 139, 30);
		inputY.setVisible(false);
		contentPane.add(inputY);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(112, 261, 38, 15);
		lblX.setVisible(false);
		contentPane.add(lblX);
		
		JLabel lblY = new JLabel("Y");
		lblY.setBounds(262, 261, 38, 15);
		lblY.setVisible(false);
		contentPane.add(lblY);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TechnicalInterface().setVisible(true);
			}
		});
		btnSair.setBounds(305, 0, 84, 25);
		contentPane.add(btnSair);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(inputNumRegister.getText());
					var voter = UpdateController.getVoter(id);
					lblY.setVisible(true);
					lblX.setVisible(true);
					inputY.setVisible(true);
					inputX.setVisible(true);
					lblGeolocalizao.setVisible(true);
					lblSenha.setVisible(true);
					passwordField.setVisible(true);
					lblNome.setVisible(true);
					name.setVisible(true);
					inputNumRegister.setEnabled(false);
					btnPesquisar.setEnabled(false);
					name.setText( voter.getName() );
					passwordField.setText(voter.getPassword());
					inputX.setText( String.valueOf(voter.getPoint().x) );
					inputY.setText( String.valueOf(voter.getPoint().y) );
					btnCadastrar.setVisible(true);
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		btnPesquisar.setBounds(214, 86, 119, 25);
		contentPane.add(btnPesquisar);
		
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				int id = Integer.parseInt(inputNumRegister.getText());
				int x = Integer.parseInt(inputX.getText());
				int y = Integer.parseInt(inputY.getText());
				//var voter = new Voter(Voter.count++, passwordField.getText(), getName(), new Point(x, y));
				try {
	
					UpdateController.updateVoter (id,  name.getText(), passwordField.getText(), new Point(x, y));
					JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!");
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
