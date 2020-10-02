package manipolazioneDati;

public class LogSign implements OperazioniNelReparto{
	private String user;
	private char[] pass;
	private int op;
	private String stampaRisultato;
	public LogSign(String text, char[] password) {
		user=text;
		pass=password;
	}

	@Override
	public boolean registra(GestioneReparti m, int i) {
		op=i;
		switch(op) {
		case 1:
			if(m.getSeg().checkSegretaria(user, pass))
			{
				stampaRisultato="Autenticazione riuscita";
				return true;
			}
			else
			{
				stampaRisultato="Autenticazione fallita";
				return false;
			}
			
		case 2:
			boolean b=m.getSeg().registra(user, pass);
			if(b)
			{
				stampaRisultato=user+" registrato";
				m.store();
				return true;
			}
			else
			{
				stampaRisultato=user+" non registrato";
				return false;
			}
		}
		return false;
		
			
	}

	@Override
	public String print() {
		return stampaRisultato;
	}

}
