package gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Pan2 extends MyPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pan2() {
	
		super("Registrazione rifornimento  cialde");
		
		  
		  
		
		tipocialda=new JComboBox<String>();
		addAndSize(tipocialda);
		quantita=new JTextField();
		addAndSize(quantita);
		registrazione=new JButton("Registra Rifornimento");
		addAndSize(registrazione);
		cancella=new JButton("Cancella");
		addAndSize(cancella);
		label= new JLabel();
		
		tipocialda.setLocation(d.getX_only_component(), d.getDist_y_panel());
		quantita.setLocation(d.getX_only_component(), (int)(d.getDist_y_panel()*1.5));
		registrazione.setLocation(d.getX_first_component(), (int)(d.getDist_y_panel()*2.5));
		cancella.setLocation(d.getX_second_component(), (int)(d.getDist_y_panel()*2.5));
		label.setLocation(d.getX_only_component(), (int)(d.getDist_y_panel()*1.5)+10);
	}

	public void initView(Model m) {
		quantita.setText("Quantità(Scatole)");
		addItems(m.getCap(), tipocialda);
		
	}

	public void setHolder() {
		setholder(quantita);
		
	}
}
