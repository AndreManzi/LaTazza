package manipolazioneDati;

import strumenti.Euro;
import strumenti.Tipocialda;

public class Rifornimento implements OperazioniNelReparto{
	private Tipocialda c;
	private int q;
	private String stampaRisultato;
	public Rifornimento(Tipocialda cialda,int i) {
		c=cialda;
		if(i>0) q=i*50;
		else q=0;
	}
	public boolean registra(GestioneReparti m,int i) {
		if(q>0)
		{
			if (!m.getC().checkCassa((double)(0.40*q)))
			{
				m.getC().minusCassa((double)(0.40*q));
				m.getM().addCialda(q,c);
				stampaRisultato="Rifornimento registrato per "+q/50+" scatole di "+c.name()+")per un totale di "+(new Euro(q*0.40)).stampa();
				m.store();
				return true;
			}
			else {
				stampaRisultato="Rifornimento di cialde di "+c.name()+" non effettuato. Insufficenza di soldi in cassa ";
				return false;
			}
		}
		else {
			stampaRisultato="Inserire quantita";
			return false;
		}
	}
	public String print() {return stampaRisultato;}
	
}
