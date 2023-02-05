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
import controllers.UpdateController;
import dominio.Session;

public class EditSession extends JFrame {

	private JPanel contentPane;
	private RegisterController registerController = new RegisterController();
	private Session session = null;

	/**
	 * Create the frame.
	 */
	public EditSession() {
		JButton btnCadastrar = new JButton("Salvar");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblCadastroDoTech = new JLabel("Edição de Sessão");
		lblCadastroDoTech.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDoTech.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDoTech.setBounds(96, 12, 182, 21);
		contentPane.add(lblCadastroDoTech);

		JTextPane searchSessionid = new JTextPane();
		searchSessionid.setBounds(50, 86, 159, 30);
		contentPane.add(searchSessionid);

		JLabel lblNmeroDeCadastro = new JLabel("Número de Cadastro");
		lblNmeroDeCadastro.setBounds(50, 71, 146, 15);
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
		btnSair.setBounds(518, 11, 84, 25);
		contentPane.add(btnSair);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(112, 229, 38, 15);
		contentPane.add(lblX);
		lblX.setVisible(false);

		JLabel lblGeolocalizao = new JLabel("Geolocalização");
		lblGeolocalizao.setBounds(50, 206, 159, 15);
		contentPane.add(lblGeolocalizao);
		lblGeolocalizao.setVisible(false);

		JTextPane inputX = new JTextPane();
		inputX.setBounds(50, 246, 137, 30);
		contentPane.add(inputX);
		inputX.setVisible(false);

		JTextPane inputY = new JTextPane();
		inputY.setBounds(199, 246, 139, 30);
		contentPane.add(inputY);
		inputY.setVisible(false);

		JLabel lblY = new JLabel("Y");
		lblY.setBounds(262, 229, 38, 15);
		contentPane.add(lblY);
		lblY.setVisible(false);

		JLabel lblNmeroDaZona = new JLabel("Número da Zona");
		lblNmeroDaZona.setBounds(50, 128, 159, 15);
		contentPane.add(lblNmeroDaZona);
		lblNmeroDaZona.setVisible(false);

		JTextPane inputNumNewZoneRegister = new JTextPane();
		inputNumNewZoneRegister.setBounds(50, 143, 451, 30);
		contentPane.add(inputNumNewZoneRegister);
		inputNumNewZoneRegister.setVisible(false);


		JButton btnPesquisar = new JButton("Pesquisar");

		btnPesquisar.setBounds(396, 86, 105, 25);
		contentPane.add(btnPesquisar);

		JLabel lblNmeroDaZona_1 = new JLabel("Número da Zona");
		lblNmeroDaZona_1.setBounds(221, 71, 146, 15);
		contentPane.add(lblNmeroDaZona_1);

		JTextPane searchZoneId = new JTextPane();
		searchZoneId.setBounds(221, 86, 159, 30);
		contentPane.add(searchZoneId);


		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int zoneId = Integer.parseInt( searchZoneId.getText() );
					int sessionid = Integer.parseInt( searchSessionid.getText() );
					session = UpdateController.getSessionInZone(zoneId, sessionid);


					inputNumNewZoneRegister.setVisible(true);
					lblNmeroDaZona.setVisible(true);
					inputNumNewZoneRegister.setVisible(true);
					lblY.setVisible(true);
					inputX.setVisible(true);
					inputX.setText( String.valueOf(session.getAddress().x) );
					lblX.setVisible(true);
					lblGeolocalizao.setVisible(true);
					inputY.setVisible(true);
					inputY.setText( String.valueOf(session.getAddress().y) );
				} catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)  {
				int id = Integer.parseInt(searchSessionid.getText());
				int oldZoneId = Integer.parseInt(searchZoneId.getText());
				int newZoneId = Integer.parseInt( inputNumNewZoneRegister.getText() );
				int x = Integer.parseInt(inputX.getText());
				int y = Integer.parseInt(inputY.getText());

				try {
					var session = new Session(id, new Point( x, y ));
					//RegisterController.saveSession(zoneId, session);
			        UpdateController.updateSession(newZoneId, oldZoneId, id, new Point(x,y));
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
