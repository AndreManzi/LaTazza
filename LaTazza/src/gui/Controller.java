package gui;

public class Controller {
	 
	 private Model model;
	 private View view;
	 
	 public Controller(Model m, View v) {
	  model = m;
	  view = v;
	  initView();
	 }
	 
	 public void initView() {//serve per resettare ogni volta che clickiamo il pulsante registrazione
		 view.initView(model);
	 }
	 
	 public void initController() {
		 //crea rifornimento quando registro, check per vedere se la cassa puo e poi aggiorno magazzino
		 view.getReg_ven_cia().getRegistrazione().addActionListener(e -> registravendita());
		 view.getReg_ven_cia().getCancella().addActionListener(e -> initView());
	
		 
		 view.getReg_rif_sca().getRegistrazione().addActionListener(e -> registrarifornimento());
		 view.getReg_rif_sca().getCancella().addActionListener(e -> initView());
		 
		 view.getReg_pag().getRegistrazione().addActionListener(e -> registrapagamento());
		 view.getReg_pag().getCancella().addActionListener(e -> initView());
		 view.getStateof().getNomepersonale().addActionListener(e -> visualizzaDebito());
		 //aggiung
		 //rimuovi
		 view.getAddp().getRegistrazione().addActionListener(e -> registrapersonale());
		 
		 view.setholder();
		 
	 }
	 
	
	private void registrapersonale() {//modifiche della lista da aggiornare
		view.aggiungiPersonale(model);
		view.aggiornaPersonale(model);
	}
			

	private void visualizzaDebito() {
		view.visualizzaDebito(model);
	}

	private void registrapagamento() {
	}

	private void registrarifornimento() {
	}

	private void registravendita() {
		view.registravendita(model);
		
		//view.getReg_ven_cia().setLayout("corretto");
		//view.getReg_ven_cia().getNomevisitatore().setText("ciao");
	}


	 
	}
