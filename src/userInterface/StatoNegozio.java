package userInterface;


import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import manipolazioneDati.GestioneReparti;

public class StatoNegozio extends Pannelo {
	private String q;
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> l;
	
	public StatoNegozio(int x,int y) {
		super("Stato Magazziono, cassa e debiti personale",x,y);
		s="Stato";
		
		//cassa
		statocassa=new JLabel();
		addAndSize(statocassa);
		//magazzino		
		statocassa.setLocation(((w_frame-distance)/4+width_comp), ((h_frame-distance)/4+height_comp));
		info=new JLabel();
		addAndSize(info);
		info.setLocation((int) (((w_frame-distance)/4+width_comp)*0.5), ((h_frame-distance)/4)+140);
	
		scrollcialda=new JScrollPane(); 
		scrollPersona=new JScrollPane();
		l= new DefaultListModel<>();
		js=new JList<>(l); 
		
		scrollcialda.setBounds((int) (((w_frame-distance)/4+width_comp)*0.5), (int) ((h_frame-distance)/4), 130, 120);
		scrollcialda.setViewportView(js);
		add(scrollcialda);
		jsp=new JList<>(l);
		scrollPersona.setBounds((int) (((w_frame-distance)/4+width_comp)*0.5), (int) (((h_frame-distance)/4)*2), 130, 150);
		scrollPersona.setViewportView(jsp);
		add(scrollPersona);

	}
	@Override
	public void initView(GestioneReparti m) {
		q=m.cassaToString();
		statocassa.setText("Cassa: "+q);
		info.setText("Debiti impiegati:");
		js.setModel(m.stateTot());
		jsp.setModel(m.debitP());
	}
	@Override
	public void refreshView(GestioneReparti m){
		q=m.cassaToString();
		js.setModel(m.stateTot());
		jsp.setModel(m.debitP());
	}
	@Override
	public void refreshView(){
		statocassa.setText("Cassa: "+q);
		
	}
	
	
	
}
