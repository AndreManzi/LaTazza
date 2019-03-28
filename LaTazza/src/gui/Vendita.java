package gui;

public class Vendita {
	String name;
	Tipocialda c;
	int q;
	public Vendita(String n,Tipocialda cialda,int i) {
		name=n;
		c=cialda;
		if(i>0) q=i;
		else q=0;
	}
	
	public String getName() {
		return name;
	}
	public Tipocialda getC() {
		return c;
	}
	public int getQ() {
		return q;
	}
	public String print() {
		return(name+" ha acquistato "+q+" cialde di "+c.toString());
	}
}
