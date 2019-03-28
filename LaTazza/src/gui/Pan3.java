package gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Pan3 extends MyPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pan3()
	{

		super("Registrazione pagamento  cialde");
		quantita=new JTextField();
		addAndSize(quantita);
		nomepersonale=new JComboBox<String>();
		addAndSize(nomepersonale);
		registrazione=new JButton("Registra Pagamento");
		addAndSize(registrazione);
		cancella=new JButton("Cancella");
		addAndSize(cancella);;
		label= new JLabel();
		
		nomepersonale.setLocation(d.getX_only_component(),d.getDist_y_panel());
		quantita.setLocation(d.getX_only_component(), (int)(d.getDist_y_panel()*1.5));
		registrazione.setLocation(d.getX_first_component(), (int)(d.getDist_y_panel()*2.5));
		cancella.setLocation(d.getX_second_component(), (int)(d.getDist_y_panel()*2.5));
		label.setLocation(d.getX_only_component(),  (int)(d.getDist_y_panel()*1.5)+10);
		
	}

	public void initView(Model m) {
		 quantita.setText("Ammontare");
		 addItems(m.getP(),nomepersonale);
		 
		
	}

	public void setHolder() {
		setholder(quantita);
		
	}
}