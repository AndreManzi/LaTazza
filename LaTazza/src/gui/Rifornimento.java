package gui;

public class Rifornimento {
	Tipocialda c;
	int q;
	public Rifornimento(Tipocialda cialda,int i) {
		c=cialda;
		if(i>0) q=i*50;
		else q=0;
	}
	public Rifornimento getR() {
		return this;
	}
	public void setR(Tipocialda cialda,int quantita) {
		if(c.equals(cialda))
			q=quantita;
	}
}
