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
		setBounds(100, 100, 612, 697);
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
		btnNewButton.setBounds(164, 180, 185, 25);
		contentPane.add(btnNewButton);
		
		JButton btnCas = new JButton("Cadastro Mesário");
		btnCas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterBoardMember().setVisible(true);
			}
		});
		btnCas.setBounds(164, 250, 185, 25);
		contentPane.add(btnCas);
		
		JButton btnCadastro = new JButton("Cadastro Candidato");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterCandidate().setVisible(true);
			}
		});
		btnCadastro.setBounds(164, 287, 185, 25);
		contentPane.add(btnCadastro);
		
		JButton btnDeletarEleitor = new JButton("Deletar Eleitor");
		btnDeletarEleitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DeleteVoter().setVisible(true);
			}
		});
		btnDeletarEleitor.setBounds(164, 472, 185, 25);
		contentPane.add(btnDeletarEleitor);
		
		JButton btnMontarChapa = new JButton("Cadastrar Partido");
		btnMontarChapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterParty().setVisible(true);
			}
		});
		btnMontarChapa.setBounds(164, 324, 185, 25);
		contentPane.add(btnMontarChapa);
		
		JButton registerTech = new JButton("Cadastrar Técnico");
		registerTech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterTechnician().setVisible(true);
			}
		});
		registerTech.setBounds(164, 361, 185, 25);
		contentPane.add(registerTech);
		
		JButton btnCadastrarSesso = new JButton("Cadastrar Sessão");
		btnCadastrarSesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterSession().setVisible(true);
				dispose();
			}
		});
		btnCadastrarSesso.setBounds(164, 398, 185, 25);
		contentPane.add(btnCadastrarSesso);
		
		JButton btnCadastrarZona = new JButton("Cadastrar Zona");
		btnCadastrarZona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterZone().setVisible(true);
			}
		});
		
		btnCadastrarZona.setBounds(164, 435, 185, 25);
		contentPane.add(btnCadastrarZona);
		
		JButton btnEditarSesso = new JButton("Editar Sessão");
		btnEditarSesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EditSession().setVisible(true);
			}
		});
		btnEditarSesso.setBounds(164, 508, 185, 25);
		contentPane.add(btnEditarSesso);
		
		JButton btnExcluirSesso = new JButton("Deletar Sessão");
		btnExcluirSesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DeleteSession().setVisible(true);
			}
		});
		btnExcluirSesso.setBounds(164, 545, 185, 25);
		contentPane.add(btnExcluirSesso);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Autenticator.authenticatedTechnician = null;
				new TechnicianLogin().setVisible(true);
			}
		});
		
		JButton btnCadastroChapa = new JButton("Cadastro Chapa");
		btnCadastroChapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterElectoralPlate().setVisible(true);
			}
		});
		btnCadastroChapa.setBounds(164, 213, 185, 25);
		contentPane.add(btnCadastroChapa);
		btnSair.setBounds(467, 12, 62, 25);
		contentPane.add(btnSair);
		
		JButton btnNewButton_1 = new JButton("Editar Eleitor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditVoter().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(164, 582, 185, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnCadastrarTurno = new JButton("Cadastrar Turno");
		btnCadastrarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterShift().setVisible(true);
				dispose();
			}
		});
		btnCadastrarTurno.setBounds(164, 75, 185, 25);
		contentPane.add(btnCadastrarTurno);
		
		JButton btnCadastrarEleio = new JButton("Cadastrar Eleição");
		btnCadastrarEleio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterElection().setVisible(true);
				dispose();
			}
		});
		btnCadastrarEleio.setBounds(164, 38, 185, 25);
		contentPane.add(btnCadastrarEleio);
		
		JButton btnEncerrarTurno = new JButton("Encerrar Turno");
		btnEncerrarTurno.setBounds(164, 108, 185, 25);
		contentPane.add(btnEncerrarTurno);
		
		JButton btnEncerrarEleio = new JButton("Encerrar Eleição");
		btnEncerrarEleio.setBounds(164, 145, 185, 25);
		contentPane.add(btnEncerrarEleio);
	}
}
