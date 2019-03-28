package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
//Trovare un criterio per posizionare i componenti
public abstract class MyPanel extends JPanel {
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected static Dim d=new Dim();
	protected JTextField nomevisitatore;
	protected JTextField quantita;
	protected JComboBox<String> nomepersonale;
	protected JComboBox<String> tipocialda;
	protected JButton registrazione;
	protected JButton cancella;
	protected JRadioButton contanti;
	protected JRadioButton credito;
	protected ButtonGroup group;
	protected JLabel label;
	
	//Panel4: Stato Magazziono, cassa e debiti personale 
	protected JLabel statocassa;
	protected JLabel disponibilita;
	protected JLabel debito;

	
	
	protected Dim getD() {
		return d;
	}
	
	protected JTextField getNomevisitatore() {
		return nomevisitatore;
	}
	protected void setNomevisitatore(JTextField nomevisitatore) {
		this.nomevisitatore = nomevisitatore;
	}
	protected JTextField getQuantita() {
		return quantita;
	}
	protected void setQuantita(JTextField quantita) {
		this.quantita = quantita;
	}
	protected JButton getRegistrazione() {
		return registrazione;
	}
	protected void setRegistrazione(JButton registrazione) {
		this.registrazione = registrazione;
	}
	protected JButton getCancella() {
		return cancella;
	}
	protected void setCancella(JButton cancella) {
		this.cancella = cancella;
	}
	protected JRadioButton getContanti() {
		return contanti;
	}
	protected void setContanti(JRadioButton contanti) {
		this.contanti = contanti;
	}
	protected JRadioButton getCredito() {
		return credito;
	}
	protected void setCredito(JRadioButton credito) {
		this.credito = credito;
	}
	protected JComboBox<String> getNomepersonale(){
		return nomepersonale;
	}
	protected void setNomepersonale(JComboBox<String> p) {
		this.nomepersonale=p;
	}
	protected JComboBox<String> getTipocialda(){
		return tipocialda;
	}
	protected void setTipocialda(JComboBox<String> p) {
		this.tipocialda=p;
	}
	protected MyPanel(String s) {
		setVisible(true);
		setSize(new Dimension( d.getW_panel(), d.getH_panel())); 
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		setBorder(new TitledBorder(s));
		setOpaque(true);
		setLayout(null);

	}
	protected void addItems(ArrayList <Personale> s, JComboBox<String> cb)
	{
		cb.removeAllItems();
		for(int i=0;i<s.size();i++)
			cb.addItem(s.get(i).getName());
	}
	protected void addItems(Cialda s[], JComboBox<String> cb)
	{
		cb.removeAllItems();
		for(int i=0;i<s.length;i++)
			cb.addItem(s[i].getType().toString());
	}
	
	protected void addAndSize(Component c) {
		c.setSize(d.getWidth_comp(), d.getHeight_comp());
		add(c);
	};
	protected boolean isEmptyStringINTextField(JTextField j, String s) {//utile per check quando click on registrazione
		if(j.getText().isEmpty()) return false;
		String aux=j.getText().toLowerCase();
		return!(aux.equals(s.toLowerCase()));
	}
	protected int isInteger(JTextField j) {//se non integer restituisce -1
		int i=0;
		try{
			i=Integer.parseInt((j.getText()));
		}catch(NumberFormatException nfe) {return -1;};
		return i;
	}
	protected void setholder(JTextField j) {//o come si chama
		j.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				j.setText("");
			 }
		 });
	}
}