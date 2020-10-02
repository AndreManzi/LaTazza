
package userInterface;



import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import manipolazioneDati.GestioneReparti;
import manipolazioneDati.GestionePersonale;

public class RimozionePersonale extends Pannelo {
	private static final long serialVersionUID = 1L;
	
	public RimozionePersonale(int x,int y) {
		super("Rimuovi personale",x,y);
		s="Rimuovi";
		nomepersonale=new JComboBox<String>();
		addAndSize(nomepersonale);
		nomepersonale.setMaximumRowCount(5);
		registrazione=new JButton("Rimuovi");
		addAndSize(registrazione);
		label= new JLabel();
		addAndSize(label,4);
		
		nomepersonale.setLocation(((w_frame-distance)/4+width_comp), ((h_frame-distance)/4+height_comp));
		registrazione.setLocation(((w_frame-distance)/4+width_comp), (int)(((h_frame-distance)/4+height_comp)*2));
		label.setLocation(((w_frame-distance)/4+width_comp), (int)(((h_frame-distance)/4)*1.75));
		
	}
	@Override
	public void initView(GestioneReparti m) {
		for(int i=0;i<m.getReg().getRegistro().size();i++)
			nomepersonale.addItem(new String(m.getReg().personToString(i)));
				
	}
	@Override
	public void refreshView() {
		nomepersonale.setSelectedIndex(0);
		label.setText("");
	}
	@Override
	public void refreshView(GestioneReparti m){
		nomepersonale.removeAllItems();
		for(int i=0;i<m.getReg().getRegistro().size();i++)
			nomepersonale.addItem(new String(m.getReg().personToString(i)));
		
		
		
	}
	@Override
	public void action(GestioneReparti model,InterfacciaGrafica v) {
		
			registrazione.addActionListener(e ->{
				GestionePersonale g=new GestionePersonale(false);
				boolean b=g.registra(model,nomepersonale.getSelectedIndex());
				
				v.aggiornaPers(model);
				refreshView();
				if(b)
					print(label,g.print(),Color.GREEN);
				else
					print(label,g.print(),Color.RED);
				});
		}
}

