package reparti;


import java.util.HashMap;

import strumenti.Cialda;
import strumenti.Tipocialda;


public class SettoreLogistico implements RepartoNegozio{
	private static final long serialVersionUID = 1L;
	private static Cialda cap[]= {new Cialda(Tipocialda.caffe),new Cialda(Tipocialda.caffe_arabica),new Cialda(Tipocialda.camomilla),new Cialda(Tipocialda.cioccolata),new Cialda(Tipocialda.the),new Cialda(Tipocialda.the_limone)};
	private HashMap<Tipocialda,Integer> magazzino;
	public SettoreLogistico() {
		
		magazzino=new HashMap<Tipocialda,Integer>();
		for(int i=0;i<Tipocialda.values().length;i++) {
			magazzino.put(Tipocialda.values()[i], 500);
		}


	}
	public Tipocialda selectCialda(int i) {return cap[i].getType();}
	public int sizeMag() {return magazzino.size();}
	public Cialda[] getCialde() {return cap;}
	public Integer getNumCialda(Tipocialda c) {return magazzino.get(c);}
	public boolean checkCialda(Tipocialda c,int q) {return(	magazzino.get(c)-q >=0);}
	public void minusCialda(Tipocialda c,int q) {magazzino.put(c, magazzino.get(c)-q);}
	public String visualizzaMag(int i) {
			String s = (Tipocialda.values()[i]+" : "+magazzino.get(Tipocialda.values()[i])+"\n");
		return s;
	}
	public  void addCialda(int q,Tipocialda c) {magazzino.put(c, magazzino.get(c)+q);}
	public String visualizzaTipoCialda(int i) {return cap[i].getType().name();}
	
}