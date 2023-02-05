package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.Autenticator;
import dominio.Technician;
import exceptions.UserNotFound;
import seeders.Seeders;

public class SelectResource extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectResource frame = new SelectResource();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectResource() {
		Seeders.insertValues();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Selecionar Recurso");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 12, 259, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnTcnico = new JButton("Técnico");
		btnTcnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TechnicianLogin().setVisible(true);
			}
		});
		btnTcnico.setBounds(209, 86, 117, 25);
		contentPane.add(btnTcnico);
		
		JButton btnMesrio = new JButton("Mesário");
		btnMesrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BoardMemberLogin().setVisible(rootPaneCheckingEnabled);
			}
		});
		btnMesrio.setBounds(209, 123, 117, 25);
		contentPane.add(btnMesrio);
		
		JButton btnEleitor = new JButton("Eleitor");
		btnEleitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VoterLogin().setVisible(true);
			}
		});
		btnEleitor.setBounds(209, 160, 117, 25);
		contentPane.add(btnEleitor);
	}
}
