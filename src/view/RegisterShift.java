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
import dominio.Shift;
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

public class RegisterShift extends JFrame {

	private JPanel contentPane;
	private JTextField candidateNumber;
	private JTextField shift;

	/**
	 * Create the frame.
	 */
	public RegisterShift() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		candidateNumber = new JTextField();
		candidateNumber.setBounds(67, 106, 190, 32);
		contentPane.add(candidateNumber);
		candidateNumber.setColumns(10);
		
		JLabel lblInsiraAsInformaes = new JLabel("Insira as Informações da Turno");
		lblInsiraAsInformaes.setBounds(67, 48, 294, 15);
		contentPane.add(lblInsiraAsInformaes);
		
		JLabel lblNmeroDoEleito = new JLabel("Identificação da Eleição");
		lblNmeroDoEleito.setBounds(67, 90, 190, 15);
		contentPane.add(lblNmeroDoEleito);
		
		JButton btnCadastro = new JButton("Cadastro");
	
		btnCadastro.setBounds(170, 165, 180, 25);
		contentPane.add(btnCadastro);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TechnicalInterface().setVisible(true);
			}
		});
		btnVoltar.setBounds(399, 12, 77, 25);
		contentPane.add(btnVoltar);
		
		shift = new JTextField();
		shift.setColumns(10);
		shift.setBounds(269, 106, 190, 32);
		contentPane.add(shift);
		
		JLabel lblIdentificaoDaTurno = new JLabel("Identificação da Turno");
		lblIdentificaoDaTurno.setBounds(286, 90, 190, 15);
		contentPane.add(lblIdentificaoDaTurno);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberCandidate = candidateNumber.getText();
				String shiftId = shift.getText();
				try {
				    RegisterController.saveShift(numberCandidate, new Shift(shiftId));
					JOptionPane.showMessageDialog(null, "Turno cadastrado com sucesso!");
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
