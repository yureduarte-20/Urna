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

import controllers.RegisterController;

public class RegisterElection extends JFrame {

	private JPanel contentPane;
	private JTextField candidateNumber;

	/**
	 * Create the frame.
	 */
	public RegisterElection() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);

		setContentPane(contentPane);

		candidateNumber = new JTextField();
		candidateNumber.setBounds(101, 107, 190, 32);
		contentPane.add(candidateNumber);
		candidateNumber.setColumns(10);

		JLabel lblInsiraAsInformaes = new JLabel("Insira as Informações da Eleição");
		lblInsiraAsInformaes.setBounds(67, 48, 294, 15);
		contentPane.add(lblInsiraAsInformaes);

		JLabel lblNmeroDoEleito = new JLabel("Identificação da Eleição");
		lblNmeroDoEleito.setBounds(101, 91, 190, 15);
		contentPane.add(lblNmeroDoEleito);

		JButton btnCadastro = new JButton("Cadastro");

		btnCadastro.setBounds(133, 176, 117, 25);
		contentPane.add(btnCadastro);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TechnicalInterface().setVisible(true);
			}
		});
		btnVoltar.setBounds(305, 0, 77, 25);
		contentPane.add(btnVoltar);
		btnCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String numberCandidate = candidateNumber.getText();

				try {
				    RegisterController.saveElection(numberCandidate);
					JOptionPane.showMessageDialog(null, "Eleição cadastrada com sucesso!");
					dispose();
					new TechnicalInterface().setVisible(true);

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Digite somente números no campo número do eleitor");
				} catch( Exception ex ) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}


			}
		});
	}
}
