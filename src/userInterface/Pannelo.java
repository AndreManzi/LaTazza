package userInterface;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import autenticazione.*;
import manipolazioneDati.GestioneReparti;
public  abstract class Pannelo extends JPanel {
	protected int w_frame;
	protected int h_frame;
	protected int width_comp;
	protected int height_comp;
	protected int distance;
	//bottoni
	protected static final long serialVersionUID = 1L;
	protected JTextField nomevisitatore;
	protected JTextField quantita;
	protected JComboBox<String> nomepersonale;
	protected JComboBox<String> tcialda;
	protected JButton registrazione;
	protected JButton cancella;
	protected JRadioButton contanti;
	protected JRadioButton credito;
	protected ButtonGroup group;
	protected JLabel label;
	protected String s;
	protected JButton lo;
	//Panel4: Stato Magazziono, cassa e debiti personale 
	protected JLabel statocassa;
	protected JLabel info;
	protected JLabel disponibilita;
	protected JLabel debito;
	protected JList<String> js;
	protected JList<String> jsp;
	protected JScrollPane scrollcialda;
	protected JScrollPane scrollPersona;

	
	public Pannelo(String s,int x,int y) {
		w_frame=x;
		h_frame=y;
		width_comp=160;
		height_comp=30;
		distance=20;
		
		setVisible(true);
		setSize(new Dimension( w_frame-distance, h_frame-distance)); 
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		setBorder(new TitledBorder(s));
		setOpaque(true);
		setLayout(null);
		lo=new JButton("Log out");
		addAndSize(lo);
		lo.setLocation(((((((w_frame-distance)/4-distance)/4)+distance)+(((w_frame-distance)/4-distance)/4)+distance+(w_frame-distance)/2-width_comp)/2)+180,(((h_frame-distance)/4)*3));
	}

	
	public void addAndSize(Component c) {
		c.setSize(width_comp, height_comp);
		add(c);
	}
	public void addAndSize(Component c,int i) {
		c.setSize(width_comp*i, height_comp);
		add(c);
	}
	public boolean isEmptyStringINTextField(JTextField j, String s) {//utile per check quando click on registrazione
		if(j.getText().isEmpty()) return false;//se vuoto false
		String aux=j.getText().toLowerCase();
		return!(aux.equals(s.toLowerCase()));//se uguale a s false
	}
	public int isInteger(JTextField j) {//se non integer restituisce -1
		int i=0;
		try{
			i=Integer.parseInt((j.getText()));
		}catch(NumberFormatException nfe) {return -1;};
		if(i>0) return i;
		else return -1;
	}
	
	public double isDouble(JTextField j) {//se non integer restituisce -1
		double i=0;
		String s=j.getText().replace(',', '.');
		try{
			i=Double.parseDouble(s);
		}catch(NumberFormatException nfe) {return -1;};
		return i;
	}
	public void setholder(JTextField j) {
		j.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				j.setText("");
			 }
		 });
	}
	public void enableRegistryI(JTextField j) {
	j.addKeyListener ( new KeyListener () { 
		public void keyPressed (KeyEvent ke) { 
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			try{
				Integer.parseInt(j.getText());
			}catch(NumberFormatException nfe) {j.setText("");}
			
		} 
	});
	}
	public void enableRegistryD(JTextField j) {
		j.addKeyListener ( new KeyListener () { 
			public void keyPressed (KeyEvent ke) { 
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try{
					Double.parseDouble(j.getText().replace(',', '.'));
				}catch(NumberFormatException nfe) {j.setText("");}
				
			} 
		});
		}

	public void print(JLabel l,String s,Color r) {
		l.setForeground(r);
		l.setText(s);
	}
	public void logOut(InterfacciaGrafica view) {
		lo.addActionListener(e -> {
			new Connessione();
			view.getFrame().dispose();
		});
	}
	
	public void refreshView(GestioneReparti m) {	
	}
	public void cancella(InterfacciaGrafica view) {//decidere se tornare al 1 pannello o refreshare
	}
	public void initView(GestioneReparti m) {
	}
	public void setHolder() {
	}
	public void action(GestioneReparti model, InterfacciaGrafica view) {		
	}
	public void enableRegistry() {
	}
	public void refreshView() {	
	}
}