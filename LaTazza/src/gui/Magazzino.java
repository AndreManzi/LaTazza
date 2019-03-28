package gui;

import java.util.HashMap;

public class Magazzino {
	private HashMap<Tipocialda,Integer> mag;//oppure usare Cialda con Type come enum tipocialda e usare una gettype
	
	public Magazzino() {
		mag=new HashMap<Tipocialda,Integer>();
		mag.put(Tipocialda.caffe,500);
		mag.put(Tipocialda.caffe_arabica,500);
		mag.put(Tipocialda.camomilla,500);
		mag.put(Tipocialda.cioccolata,500);
		mag.put(Tipocialda.the,500);
		mag.put(Tipocialda.the_limone,500);
	}
	public Magazzino(int init ) {
		mag=new HashMap<Tipocialda,Integer>();
		mag.put(Tipocialda.caffe,init);
		mag.put(Tipocialda.caffe_arabica,init);
		mag.put(Tipocialda.camomilla,init);
		mag.put(Tipocialda.cioccolata,init);
		mag.put(Tipocialda.the,init);
		mag.put(Tipocialda.the_limone,init);
	}
	public HashMap<Tipocialda,Integer> getM(Tipocialda c) {
		return mag;
	}

	public void setM(Vendita v) {
		//finche non lo trovo scorro, 
		//trovo aggiorno 
	}
	public boolean checkCialda(Vendita v) {
		return(	mag.get(v.getC())-v.getQ()	>0);
	}
	public void minusCialda(Vendita v) {
		mag.put(v.getC(), mag.get(v.getC())-v.getQ());
		
	}
	
	
}