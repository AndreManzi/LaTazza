package userInterface;


import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import manipolazioneDati.GestioneReparti;
import manipolazioneDati.Vendita;

public class VenditaCialde extends Pannelo {
	private static final long serialVersionUID = 1L;
	
	public VenditaCialde(int x,int y)
	{
		super("Registrazione vendite cialde",x,y);
		s="Vendita"; 
		nomevisitatore=new JTextField();
		addAndSize(nomevisitatore);
		
		nomepersonale=new JComboBox<String>();
		addAndSize(nomepersonale);
		nomepersonale.setMaximumRowCount(5);
		
		
		tcialda=new JComboBox<String>();
		addAndSize(tcialda);
		tcialda.setMaximumRowCount(5);
		
		quantita=new JTextField();
		addAndSize(quantita);  
		
		contanti=new JRadioButton("Contanti");
		addAndSize(contanti); 
		
		credito=new JRadioButton("A credito");
		addAndSize(credito);	
		
		registrazione=new JButton("Registra Vendita");
		addAndSize(registrazione);
		
		
		
		cancella=new JButton("Cancella");
		addAndSize(cancella);
		
		label=new JLabel();
		addAndSize(label,4);
		 
		nomevisitatore.setLocation((((w_frame-distance)/4-distance)/4+distance)+180, (h_frame-distance)/4);
		nomepersonale.setLocation((((w_frame-distance)/4-distance)/4+distance+(w_frame-distance)/2-width_comp)+180, (h_frame-distance)/4);
		quantita.setLocation((((w_frame-distance)/4-distance)/4+distance+(w_frame-distance)/2-width_comp)+180, (int)(((h_frame-distance)/4)*1.5));
		tcialda.setLocation((((w_frame-distance)/4-distance)/4+distance)+180, (int)(((h_frame-distance)/4)*1.5));
		contanti.setLocation((((w_frame-distance)/4-distance)/4+distance)+180, ((h_frame-distance)/4)*2);
		credito.setLocation((((w_frame-distance)/4-distance)/4+distance+(w_frame-distance)/2-width_comp)+180, ((h_frame-distance)/4)*2);
		registrazione.setLocation((((w_frame-distance)/4-distance)/4+distance)+180, (int)(((h_frame-distance)/4)*2.5));
		cancella.setLocation((((w_frame-distance)/4-distance)/4+distance+(w_frame-distance)/2-width_comp)+180, (int)(((h_frame-distance)/4)*2.5));
		label.setLocation(((w_frame-distance)/4), (int)(((h_frame-distance)/4)*1.75));
		
		group= new ButtonGroup();
		group.add(contanti);
		group.add(credito);
		 
		 
	}
	@Override
	public void initView(GestioneReparti m) {
		nomevisitatore.setText("Nome Visitatore");
		quantita.setText("Quantit\u00e0(Cialde)");
		for(int i=0;i<m.getReg().getRegistro().size();i++)
			nomepersonale.addItem(new String(m.getReg().personToString(i)));
		for(int i=0;i<m.getM().sizeMag();i++)
			tcialda.addItem((m.getM().visualizzaTipoCialda(i)));
		contanti.setSelected(true);
		
		
	}
	@Override
	public void refreshView(){
		nomevisitatore.setText("Nome Visitatore");
		quantita.setText("Quantit\u00e0(Cialde)");
		nomepersonale.setSelectedIndex(0);
		tcialda.setSelectedIndex(0);
		label.setText("");
		contanti.setSelected(true);
		
	}
	@Override
	public void refreshView(GestioneReparti m){
		contanti.setSelected(true);
		nomepersonale.removeAllItems();
		tcialda.removeAllItems();
		for(int i=0;i<m.getReg().getRegistro().size();i++)
			nomepersonale.addItem(new String(m.getReg().personToString(i)));
		for(int i=0;i<m.getM().sizeMag();i++)
			tcialda.addItem((m.getM().visualizzaTipoCialda(i)));
		
	}
	

	public String checkComponent() {
		if(isInteger(quantita)<0)
			return null;//fail
		if((!isEmptyStringINTextField(nomevisitatore, "Nome Visitatore"))^(nomepersonale.getSelectedIndex())!=0) 
			return null;
		if(isEmptyStringINTextField(nomevisitatore, "Nome Visitatore") &&  contanti.isSelected()) 
			return nomevisitatore.getText();
		if((nomepersonale.getSelectedIndex()!=0)&& contanti.isSelected())
			return nomepersonale.getSelectedItem().toString();
		if((nomepersonale.getSelectedIndex()!=0)&& credito.isSelected())
			return nomepersonale.getSelectedItem().toString();
		return null;
	}
	@Override
	public void setHolder() {
		setholder(nomevisitatore);
		setholder(quantita);
		
	}
	@Override
	public void enableRegistry() {
		enableRegistryI(quantita);
	}
	@Override
	public void cancella(InterfacciaGrafica view) {
		cancella.addActionListener(e -> {
			
			refreshView();
		});
	}
	@Override
	public void action(GestioneReparti m,InterfacciaGrafica view) {
		registrazione.addActionListener(e -> {
			Vendita v=new Vendita(checkComponent(),m.getM().getCialde()[tcialda.getSelectedIndex()].getType(),isInteger(quantita),contanti.isSelected());
			boolean b=v.registra(m, nomepersonale.getSelectedIndex());
			view.aggiornaCassaMagazzino(m);
			refreshView();
			if(b)
				print(label,v.print(),Color.GREEN);
			else
				print(label,v.print(),Color.RED);
		});
	}
}
