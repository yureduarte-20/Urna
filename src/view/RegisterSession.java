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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.RegisterController;
import dominio.Session;

public class RegisterSession extends JFrame {

	private JPanel contentPane;
	private RegisterController registerController = new RegisterController();
	/**
	 * Create the frame.
	 */
	public RegisterSession() {
		JButton btnCadastrar = new JButton("Cadastrar");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblCadastroDoTech = new JLabel("Cadastro do Sessão");
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

		JLabel lblX = new JLabel("X");
		lblX.setBounds(112, 229, 38, 15);
		contentPane.add(lblX);

		JLabel lblGeolocalizao = new JLabel("Geolocalização");
		lblGeolocalizao.setBounds(50, 206, 159, 15);
		contentPane.add(lblGeolocalizao);

		JTextPane inputX = new JTextPane();
		inputX.setBounds(50, 246, 137, 30);
		contentPane.add(inputX);

		JTextPane inputY = new JTextPane();
		inputY.setBounds(199, 246, 139, 30);
		contentPane.add(inputY);

		JLabel lblY = new JLabel("Y");
		lblY.setBounds(262, 229, 38, 15);
		contentPane.add(lblY);

		JLabel lblNmeroDaZona = new JLabel("Número da Zona");
		lblNmeroDaZona.setBounds(50, 128, 159, 15);
		contentPane.add(lblNmeroDaZona);

		JTextPane inputNumRegisterZone = new JTextPane();
		inputNumRegisterZone.setBounds(50, 143, 288, 30);
		contentPane.add(inputNumRegisterZone);



		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)  {
				int id = Integer.parseInt(inputNumRegister.getText());
				int zoneId = Integer.parseInt(inputNumRegisterZone.getText());
				int x = Integer.parseInt(inputX.getText());
				int y = Integer.parseInt(inputY.getText());

				try {
					var session = new Session(id, new Point( x, y ));
					RegisterController.saveSession(zoneId, session);
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
