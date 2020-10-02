package manipolazioneDati;


public class GestionePersonale implements OperazioniNelReparto{
	private String name;
	private String stampaRisultato;
	private boolean choose;
	public GestionePersonale(String n,boolean b) {name=n;choose=b;}
	public GestionePersonale(boolean b) {choose=b;}
	public boolean registra(GestioneReparti model,int i) {
		if(choose) 
		{
			if(!name.equals(""))
			{	
				if(model.getReg().checkPersonale(name))
				{
					model.getReg().addPersonale(name);
					model.store();
					stampaRisultato=" aggiunto nel sistema";
					return true;
				}
				else {
					stampaRisultato=name+" gia' presente nel sistema";
					return false;
				}
			}
			else
			{
				stampaRisultato="Inserire nome";
				return false;	
			}
		}
		else
			if(i!=0)
			{
				model.getC().addAtCassa((model.getReg().getRegistro().get(i).getDebito().getValore())/100);
				name=model.getReg().removePersonale(i);
				model.store();
				stampaRisultato=name+" rimosso dal sistema";
				return true;
			}
			else
			{
				stampaRisultato="Selezionare personale da eliminare";
				return false;
			}
	}
	public String print() {return stampaRisultato;}

}
