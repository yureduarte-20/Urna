package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;
import dominio.Voter;

public class VoterLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Main frame = new Main();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public VoterLogin() {



		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Login do Eleitor");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(146, 25, 230, 41);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(137, 153, 239, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNmeroDeIdentificao = new JLabel("Número de Identificação");
		lblNmeroDeIdentificao.setBounds(173, 136, 179, 15);
		contentPane.add(lblNmeroDeIdentificao);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(238, 217, 59, 15);
		contentPane.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(137, 235, 239, 32);
		contentPane.add(passwordField);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Voter tec = Autenticator.auth.validateVoter( Integer.parseInt( textField.getText() ) , passwordField.getText() );
					Autenticator.authenticatedVoter = tec;

					dispose();
					new VoterInterface().setVisible(true);

				} catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(null, "Por favor digite uma senha no campo \"Número de indentificação\"");
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, error.getMessage());
				}



			}
		});
		btnEntrar.setBounds(211, 305, 117, 25);
		contentPane.add(btnEntrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SelectResource().setVisible(true);
			}
		});
		btnVoltar.setBounds(447, 0, 77, 25);
		contentPane.add(btnVoltar);
	}
}
