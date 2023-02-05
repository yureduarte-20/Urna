package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TechnicalInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public TechnicalInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Cadastrar Eleitor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterVoter().setVisible(true);
			}
		});
		btnNewButton.setBounds(161, 12, 185, 25);
		contentPane.add(btnNewButton);
		
		JButton btnCas = new JButton("Cadastro Mesário");
		btnCas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterBoardMember().setVisible(true);
			}
		});
		btnCas.setBounds(161, 82, 185, 25);
		contentPane.add(btnCas);
		
		JButton btnCadastro = new JButton("Cadastro Candidato");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterCandidate().setVisible(true);
			}
		});
		btnCadastro.setBounds(161, 119, 185, 25);
		contentPane.add(btnCadastro);
		
		JButton btnDeletarEleitor = new JButton("Deletar Eleitor");
		btnDeletarEleitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DeleteVoter().setVisible(true);
			}
		});
		btnDeletarEleitor.setBounds(161, 304, 185, 25);
		contentPane.add(btnDeletarEleitor);
		
		JButton btnMontarChapa = new JButton("Cadastrar Partido");
		btnMontarChapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterParty().setVisible(true);
			}
		});
		btnMontarChapa.setBounds(161, 156, 185, 25);
		contentPane.add(btnMontarChapa);
		
		JButton registerTech = new JButton("Cadastrar Técnico");
		registerTech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterTechnician().setVisible(true);
			}
		});
		registerTech.setBounds(161, 193, 185, 25);
		contentPane.add(registerTech);
		
		JButton btnCadastrarSesso = new JButton("Cadastrar Sessão");
		btnCadastrarSesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterSession().setVisible(true);
				dispose();
			}
		});
		btnCadastrarSesso.setBounds(161, 230, 185, 25);
		contentPane.add(btnCadastrarSesso);
		
		JButton btnCadastrarZona = new JButton("Cadastrar Zona");
		btnCadastrarZona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterZone().setVisible(true);
			}
		});
		
		btnCadastrarZona.setBounds(161, 267, 185, 25);
		contentPane.add(btnCadastrarZona);
		
		JButton btnEditarSesso = new JButton("Editar Sessão");
		btnEditarSesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EditSession().setVisible(true);
			}
		});
		btnEditarSesso.setBounds(161, 340, 185, 25);
		contentPane.add(btnEditarSesso);
		
		JButton btnExcluirSesso = new JButton("Deletar Sessão");
		btnExcluirSesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DeleteSession().setVisible(true);
			}
		});
		btnExcluirSesso.setBounds(161, 377, 185, 25);
		contentPane.add(btnExcluirSesso);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Autenticator.authenticatedTechnician = null;
				new Main().setVisible(true);
			}
		});
		
		JButton btnCadastroChapa = new JButton("Cadastro Chapa");
		btnCadastroChapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterElectoralPlate().setVisible(true);
			}
		});
		btnCadastroChapa.setBounds(161, 45, 185, 25);
		contentPane.add(btnCadastroChapa);
		btnSair.setBounds(467, 12, 62, 25);
		contentPane.add(btnSair);
	}
}
