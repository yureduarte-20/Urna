package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;
import controllers.MemberController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MemberInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Imprimir Candidatos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showMessageDialog(null, MemberController.printCandidates());
				
			}
		});
		btnNewButton.setBounds(161, 12, 185, 25);
		contentPane.add(btnNewButton);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Autenticator.authenticatedTechnician = null;
				new Main().setVisible(true);
			}
		});
		btnSair.setBounds(450, 0, 62, 25);
		contentPane.add(btnSair);
	}
}
