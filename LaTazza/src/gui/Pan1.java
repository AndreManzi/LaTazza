package gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Pan1 extends MyPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pan1()
	{
		super("Registrazione vendite cialde");
		 
		nomevisitatore=new JTextField();
		addAndSize(nomevisitatore);
		
		nomepersonale=new JComboBox<String>();
		addAndSize(nomepersonale);
		
		tipocialda=new JComboBox<String>();
		addAndSize(tipocialda);
		
		quantita=new JTextField();
		addAndSize(quantita);  
		
		contanti=new JRadioButton("Contanti");
		addAndSize(contanti); 
		
		credito=new JRadioButton("A credito");
		addAndSize(credito);	
		
		registrazione=new JButton("Registra Vendita");
		addAndSize(registrazione);
		
		cancella=new JButton("Cancella");
		addAndSize(cancella);
		
		label=new JLabel();
		 
		nomevisitatore.setLocation(d.getX_first_component(), d.getDist_y_panel());
		nomepersonale.setLocation(d.getX_second_component(), d.getDist_y_panel());
		quantita.setLocation(d.getX_second_component(), (int)(d.getDist_y_panel()*1.5));
		tipocialda.setLocation(d.getX_first_component(), (int)(d.getDist_y_panel()*1.5));
		contanti.setLocation(d.getX_first_component(), d.getDist_y_panel()*2);
		credito.setLocation(d.getX_second_component(), d.getDist_y_panel()*2);
		registrazione.setLocation(d.getX_first_component(), (int)(d.getDist_y_panel()*2.5));
		cancella.setLocation(d.getX_second_component(), (int)(d.getDist_y_panel()*2.5));
		label.setLocation(d.getX_first_component(), (int)(d.getDist_y_panel()*1.5)+30);
		 
		group= new ButtonGroup();
		group.add(contanti);;
		group.add(credito);
		 
		 
	}

	public void initView(Model m) {
		nomevisitatore.setText("Nome Visitatore");
		quantita.setText("Quantità(Cialde)");
		addItems(m.getP(), nomepersonale);
		addItems(m.getCap(), tipocialda);
		contanti.setSelected(true);
		
	}
	public void registraVendita(Model m) {
		if(checkComponent()) {
			if(credito.isSelected()){
				if(nomepersonale.getSelectedIndex()==0) {
					initView(m);
					//visualizzare che il visitatore non può fare contante
					return;
				}
				else {
					Vendita v=new Vendita(m.searchPerson(nomepersonale.getSelectedIndex()),m.selectCialda(tipocialda.getSelectedIndex()),isInteger(quantita));
					if(m.checkMagazzino(v)) {
						m.addDebit(nomepersonale.getSelectedIndex(),new Euro(v.getQ()*0.5));//aggiorna il debito
						m.minusMag(v);
						m.addCassa(v.getQ());
						initView(m);
						//visualizzare che al personale x è stato addebitato la somma v.print();
					}
					else {
						initView(m);
						//dire che all'interno del mag non ci sono abbastanza cialde;
					}
				}
			}
			else {
				if(nomepersonale.getSelectedIndex()==0) {
					Vendita v=new Vendita(nomevisitatore.getText(),m.selectCialda(tipocialda.getSelectedIndex()),isInteger(quantita));
					if(m.checkMagazzino(v)) {
						m.minusMag(v);
						initView(m);
						//visualizzare che al visitatore x è stato addebitato la somma v.print();
					}
					else {
						initView(m);
						//dire che all'interno del mag non ci sono abbastanza cialde;
					}
				}
				else {
					Vendita v=new Vendita(m.searchPerson(nomepersonale.getSelectedIndex()),m.selectCialda(tipocialda.getSelectedIndex()),isInteger(quantita));
					if(m.checkMagazzino(v)) {
						m.minusMag(v);
						initView(m);
						//visualizzare che al personale x è stato addebitato la somma v.print();
					}
					else {
						initView(m);
						//dire che all'interno del mag non ci sono abbastanza cialde;
					}
				}
			}
		}
		else {
			initView(m);
			System.out.println("errore");
			//visualizza che ci sono state delle scelte errato oppure nulla
		}
	}

	//verifica che i ci sia selezionato o nomevisitatore  nomepersonale e che in quantita ci sia un integer
	public boolean checkComponent() {
		return(isEmptyStringINTextField(nomevisitatore, "Nome Visitatore")^(nomepersonale.getSelectedIndex()!=0)&& (isInteger(quantita)>0));
	}

	public void setHolder() {
		setholder(nomevisitatore);
		setholder(quantita);
		
	}

	public void setLayout(String string) {
		// TODO Auto-generated method stub
		
	}
	


}
