package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;
import controllers.RegisterController;
import dominio.BoardMember;
import dominio.Candidate;
import dominio.Party;
import dominio.Technician;
import dominio.Voter;
import exceptions.NotEligible;
import exceptions.PartyNotFound;
import exceptions.UserNotFound;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterCandidate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField fictName;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public RegisterCandidate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(106, 84, 190, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInsiraAsInformaes = new JLabel("Insira as Informações do Candidato");
		lblInsiraAsInformaes.setBounds(80, 12, 294, 15);
		contentPane.add(lblInsiraAsInformaes);
		
		JLabel lblNmeroDoEleito = new JLabel("Número do Eleitor");
		lblNmeroDoEleito.setBounds(106, 68, 137, 15);
		contentPane.add(lblNmeroDoEleito);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberVoter = textField.getText();
				String numberParty = textField_1.getText();
				

				try {
					Candidate candidate = RegisterController.saveCandidate(
												Integer.parseInt(numberVoter),
												Autenticator.authenticatedTechnician,
												fictName.getText(),
												Integer.parseInt(numberParty)
										  );
					System.out.println(candidate);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Digite somente números no campo número do eleitor");
				} catch (UserNotFound e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (NotEligible e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (PartyNotFound e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
								
			}
		});
		btnCadastro.setBounds(152, 268, 117, 25);
		contentPane.add(btnCadastro);
		
		JLabel lblNomeFictcio = new JLabel("Nome Fictício");
		lblNomeFictcio.setBounds(106, 129, 137, 15);
		contentPane.add(lblNomeFictcio);
		
		fictName = new JTextField();
		fictName.setColumns(10);
		fictName.setBounds(106, 145, 190, 32);
		contentPane.add(fictName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(106, 205, 190, 32);
		contentPane.add(textField_1);
		
		JLabel lblNmeroDoPartido = new JLabel("Número do Partido");
		lblNmeroDoPartido.setBounds(106, 189, 137, 15);
		contentPane.add(lblNmeroDoPartido);
	}
}
