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

public class RegisterParty extends JFrame {

	private JPanel contentPane;
	private JTextField firstCandidate;
	private JTextField secondCandidate;

	/**
	 * Create the frame.
	 */
	public RegisterParty() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		firstCandidate = new JTextField();
		firstCandidate.setBounds(106, 84, 190, 32);
		contentPane.add(firstCandidate);
		firstCandidate.setColumns(10);
		
		JLabel lblInsiraAsInformaes = new JLabel("Montar Partido");
		lblInsiraAsInformaes.setBounds(146, 12, 133, 15);
		contentPane.add(lblInsiraAsInformaes);
		
		JLabel lblNmeroDoEleito = new JLabel("Número do Candidato");
		lblNmeroDoEleito.setBounds(106, 68, 190, 15);
		contentPane.add(lblNmeroDoEleito);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberVoter = firstCandidate.getText();
			
				try {
					BoardMember member = RegisterController.createMember( Integer.parseInt(numberVoter), Autenticator.authenticatedTechnician);
					
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (UserNotFound e1) {
					e1.printStackTrace();
				}
								
			}
		});
		btnCadastro.setBounds(146, 211, 117, 25);
		contentPane.add(btnCadastro);
		
		secondCandidate = new JTextField();
		secondCandidate.setColumns(10);
		secondCandidate.setBounds(106, 144, 190, 32);
		contentPane.add(secondCandidate);
		
		JLabel lblNmeroDo = new JLabel("Número do Partido");
		lblNmeroDo.setBounds(106, 128, 190, 15);
		contentPane.add(lblNmeroDo);
	}
}
