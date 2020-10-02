package userInterface;



import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import manipolazioneDati.GestioneReparti;
import manipolazioneDati.GestionePersonale;

public class AggiuntaPersonale extends Pannelo {

	private static final long serialVersionUID = 1L;
	
	public AggiuntaPersonale(int x,int y) {
		super("Aggiungi Personale",x,y);
		s="Aggiungi";
		nomevisitatore=new JTextField();
		addAndSize(nomevisitatore);
		registrazione=new JButton("Aggiungi");
		addAndSize(registrazione);
		label= new JLabel();
		addAndSize(label,4);
		
		nomevisitatore.setLocation(((w_frame-distance)/4+width_comp), (((h_frame-distance)/4)+height_comp));
		registrazione.setLocation(((w_frame-distance)/4+width_comp), (int)((((h_frame-distance)/4)+height_comp)*2));
		label.setLocation(((w_frame-distance)/4+width_comp)-180, (int)(((h_frame-distance)/4)*1.75));
        
		
	}
	@Override
	public void initView(GestioneReparti m) {
		nomevisitatore.setText("Nome");
		label.setText("");
	}
	@Override
	public void refreshView() {
		nomevisitatore.setText("Nome");
		label.setText("");
	}
	@Override
	public void setHolder() {
		setholder(nomevisitatore);
		
	}
	@Override
	public void action(GestioneReparti model,InterfacciaGrafica v) {
		
			registrazione.addActionListener(e ->{
				GestionePersonale g=new GestionePersonale(nomevisitatore.getText(),true);
				boolean b=g.registra(model,0);
				v.aggiornaPers(model);
				refreshView();
				if(b)
					print(label,g.print(),Color.GREEN);
				else
					print(label,g.print(),Color.RED);
			});
			
	}
	


	

}

