package reparti;


import java.util.ArrayList;

import strumenti.Personale;

public class SettoreRiscossione implements RepartoNegozio{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/**
	 * 
	 */
	private ArrayList <Personale> registro;
	public SettoreRiscossione() {
		String nomep[]= {"Nome Personale","Enzo","Andrea","Giacomo","Nicola","Valerio","Melania","Ilary"};
		registro = new ArrayList<Personale>();
		for(int i=0;i<nomep.length;i++) {
			registro.add(new Personale(nomep[i]));
		}
	}
	public boolean checkPersonale(String text) {
			for(int i=0;i<registro.size();i++)
				if(registro.get(i).getName().equals(text))
					return false;
			return true;
		}
	public  boolean checkAndPayDebit(double deb,int i) {return registro.get(i).checkAndPayDebit(deb);}
	public ArrayList <Personale> getRegistro() {return registro;}
	public String returnDebit(int i) {return registro.get(i).getDebito().stampa();}
	public String removePersonale(int i) {
		Personale s=registro.get(i);
		registro.remove(i);
		return s.getName();
		
	}
	public void addPersonale(String string) {registro.add(new Personale(string));}
	public String personToString(int i) {return registro.get(i).getName();}
}
	

