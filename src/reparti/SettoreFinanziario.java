package reparti;


import strumenti.Euro;

public class SettoreFinanziario implements RepartoNegozio{
	private static final long serialVersionUID = 1L;
	private Euro cassa;
	public SettoreFinanziario() {cassa=new Euro(1000.00);}
	public SettoreFinanziario(Euro c) {cassa=c;}
	public  Euro getCassa() {return cassa;}
	public void addAtCassa(double c) {cassa.somma(new Euro(c));}
	public void minusCassa(double c) {cassa.sottrai(new Euro(c));}
	public boolean checkCassa(double c) {return (cassa.minoreDi(new Euro(c)));}
}
