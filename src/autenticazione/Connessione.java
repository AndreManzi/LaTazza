package autenticazione;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import manipolazioneDati.GestioneReparti;
import manipolazioneDati.LogSign;
import userInterface.InterfacciaGrafica;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Connessione extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		new Connessione();
	}
	/**
	 * Create the frame.
	 * @param string 
	 */
	public Connessione() {
		super("Login for LaTazza");
		GestioneReparti m = new GestioneReparti();//file
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		passwordField = new JPasswordField();
		
		textField = new JTextField();
		textField.setColumns(10);
		JLabel label = new JLabel("");
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(e -> {{
				
				LogSign l=new LogSign(textField.getText(),passwordField.getPassword());
				boolean b=l.registra(m, 1);
				if(b){
					InterfacciaGrafica v = new InterfacciaGrafica("LaTazza");
					Controller c = new Controller(m, v);
					c.initController();
					dispose();
				}
				else
				{
					label.setText("Username o password errata");
					label.setForeground(Color.RED);
				}
		}
		});
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(e -> {{
			
			LogSign l=new LogSign(textField.getText(),passwordField.getPassword());
			boolean b=l.registra(m, 2);
			if(b){
				label.setText("Registrazione riuscita");
				label.setForeground(Color.GREEN);
			}
			else {
				label.setText("Registrazione non riuscita");
				label.setForeground(Color.RED);
				}
			
			
		}});
		
		JLabel lblPassword = new JLabel("Password");
		
		JLabel lblUsername = new JLabel("Username");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLogIn)
									.addGap(77)
									.addComponent(btnRegistrati))
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(168)
							.addComponent(label)))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogIn)
						.addComponent(btnRegistrati))
					.addGap(34))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
