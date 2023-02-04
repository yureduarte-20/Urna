package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Technician;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterVoter extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public RegisterVoter() {
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
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(95, 163, 288, 30);
		contentPane.add(textPane_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(95, 148, 159, 15);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(95, 224, 159, 15);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 239, 288, 30);
		contentPane.add(passwordField);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Technician.technical.add( new Technician( Integer.parseInt( inputNumRegister.getText() ) , passwordField.getText()) );
			}
		});
		btnCadastrar.setBounds(174, 305, 117, 25);
		contentPane.add(btnCadastrar);
	}
}
