package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setBounds(100, 100, 512, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Cadastrar eleitor");
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
		btnCas.setBounds(161, 58, 185, 25);
		contentPane.add(btnCas);
		
		JButton btnCadastro = new JButton("Cadastro Candidato");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterCandidate().setVisible(true);
			}
		});
		btnCadastro.setBounds(161, 105, 185, 25);
		contentPane.add(btnCadastro);
	}
}
