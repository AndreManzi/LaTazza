package strumenti;

public class Personale implements MateriaPrima{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Euro debito;
	
	public Personale(String s) {
		name=(new String(s));
		debito=new Euro(0);
	}

	public String getName() {
		return name;
	}
	public Euro getDebito() {
		return debito;
	}

	public void minusDebito(Euro deb) {
		this.debito.sottrai(deb);
	}
	public void addDebito(double d) {
		this.debito.somma(new Euro(d));
	}
	public boolean searchPersonale(String s) {
		return name.equals(s);
	}

	public boolean checkAndPayDebit(double deb) {
		if(!debito.minoreDi(new Euro(deb))|| debito.ugualeA(new Euro(deb)))
		{
			minusDebito(new Euro(deb));
			return true;
		}
			return false;
	}
	public String visualizzaStato() {
		return (name +" : "+ debito.stampa());
	}

	public boolean ugualeA(int i) {
		return debito.minoreDi(new Euro(0));
	}
}
