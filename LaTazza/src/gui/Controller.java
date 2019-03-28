package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		 view.getReg_ven_cia().getRegistrazione().addActionListener(e -> registravendita(model));
		 view.getReg_ven_cia().getCancella().addActionListener(e -> initView());
	
		 
		 view.getReg_rif_sca().getRegistrazione().addActionListener(e -> registrarifornimento(model));
		 view.getReg_rif_sca().getCancella().addActionListener(e -> initView());
		 
		 view.getReg_pag().getRegistrazione().addActionListener(e -> registrapagamento(model));
		 view.getReg_pag().getCancella().addActionListener(e -> initView());
		 view.getStateof().getNomepersonale().addActionListener(e -> visualizzaDebito());
		 //aggiung
		 //rimuovi
		 view.setholder();
		 
	 }
	 
	
	private void visualizzaDebito() {
		// TODO Auto-generated method stub
		view.visualizzaDebito(model);
	}

	private void registrapagamento(Model m) {
	}

	private void registrarifornimento(Model m) {
	}

	private void registravendita(Model m) {
		view.registravendita(m);
		//view.checkVendita(Model m);
		//String p=(String) view.getReg_ven_cia().getNomepersonale().getSelectedItem();
		view.getReg_ven_cia().setLayout("corretto");
		//view.getReg_ven_cia().getNomevisitatore().setText("ciao");
	}


	 
	}
