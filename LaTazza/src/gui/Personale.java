package gui;

public class Personale {//implementare metodi
	private String name;
	private Euro debito;
	
	public Personale(String s) {
		setName(new String(s));
		debito=new Euro(0.0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Euro getDebito() {
		return debito;
	}

	public void minusDebito(Euro deb) {
		this.debito.sottrai(deb);
	}
	public void addDebito(Euro deb) {
		this.debito.somma(deb);
	}
	public boolean searchPersonale(String s) {
		return name.equals(s);
	}
}
