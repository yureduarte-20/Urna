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
import exceptions.NotEligible;
import exceptions.PartyNotFound;
import exceptions.UserNotFound;

public class RegisterCandidate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField fictName;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public RegisterCandidate() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);

		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(101, 107, 190, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblInsiraAsInformaes = new JLabel("Insira as Informações do Candidato");
		lblInsiraAsInformaes.setBounds(67, 48, 294, 15);
		contentPane.add(lblInsiraAsInformaes);

		JLabel lblNmeroDoEleito = new JLabel("Número do Eleitor");
		lblNmeroDoEleito.setBounds(101, 91, 137, 15);
		contentPane.add(lblNmeroDoEleito);

		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String numberVoter = textField.getText();
				String numberParty = textField_1.getText();

				try {
				    RegisterController.saveCandidate(
					  	  Integer.parseInt(numberVoter),
						  Autenticator.authenticatedTechnician,
						  fictName.getText(),
						  Integer.parseInt(numberParty)
				    );

					JOptionPane.showMessageDialog(null, "Candidato cadastrado com sucesso!");

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Digite somente números no campo número do eleitor");
				} catch (UserNotFound e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (NotEligible e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (PartyNotFound e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
		btnCadastro.setBounds(147, 291, 117, 25);
		contentPane.add(btnCadastro);

		JLabel lblNomeFictcio = new JLabel("Nome Fictício");
		lblNomeFictcio.setBounds(101, 152, 137, 15);
		contentPane.add(lblNomeFictcio);

		fictName = new JTextField();
		fictName.setColumns(10);
		fictName.setBounds(101, 168, 190, 32);
		contentPane.add(fictName);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 228, 190, 32);
		contentPane.add(textField_1);

		JLabel lblNmeroDoPartido = new JLabel("Número do Partido");
		lblNmeroDoPartido.setBounds(101, 212, 137, 15);
		contentPane.add(lblNmeroDoPartido);

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
	}
}
