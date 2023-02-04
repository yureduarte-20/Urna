package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;
import controllers.RegisterController;
import dominio.BoardMember;
import dominio.Technician;
import dominio.Voter;
import exceptions.UserNotFound;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterBoardMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public RegisterBoardMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(106, 84, 190, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInsiraAsInformaes = new JLabel("Insira as Informações do Mesário");
		lblInsiraAsInformaes.setBounds(75, 12, 250, 15);
		contentPane.add(lblInsiraAsInformaes);
		
		JLabel lblNmeroDoEleito = new JLabel("Número do Eleitor");
		lblNmeroDoEleito.setBounds(106, 68, 137, 15);
		contentPane.add(lblNmeroDoEleito);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberVoter = textField.getText();
				
				try {
					BoardMember member = RegisterController.createMember( Integer.parseInt(numberVoter), Autenticator.authenticatedTechnician);
					
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (UserNotFound e1) {
					e1.printStackTrace();
				}
								
			}
		});
		btnCadastro.setBounds(146, 162, 117, 25);
		contentPane.add(btnCadastro);
	}
}
