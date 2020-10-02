package manipolazioneDati;

import strumenti.Euro;

public class Pagamento implements OperazioniNelReparto{
	private String name;
	private double debitosaldato;
	private String stampaRisultato;
	public Pagamento(String s, double double1) {
		name=s;
		if(double1>0)
			debitosaldato=double1;
		else
			debitosaldato=0;
	}
	public boolean registra(GestioneReparti m, int i) {
		if(i>0){
			if(debitosaldato>0)
			 {
				if(m.getReg().checkAndPayDebit(debitosaldato,i))
				{
					m.store();
					stampaRisultato="Pagamento registrato di "+name+" per "+(new Euro(debitosaldato)).stampa()+".Residuo ";
					return true;	
				}
				else {
					stampaRisultato="Inserito un saldo superiore per "+ name+".Debito pari a "+m.getReg().returnDebit(i);;
					return false;
				}
			 }
			else
			{
				stampaRisultato="Inserire un saldo valido";
				return false;
			}
		}
		else {
			 stampaRisultato="Selezionare personale";
			 return false;
		}
		
	}
	public String print() {return stampaRisultato;}

}
