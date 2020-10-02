package userInterface;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import manipolazioneDati.GestioneReparti;
import manipolazioneDati.Rifornimento;

public class RifornimentoScatole extends Pannelo {
	private static final long serialVersionUID = 1L;
public RifornimentoScatole(int x,int y) {
	
		super("Registrazione rifornimento  cialde",x,y);
		s="Rifornimento";
		  
		tcialda=new JComboBox<String>();
		addAndSize(tcialda);
		tcialda.setMaximumRowCount(5);
		quantita=new JTextField();
		addAndSize(quantita);
		registrazione=new JButton("Registra Rifornimento");
		addAndSize(registrazione);
		cancella=new JButton("Cancella");
		addAndSize(cancella);
		label= new JLabel();
		addAndSize(label,4);
		
		tcialda.setLocation(((w_frame-distance)/4+width_comp), (h_frame-distance)/4);
		quantita.setLocation(((w_frame-distance)/4+width_comp), (int)(((h_frame-distance)/4)*1.5));
		registrazione.setLocation((((w_frame-distance)/4-distance)/4+distance)+180, (int)(((h_frame-distance)/4)*2.5));
		cancella.setLocation((((w_frame-distance)/4-distance)/4+distance+(w_frame-distance)/2-width_comp)+180, (int)(((h_frame-distance)/4)*2.5));
		label.setLocation(((w_frame-distance)/4+width_comp)-190, (int)(((h_frame-distance)/4)*1.75));
	}
	@Override
	public void initView(GestioneReparti m) {
		quantita.setText("Quantit\u00e0(Scatole)");
		for(int i=0;i<m.getM().sizeMag();i++)
			tcialda.addItem((m.getM().visualizzaTipoCialda(i)));
		label.setForeground(Color.GREEN);
		label.setText("");
	}
	@Override
	public void refreshView() {
		quantita.setText("Quantit\u00e0(Scatole)");
		tcialda.setSelectedIndex(0);
		label.setText("");
	}
	@Override
	public void setHolder() {
		setholder(quantita);
		
	}
	@Override
	public void cancella(InterfacciaGrafica view) {
		cancella.addActionListener(e -> {
			refreshView();
		});
	}
	@Override
	public void enableRegistry() {
		enableRegistryI(quantita);
	}
	@Override
	public void action(GestioneReparti m,InterfacciaGrafica view) {
		registrazione.addActionListener(e -> {
			Rifornimento r= new Rifornimento(m.getM().getCialde()[tcialda.getSelectedIndex()].getType(),isInteger(quantita));
			boolean b=r.registra(m,tcialda.getSelectedIndex());
			view.aggiornaCassaMagazzino(m);
			refreshView();
			if(b)
				print(label,r.print(),Color.GREEN);
			else
				print(label,r.print(),Color.RED);
		});
	}
	
}
