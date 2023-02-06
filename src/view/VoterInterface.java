package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;
import controllers.RegisterController;
import dominio.Vote;

public class VoterInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField numberPlate;

	/**
	 * Create the frame.
	 */
	public VoterInterface() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JButton btnMontarChapa = new JButton("Votar");
		btnMontarChapa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String n = numberPlate.getText();
					RegisterController.saveVote(new Vote(n, Autenticator.authenticatedVoter));
					JOptionPane.showMessageDialog(null, "Parabéns, você votou!");
					dispose();
					new SelectResource().setVisible(true);

				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

				dispose();
				new SelectResource().setVisible(true);
			}
		});
		btnMontarChapa.setBounds(175, 147, 128, 25);
		contentPane.add(btnMontarChapa);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Autenticator.authenticatedTechnician = null;
				new SelectResource().setVisible(true);
			}
		});
		btnSair.setBounds(272, 12, 62, 25);
		contentPane.add(btnSair);

		numberPlate = new JTextField();
		numberPlate.setBounds(93, 84, 163, 33);
		contentPane.add(numberPlate);
		numberPlate.setColumns(10);

		JLabel lblNumeroDaChapa = new JLabel("Numero da Chapa");
		lblNumeroDaChapa.setBounds(111, 57, 128, 15);
		contentPane.add(lblNumeroDaChapa);

		JButton btnVotarBranco = new JButton("Votar Branco");
		btnVotarBranco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					RegisterController.saveVote(new Vote(null, Autenticator.authenticatedVoter));
					JOptionPane.showMessageDialog(null, "Parabéns, você votou!");
					dispose();
					new SelectResource().setVisible(true);

				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

				dispose();
				new SelectResource().setVisible(true);
			}
		});
		btnVotarBranco.setBounds(29, 147, 134, 25);
		contentPane.add(btnVotarBranco);
	}
}
