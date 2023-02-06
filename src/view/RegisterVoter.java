package view;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.RegisterController;

public class RegisterVoter extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private RegisterController registerController = new RegisterController();
	/**
	 * Create the frame.
	 */
	public RegisterVoter() {
		JButton btnCadastrar = new JButton("Cadastrar");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblCadastroDoEleitor = new JLabel("Cadastro de Eleitor");
		lblCadastroDoEleitor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDoEleitor.setBounds(95, 12, 177, 21);
		contentPane.add(lblCadastroDoEleitor);

		JTextPane inputNumRegister = new JTextPane();
		inputNumRegister.setBounds(50, 86, 288, 30);
		contentPane.add(inputNumRegister);

		JLabel lblNmeroDeCadastro = new JLabel("Número de Cadastro");
		lblNmeroDeCadastro.setBounds(50, 71, 159, 15);
		contentPane.add(lblNmeroDeCadastro);

		JTextPane name = new JTextPane();
		name.setBounds(50, 143, 288, 30);
		contentPane.add(name);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 127, 159, 15);
		contentPane.add(lblNome);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 182, 159, 15);
		contentPane.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(50, 196, 288, 30);
		contentPane.add(passwordField);


		btnCadastrar.setBounds(131, 330, 117, 25);
		contentPane.add(btnCadastrar);

		JLabel lblGeolocalizao = new JLabel("Geolocalização");
		lblGeolocalizao.setBounds(50, 238, 159, 15);
		contentPane.add(lblGeolocalizao);

		JTextPane inputX = new JTextPane();
		inputX.setBounds(50, 278, 137, 30);
		contentPane.add(inputX);

		JTextPane inputY = new JTextPane();
		inputY.setBounds(199, 278, 139, 30);
		contentPane.add(inputY);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(112, 261, 38, 15);
		contentPane.add(lblX);

		JLabel lblY = new JLabel("Y");
		lblY.setBounds(262, 261, 38, 15);
		contentPane.add(lblY);

		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TechnicalInterface().setVisible(true);
			}
		});
		btnSair.setBounds(305, 0, 84, 25);
		contentPane.add(btnSair);



		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)  {
				
				int id = Integer.parseInt(inputNumRegister.getText());
				int x = Integer.parseInt(inputX.getText());
				int y = Integer.parseInt(inputY.getText());
				
				try {
					RegisterController.registerVoter(id, passwordField.getText(), name.getText(), new Point(x, y));
					JOptionPane.showMessageDialog(null, "Criado com sucesso!");

					dispose();
					new TechnicalInterface().setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
	}
}
