package view;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;
import controllers.DeleteController;
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

public class DeleteSession extends JFrame {

	private JPanel contentPane;
	private JTextField inputZonaId;
	private JTextField inputSessaoId;

	/**
	 * Create the frame.
	 */
	public DeleteSession() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		inputZonaId = new JTextField();
		inputZonaId.setBounds(129, 70, 190, 32);
		contentPane.add(inputZonaId);
		inputZonaId.setColumns(10);
		
		JLabel lblInsiraAsInformaes = new JLabel("Digite o número da sessão que você deseja deletar");
		lblInsiraAsInformaes.setBounds(53, 37, 373, 15);
		contentPane.add(lblInsiraAsInformaes);
		
		JLabel lblNmeroDoEleito = new JLabel("Número da Zona");
		lblNmeroDoEleito.setBounds(129, 54, 137, 15);
		contentPane.add(lblNmeroDoEleito);
		
		JButton btnCadastro = new JButton("Deletar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int zoneId = Integer.parseInt(inputZonaId.getText()) ;
					int sesseionId = Integer.parseInt(inputSessaoId.getText()) ;
					DeleteController.deleteSessionInZone(zoneId, sesseionId);
					JOptionPane.showMessageDialog(null, "Sessão deletada com sucesso");
					dispose();
					new TechnicalInterface().setVisible(true);
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
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
		
		inputSessaoId = new JTextField();
		inputSessaoId.setColumns(10);
		inputSessaoId.setBounds(129, 133, 190, 32);
		contentPane.add(inputSessaoId);
		
		JLabel lblNmeroDoSesso = new JLabel("Número do Sessão");
		lblNmeroDoSesso.setBounds(129, 117, 137, 15);
		contentPane.add(lblNmeroDoSesso);
	}
}
