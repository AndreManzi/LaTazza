package manipolazioneDati;

import strumenti.Euro;
import strumenti.Tipocialda;

public class Vendita implements OperazioniNelReparto{
	private boolean contanti=true;
	private String name;
	private Tipocialda c;
	private int q;
	private String stampaRisultato;
	public Vendita(String n,Tipocialda cialda,int i,boolean b) {
		contanti=b;
		c=cialda;
		if(n==null)
		{
			name="";
			q=-1;
		}
		else
		{
			name=n;
			q=i;
		}
	}
	public boolean registra(GestioneReparti m,int i) {
		if (q>0) {
			if(m.getM().checkCialda(c,q)){
				m.getM().minusCialda(c, q);
				if(contanti) 
				{
					m.getC().addAtCassa((double)(q*0.50)); 
					m.store();
				}
				else
				{
					m.getReg().getRegistro().get(i).addDebito(q*0.5);
					m.store();
				}
				stampaRisultato=("Vendita registrata per "+q+" cialde di "+c.name()+" a "+name+" con pagamento "+ ((contanti) ?"in contanti":"a credito")+ " di "+ (new Euro(q*0.5).stampa()));
				return true;
			}
			else {
				stampaRisultato=("Non sono disponibili "+q+" cialde di "+c.name()+"(max "+m.getM().getNumCialda(c)+")");
				return false;
			}
		}
		else {
			stampaRisultato=("Errore nelle selezioni");
			return false;
		}
	}
	public String print() {return stampaRisultato;}
}
	
