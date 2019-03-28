package gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Pan6 extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Pan6() {
		super("Rimuovi personale");
		
		nomepersonale=new JComboBox<String>();
		addAndSize(nomepersonale);
		registrazione=new JButton("Rimuovi");
		addAndSize(registrazione);
		label= new JLabel();
		
		nomepersonale.setLocation(d.getX_only_component(), d.getY_only_component());
		registrazione.setLocation(d.getX_only_component(), (int)(d.getY_only_component()*2));
		label.setLocation(d.getX_only_component(), d.getY_only_component()+10);
		
	}

	public void initView(Model m) {
		addItems(m.getP(), nomepersonale);
		
	}


}
