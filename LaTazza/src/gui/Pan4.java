package gui;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Pan4 extends MyPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Pan4(Dim d) {
		super("Stato Magazziono, cassa e debiti personale");
		 
		/*
		 * Ho provato ad implementare con l'ActionListener,
		 * in modo che quando uno seleziona dal JComboBox (un tipo cialda,
		 * o nomepersonale mi si aggiorna in tempo reale il label con il debito!
		 * Vuole i campi commentati static, ma se li metto static 
		 * nelle altre pagine non mi funzionano correttamente.
		 * Non riesco a stampare la disponibil� nel magazzino n� debito della data persona.
		 */
		
		//cassa
		statocassa=new JLabel();
		addAndSize(statocassa);
		
		//magazzino
		tipocialda=new JComboBox<String>();
		addAndSize(tipocialda);
/*		tipocialda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//disponibilita.setText("Disponibilit�: " + gui.Pan4.tipocialda.getSelectedItem());
			}
	    });*/
		disponibilita=new JLabel();
		addAndSize(disponibilita);
		
		//debiti
		debito=new JLabel();
		addAndSize(debito);
		nomepersonale=new JComboBox<String>();
		addAndSize(nomepersonale);
/*		nomepersonale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//debito.setText("Debito: " + gui.Pan4.nomepersonale.getSelectedItem());
			}
	    }); */
		
		
		statocassa.setLocation(d.getX_only_component(), d.getY_only_component());
		
		tipocialda.setLocation((int) (d.getX_only_component()*0.5), (int) (d.getDist_y_panel()*1.5));
		disponibilita.setLocation(d.getX_only_component(), (int)(d.getDist_y_panel()*1.5));
		
		nomepersonale.setLocation((int) (d.getX_only_component()*0.5), (int) (d.getDist_y_panel()*2));
		debito.setLocation(d.getX_only_component(), (int)(d.getDist_y_panel()*2));


	}
	
	public void initView(Model m) {
		// TODO Auto-generated method stub
		statocassa.setText("Stato cassa: " + gui.Cassa.getMoney().stampa());
		
		addItems(m.getCap(), tipocialda);
		disponibilita.setText("PROVA Disponibilita: ");
		//disponibilita.setText("Disponibilit�: " + gui.Pan4.tipocialda.getSelectedItem());
		
		addItems(m.getP(), nomepersonale);
		debito.setText("PROVA Debito: ");
		//debito.setText("Debito: " + gui.Pan4.nomepersonale.getSelectedItem());

		
	}

	public void visualizzaDebito(Model m) {
		// TODO Auto-generated method stub
		debito.setText("Debito: " + m.getP().get(nomepersonale.getSelectedIndex()).getDebito().stampa());
	}

	public void visualizzaDisponbilita(Model m) {
		// TODO Auto-generated method stub
		//debito.setText("Disponibilita: " + m.getMag().getM(tipocialda.)));
	}
	
	
	
}
