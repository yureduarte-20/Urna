package view;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;
import controllers.RegisterController;
import controllers.VoterController;
import dominio.BoardMember;
import dominio.Technician;
import dominio.Voter;
import exceptions.UserNotFound;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteVoter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public DeleteVoter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(131, 99, 190, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInsiraAsInformaes = new JLabel("Digite o número do eleitor que queira deletar");
		lblInsiraAsInformaes.setBounds(65, 27, 342, 15);
		contentPane.add(lblInsiraAsInformaes);
		
		JLabel lblNmeroDoEleito = new JLabel("Número do Eleitor");
		lblNmeroDoEleito.setBounds(131, 83, 137, 15);
		contentPane.add(lblNmeroDoEleito);
		
		JButton btnCadastro = new JButton("Deletar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberVoter = textField.getText();
				try {
					Voter voter = VoterController.getById( Integer.parseInt(numberVoter) );
					Voter.voters.remove(voter);
					
					JOptionPane.showMessageDialog(null, "Eleitor deletado com sucesso!");
				} catch(UserNotFound e1) {
					JOptionPane.showMessageDialog(null, "O eleitor não foi encontrado. Confirme o número do eleitor.");
				}
				
			}
		});
		btnCadastro.setBounds(171, 177, 117, 25);
		contentPane.add(btnCadastro);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TechnicalInterface().setVisible(true);
			}
		});
		btnVoltar.setBounds(380, 0, 77, 25);
		contentPane.add(btnVoltar);
	}
}
