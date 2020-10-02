package userInterface;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import manipolazioneDati.GestioneReparti;


public class InterfacciaGrafica {
	protected int w_frame=820;
	protected int h_frame=700;
	protected JFrame frame;
	protected ArrayList <Pannelo> p=new ArrayList<Pannelo>();;
	protected JTabbedPane tab;

 public InterfacciaGrafica(String s) {
	
	  frame = new JFrame(s);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(w_frame, h_frame);
	  frame.setLocationRelativeTo(null);
	  frame.setVisible(true);
	  frame.setResizable(false);
	  
	  //lista di pannelli
	  tab=new JTabbedPane(JTabbedPane.TOP);
	  for(int i=0;i<6;i++) {
		  switch(i+1)
		  {
		  case 1:
			  p.add(new VenditaCialde(w_frame,h_frame));
			  tab.add("Registra", p.get(i));
			  break;
		  case 2:
			  p.add(new RifornimentoScatole(w_frame,h_frame));
			  tab.add("Rifornisci", p.get(i));
			  break;
		  case 3:
			  p.add(new PagamentoDebiti(w_frame,h_frame));
			  tab.add("Salda", p.get(i));
			  break;
		  case 4:
			  p.add(new StatoNegozio(w_frame,h_frame));
			  tab.add("Salda shop", p.get(i));
			  break;
		  case 5:
			  p.add(new AggiuntaPersonale(w_frame,h_frame));
			  tab.add("Aggiungi", p.get(i));
			  break;
		  case 6:
			  p.add(new RimozionePersonale(w_frame,h_frame));
			  tab.add("Rimuovi", p.get(i));
			  break;
			  
		  }
	  }
	  frame.add(tab);
  
 }

 
 public JFrame getFrame() {
  return frame;
 }
 
 public void setFrame(JFrame frame) {
  this.frame = frame;
 }
 public void initView(GestioneReparti m) {
	 for(int i=0;i<p.size();i++)
		 p.get(i).initView(m);
	 
 }
public void setholder() {
	for(int i=0;i<p.size();i++)
		 p.get(i).setHolder();;
}
public void aggiornaPers(GestioneReparti model) {
			 for(int i=0;i<p.size();i++)
				 p.get(i).refreshView(model);	
}	
public void aggiornaAll() {
		 for(int i=0;i<p.size();i++)
			 p.get(i).refreshView();
}
public void enableRegistry() {
	 for(int i=0;i<p.size();i++)
		 p.get(i).enableRegistry();	
}
public void cancella() {
	for(int i=0;i<p.size();i++)
		 p.get(i).cancella(this);
}
public void changePanel() {
	tab.addMouseListener(new MouseAdapter() {
		 @Override
		 public void mouseClicked(MouseEvent e) {
			aggiornaAll();
		 }
	 });
}


public void aggiornaCassaMagazzino(GestioneReparti m) {
	for(int i=0;i<p.size();i++)
		 p.get(i).refreshView(m);	
	
}


public void action(GestioneReparti model) {
	for(int i=0;i<p.size();i++)
		 p.get(i).action(model, this);
	
}


public void logout() {
	for(int i=0;i<p.size();i++)
		 p.get(i).logOut(this);
	}

}