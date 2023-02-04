package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;
import controllers.RegisterController;
import dominio.BoardMember;
import dominio.Party;
import dominio.Technician;
import dominio.Voter;
import exceptions.PartyAlreadyExists;
import exceptions.UserNotFound;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterParty extends JFrame {

	private JPanel contentPane;
	private JTextField inputName;
	private JTextField numberParty;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public RegisterParty() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		inputName = new JTextField();
		inputName.setBounds(106, 84, 190, 32);
		contentPane.add(inputName);
		inputName.setColumns(10);
		
		JLabel lblInsiraAsInformaes = new JLabel("Montar Partido");
		lblInsiraAsInformaes.setBounds(146, 12, 133, 15);
		contentPane.add(lblInsiraAsInformaes);
		
		JLabel lblNmeroDoEleito = new JLabel("Nome do Partido");
		lblNmeroDoEleito.setBounds(106, 68, 190, 15);
		contentPane.add(lblNmeroDoEleito);
		
		numberParty = new JTextField();
		numberParty.setColumns(10);
		numberParty.setBounds(106, 144, 190, 32);
		contentPane.add(numberParty);
		
		JLabel lblNmeroDo = new JLabel("Número do Partido");
		lblNmeroDo.setBounds(106, 128, 190, 15);
		contentPane.add(lblNmeroDo);
		
		JLabel inputAcronym = new JLabel("Sigla");
		inputAcronym.setBounds(106, 188, 190, 15);
		contentPane.add(inputAcronym);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(106, 204, 190, 32);
		contentPane.add(textField);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberVoter = numberParty.getText();
			
				try {
					RegisterController.saveParty(inputName.getText(), Integer.parseInt(numberVoter), inputAcronym.getText());
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
					dispose();
					new TechnicalInterface().setVisible(true);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Insira somente números no número do partido");
				} catch (PartyAlreadyExists e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
								
			}
		});
		btnCadastro.setBounds(148, 252, 117, 25);
		contentPane.add(btnCadastro);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TechnicalInterface().setVisible(true);
			}
		});
		btnSair.setBounds(332, 0, 62, 25);
		contentPane.add(btnSair);
	}
}
