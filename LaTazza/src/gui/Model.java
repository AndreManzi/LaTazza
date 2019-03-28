package gui;

import java.util.ArrayList;

public  class Model {
	private String nomev;//="Nome Visitatore";
	private ArrayList <Personale> p;
	private Vendita v;
	private Rifornimento rif;
	private Cassa c;
	private Magazzino mag;
	private static Cialda cap[]= {new Cialda(Tipocialda.caffe),new Cialda(Tipocialda.caffe_arabica),new Cialda(Tipocialda.camomilla),new Cialda(Tipocialda.cioccolata),new Cialda(Tipocialda.the),new Cialda(Tipocialda.the_limone)};
 //fare cap in modo migliore
	
	public Model(ArrayList <Personale> per) {//giusto per successivo step
		p=per;
		c=new Cassa();
		mag=new Magazzino();
	}
	 
	public String getNomev() {
	  return nomev;
	 }
	 
	public void setNomev(String nome) {
	  nomev = nome;
	 }
	
	public Rifornimento getRif() {
		return rif;
	}

	public void setRif(Rifornimento rif) {
		this.rif = rif;
	}

	public Vendita getV() {
		return v;
	}

	public void setV(Vendita v) {
		this.v = v;
	}

	public Cassa getC() {
		return c;
	}

	public void setC(Cassa c) {
		this.c = c;
	}
	
	public Magazzino getMag() {
		return mag;
	}
	
	public void setMag(Magazzino mag) {
		this.mag = mag;
	}
	
	public Cialda[] getCap() {
		return cap;
	}

	public ArrayList <Personale> getP() {
		return p;
	}

	public void setP(ArrayList <Personale> p) {
		this.p = p;
	}
	public void addDebit(int i,Euro e) {
		p.get(i).addDebito(e);
	}
	public boolean checkMagazzino(Vendita v) {//verifica la quantita della cialda del magazzino
		return mag.checkCialda(v);
	}
	public String searchPerson(int i) {
		return p.get(i).getName();
	}
	public Tipocialda selectCialda(int i) {
		return cap[i].getType();
	}

	public void minusMag(Vendita v) {
		mag.minusCialda(v);
		
	}

	public void addCassa(int q) {
		c.addMoney(new Euro(q*0.50));
		
	}
}
