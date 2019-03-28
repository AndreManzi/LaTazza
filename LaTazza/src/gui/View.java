package gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class View {
	 
	 private JFrame frame;
	 private Pan1 reg_ven_cia;
	 private Pan2 reg_rif_sca;
	 private Pan3 reg_pag;
	 private Pan4 stateof;
	 private Pan5 addp;
	 private Pan6 remp;
	 private JTabbedPane tab;
	 private Dim d=new Dim();//dividere Dim frame con Dim panel
 // View uses Swing framework to display UI to user	


 
 public View(String s) {
	
	  frame = new JFrame(s);
	  //frame.setUndecorated(true); mi nasconde la crocetta di chiusura finestra Windows
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(d.getW_frame(), d.getH_frame());
	  frame.setLocationRelativeTo(null);
	  frame.setVisible(true);
	  
	  reg_ven_cia=new Pan1();
	  reg_rif_sca= new Pan2();
	  reg_pag=new Pan3();
	  stateof=new Pan4(d);
	  addp=new Pan5();
	  remp=new Pan6();
	  
	  tab=new JTabbedPane(JTabbedPane.TOP);
	  tab.addTab("Registra" ,reg_ven_cia);
	  tab.addTab("Rifornisci", reg_rif_sca);
	  tab.addTab("Salda", reg_pag);
	  tab.addTab("Stato shop", stateof);
	  tab.addTab("Aggiungi", addp);
	  tab.addTab("Rimuovi", remp);
	  
	  frame.add(tab);
  
 }
 public void initView(Model m) {
	 reg_ven_cia.initView(m);
	 reg_rif_sca.initView(m);
	 reg_pag.initView(m);
	 stateof.initView(m);
	 addp.initView(m);
	 remp.initView(m);
	 
 }
 
 public JFrame getFrame() {
  return frame;
 }
 
 public void setFrame(JFrame frame) {
  this.frame = frame;
 }
 public Pan1 getReg_ven_cia() {
	 return reg_ven_cia;
 }
 public void setReg_ven_cia(Pan1 p)
 {
	 this.reg_ven_cia=p;
 }
 public Pan2 getReg_rif_sca() {
	 return reg_rif_sca;
 }
 public void setReg_rif_sca(Pan2 p)
 {
	 this.reg_rif_sca=p;
 }
 public Pan3 getReg_pag() {
	 return reg_pag;
 }
 public void setReg_pag(Pan3 p)
 {
	 this.reg_pag=p;
 }

public Pan4 getStateof() {
	return stateof;
}

public void setStateof(Pan4 stateof) {
	this.stateof = stateof;
}

public Pan5 getAddp() {
	return addp;
}

public void setAddp(Pan5 addp) {
	this.addp = addp;
}

public Pan6 getRemp() {
	return remp;
}

public void setRemp(Pan6 remp) {
	this.remp = remp;
}
public void registravendita(Model m) {
	reg_ven_cia.registraVendita(m);
}
public void setholder() {
	 reg_ven_cia.setHolder();
	 reg_rif_sca.setHolder();
	 reg_pag.setHolder();
	
	 addp.setHolder();
}
 
public void visualizzaDebito(Model m) {
	stateof.visualizzaDebito(m);
}
 

public void visualizzaDisponbilita(Model m) {
	stateof.visualizzaDisponbilita(m);
}
}