package userInterface;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import manipolazioneDati.GestioneReparti;
import manipolazioneDati.Pagamento;

public class PagamentoDebiti extends Pannelo {
	private static final long serialVersionUID = 1L;

	public PagamentoDebiti(int x,int y)
	{

		super("Registrazione pagamento  cialde",x,y);
		s="Pagamento debiti";
		quantita=new JTextField();
		addAndSize(quantita);
		nomepersonale=new JComboBox<String>();
		addAndSize(nomepersonale);
		nomepersonale.setMaximumRowCount(5);
		registrazione=new JButton("Registra Pagamento");
		addAndSize(registrazione);
		cancella=new JButton("Cancella");
		addAndSize(cancella);;
		label= new JLabel();
		addAndSize(label,4);
		
		nomepersonale.setLocation(((w_frame-distance)/4+width_comp),(h_frame-distance)/4);
		quantita.setLocation(((w_frame-distance)/4+width_comp), (int)((h_frame-distance)/4*1.5));
		registrazione.setLocation(((w_frame-distance)/4-distance)/4+distance+180, (int)(((h_frame-distance)/4)*2.5));
		cancella.setLocation((((w_frame-distance)/4-distance)/4+distance+(w_frame-distance)/2-width_comp)+180, (int)(((h_frame-distance)/4)*2.5));
		label.setLocation(((w_frame-distance)/4+width_comp)-170, (int)(((h_frame-distance)/4)*1.75));
		
	}
	@Override
	public void initView(GestioneReparti m) {
		 quantita.setText("Ammontare");
		 for(int i=0;i<m.getReg().getRegistro().size();i++)
				nomepersonale.addItem(new String(m.getReg().personToString(i)));
	}
	@Override
	public void refreshView() {
		 quantita.setText("Ammontare");
		 nomepersonale.setSelectedIndex(0);
		 label.setText("");
	}
	@Override
	public void refreshView(GestioneReparti m) {
	nomepersonale.removeAllItems();
	for(int i=0;i<m.getReg().getRegistro().size();i++)
		nomepersonale.addItem(new String(m.getReg().personToString(i)));
	}
	@Override
	public void cancella(InterfacciaGrafica view) {
		cancella.addActionListener(e -> {
			refreshView();
			
		});
	}
	public void refreshView(String s,boolean b) {
		if(b==true)
			nomepersonale.addItem(s);
		else
			nomepersonale.removeItem(s);
		refreshView();
	}
	@Override
	public void setHolder() {
		setholder(quantita);
		
	}
	@Override
	public void action(GestioneReparti m, InterfacciaGrafica view) {
		registrazione.addActionListener(e -> {
			Pagamento p=new Pagamento((String)nomepersonale.getSelectedItem(),isDouble(quantita));
			boolean b=p.registra(m, nomepersonale.getSelectedIndex());
			view.aggiornaCassaMagazzino(m);
			if(b)
				print(label,p.print(),Color.GREEN);
			else
				print(label,p.print(),Color.RED);
		});
	}
	@Override
	public void enableRegistry() {
		enableRegistryD(quantita);
	}
	
}