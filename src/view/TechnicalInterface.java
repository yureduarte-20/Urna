package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;

public class TechnicalInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TechnicalInterface() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Cadastrar Eleitor");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterVoter().setVisible(true);
			}
		});
		btnNewButton.setBounds(39, 132, 185, 25);
		contentPane.add(btnNewButton);

		JButton btnCas = new JButton("Cadastro Mesário");
		btnCas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterBoardMember().setVisible(true);
			}
		});
		btnCas.setBounds(39, 206, 185, 25);
		contentPane.add(btnCas);

		JButton btnCadastro = new JButton("Cadastro Candidato");
		btnCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterCandidate().setVisible(true);
			}
		});
		btnCadastro.setBounds(39, 243, 185, 25);
		contentPane.add(btnCadastro);

		JButton btnDeletarEleitor = new JButton("Deletar Eleitor");
		btnDeletarEleitor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DeleteVoter().setVisible(true);
			}
		});
		btnDeletarEleitor.setBounds(267, 132, 185, 25);
		contentPane.add(btnDeletarEleitor);

		JButton btnMontarChapa = new JButton("Cadastrar Partido");
		btnMontarChapa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterParty().setVisible(true);
			}
		});
		btnMontarChapa.setBounds(39, 280, 185, 25);
		contentPane.add(btnMontarChapa);

		JButton registerTech = new JButton("Cadastrar Técnico");
		registerTech.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterTechnician().setVisible(true);
			}
		});
		registerTech.setBounds(39, 317, 185, 25);
		contentPane.add(registerTech);

		JButton btnCadastrarSesso = new JButton("Cadastrar Sessão");
		btnCadastrarSesso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterSession().setVisible(true);
				dispose();
			}
		});
		btnCadastrarSesso.setBounds(39, 354, 185, 25);
		contentPane.add(btnCadastrarSesso);

		JButton btnCadastrarZona = new JButton("Cadastrar Zona");
		btnCadastrarZona.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterZone().setVisible(true);
			}
		});

		btnCadastrarZona.setBounds(39, 391, 185, 25);
		contentPane.add(btnCadastrarZona);

		JButton btnEditarSesso = new JButton("Editar Sessão");
		btnEditarSesso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EditSession().setVisible(true);
			}
		});
		btnEditarSesso.setBounds(267, 243, 185, 25);
		contentPane.add(btnEditarSesso);

		JButton btnExcluirSesso = new JButton("Deletar Sessão");
		btnExcluirSesso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DeleteSession().setVisible(true);
			}
		});
		btnExcluirSesso.setBounds(267, 169, 185, 25);
		contentPane.add(btnExcluirSesso);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Autenticator.authenticatedTechnician = null;
				new TechnicianLogin().setVisible(true);
			}
		});

		JButton btnCadastroChapa = new JButton("Cadastro Chapa");
		btnCadastroChapa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterElectoralPlate().setVisible(true);
			}
		});
		btnCadastroChapa.setBounds(39, 169, 185, 25);
		contentPane.add(btnCadastroChapa);
		btnSair.setBounds(462, 0, 62, 25);
		contentPane.add(btnSair);

		JButton btnNewButton_1 = new JButton("Editar Eleitor");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditVoter().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(267, 280, 185, 25);
		contentPane.add(btnNewButton_1);

		JButton btnCadastrarTurno = new JButton("Cadastrar Turno");
		btnCadastrarTurno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterShift().setVisible(true);
				dispose();
			}
		});
		btnCadastrarTurno.setBounds(39, 95, 185, 25);
		contentPane.add(btnCadastrarTurno);

		JButton btnCadastrarEleio = new JButton("Cadastrar Eleição");
		btnCadastrarEleio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterElection().setVisible(true);
				dispose();
			}
		});
		btnCadastrarEleio.setBounds(39, 58, 185, 25);
		contentPane.add(btnCadastrarEleio);

		JButton btnEncerrarTurno = new JButton("Encerrar Turno");
		btnEncerrarTurno.setBounds(267, 58, 185, 25);
		contentPane.add(btnEncerrarTurno);

		JButton btnEncerrarEleio = new JButton("Encerrar Eleição");
		btnEncerrarEleio.setBounds(267, 95, 185, 25);
		contentPane.add(btnEncerrarEleio);
	}
}
