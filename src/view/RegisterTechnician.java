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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.RegisterController;
import dominio.Technician;

public class RegisterTechnician extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private RegisterController registerController = new RegisterController();
	/**
	 * Create the frame.
	 */
	public RegisterTechnician() {
		JButton btnCadastrar = new JButton("Cadastrar");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblCadastroDoTech = new JLabel("Cadastro do Técnico");
		lblCadastroDoTech.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDoTech.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDoTech.setBounds(96, 12, 182, 21);
		contentPane.add(lblCadastroDoTech);

		JTextPane inputNumRegister = new JTextPane();
		inputNumRegister.setBounds(50, 86, 288, 30);
		contentPane.add(inputNumRegister);

		JLabel lblNmeroDeCadastro = new JLabel("Número de Cadastro");
		lblNmeroDeCadastro.setBounds(50, 71, 159, 15);
		contentPane.add(lblNmeroDeCadastro);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 128, 159, 15);
		contentPane.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(50, 155, 288, 30);
		contentPane.add(passwordField);


		btnCadastrar.setBounds(131, 330, 117, 25);
		contentPane.add(btnCadastrar);

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
				String password = passwordField.getText();

				try {

					RegisterController.saveTechnician(new Technician(id, password));
					System.out.println(Technician.technical.size());
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
