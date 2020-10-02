package autenticazione;


import manipolazioneDati.GestioneReparti;
import userInterface.InterfacciaGrafica;

public class Controller {
	 
	 private GestioneReparti model;
	 private InterfacciaGrafica view;
	 
	 public Controller(GestioneReparti m, InterfacciaGrafica v) {
	  model = m;
	  view = v;
	  initView();
	 }
	 
	 public void initView() {//serve per resettare ogni volta che clickiamo il pulsante registrazione
		 view.initView(model);	 
	 }
	 public void initController() {
		 view.logout();//disconnette la segretaria
		 view.cancella();//torna indietro se schiacci cancella
		 view.action(model);//avvio delle azioni per ogni pannello.Modifica i dati del negozio
		 view.changePanel();//quando cambia pannello resetta alle impostazioni di creazione i pannelli
		 view.setholder();//elimina i caratteri dal text field quando clickiamo all'interno
		 view.enableRegistry();//verifica che nella label quantita ci sia solo interi o double a seconda del pannello
	 }
	}
