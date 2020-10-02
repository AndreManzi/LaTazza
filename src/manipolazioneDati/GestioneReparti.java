package manipolazioneDati;


import javax.swing.DefaultListModel;

import reparti.*;

public  class GestioneReparti {
	private RisorseUmane s;
	private SettoreRiscossione r;
	private SettoreLogistico mag;
	private SettoreFinanziario c;
	public GestioneReparti() {
		Persistenza f=new Persistenza();
		Object a[]=f.reads();
		s=(RisorseUmane)a[0];
		mag = (SettoreLogistico) a[1];
		r = (SettoreRiscossione) a[2];
		c = (SettoreFinanziario) a[3];
		store();//riscrivo per sicurezza
	}
	public void store(){
		Persistenza f=new Persistenza();
		if(f.getF().canWrite())
			f.write(s, mag, r,c);
		
	}
	//Segretarie
	public RisorseUmane getSeg() {return s;} 
	//Magazzino
	
	public SettoreLogistico getM() {return mag;}
	
	//Cassa
	public SettoreFinanziario getC() {return c;}
	public String cassaToString() {return c.getCassa().stampa();}

	//Registro
	public SettoreRiscossione getReg() {return r;}
	
	
	public DefaultListModel<String> stateTot() {
		DefaultListModel<String> l = new DefaultListModel<>();
		 for(int i=0;i<mag.sizeMag();i++)
			 l.addElement(mag.visualizzaMag(i));
		return l;
	}
	public DefaultListModel<String> debitP() {
		DefaultListModel<String> l = new DefaultListModel<>();
		 for(int i=1;i<r.getRegistro().size();i++) 
			if(!r.getRegistro().get(i).ugualeA(0))
				l.addElement(r.getRegistro().get(i).visualizzaStato());
		return l;
	}
	
}
