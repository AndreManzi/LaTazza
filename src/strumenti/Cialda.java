package strumenti;

public class Cialda implements MateriaPrima{
	private static final long serialVersionUID = 1L;
	private Tipocialda type;
	public Cialda(Tipocialda c) {
		type=c;
	}
	public Tipocialda getType() {
		return type;
	}
}
