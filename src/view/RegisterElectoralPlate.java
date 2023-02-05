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

public class RegisterElectoralPlate extends JFrame {

	private JPanel contentPane;
	private JTextField candidateNumber;
	private JTextField viceNumber;
	private JTextField plateNumber;

	/**
	 * Create the frame.
	 */
	public RegisterElectoralPlate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		candidateNumber = new JTextField();
		candidateNumber.setBounds(101, 107, 190, 32);
		contentPane.add(candidateNumber);
		candidateNumber.setColumns(10);
		
		JLabel lblInsiraAsInformaes = new JLabel("Insira as Informações do Candidato");
		lblInsiraAsInformaes.setBounds(67, 48, 294, 15);
		contentPane.add(lblInsiraAsInformaes);
		
		JLabel lblNmeroDoEleito = new JLabel("Número do Candidato");
		lblNmeroDoEleito.setBounds(101, 91, 163, 15);
		contentPane.add(lblNmeroDoEleito);
		
		JButton btnCadastro = new JButton("Cadastro");
	
		btnCadastro.setBounds(147, 291, 117, 25);
		contentPane.add(btnCadastro);
		
		JLabel lblNomeFictcio = new JLabel("Numero do Vice");
		lblNomeFictcio.setBounds(101, 152, 137, 15);
		contentPane.add(lblNomeFictcio);
		
		viceNumber = new JTextField();
		viceNumber.setColumns(10);
		viceNumber.setBounds(101, 168, 190, 32);
		contentPane.add(viceNumber);
		
		plateNumber = new JTextField();
		plateNumber.setColumns(10);
		plateNumber.setBounds(101, 228, 190, 32);
		contentPane.add(plateNumber);
		
		JLabel lblNmeroDoPartido = new JLabel("Número da chapa");
		lblNmeroDoPartido.setBounds(101, 212, 137, 15);
		contentPane.add(lblNmeroDoPartido);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TechnicalInterface().setVisible(true);
			}
		});
		btnVoltar.setBounds(305, 0, 77, 25);
		contentPane.add(btnVoltar);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberCandidate = candidateNumber.getText();
				String _plateNumber = plateNumber.getText();
				String numberVice = viceNumber.getText();
				
				try {
				    RegisterController.saveEletroralPlate( Integer.parseInt(candidateNumber.getText()), Integer.parseInt(numberVice), _plateNumber );
					JOptionPane.showMessageDialog(null, "Chapa cadastrada com sucesso!");
					dispose();
					new TechnicalInterface().setVisible(true);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Digite somente números no campo número do eleitor");
				} catch (UserNotFound e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch( Exception ex ) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				
			}
		});
	}
}
