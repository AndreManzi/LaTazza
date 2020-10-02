package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Pan5 extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	protected Pan5() {
		super("Aggiungi Personale");
		nomevisitatore=new JTextField();
		addAndSize(nomevisitatore);
		registrazione=new JButton("Aggiungi");
		addAndSize(registrazione);
		label= new JLabel();
		
		nomevisitatore.setLocation(d.getX_only_component(), d.getY_only_component());
		registrazione.setLocation(d.getX_only_component(), (int)(d.getY_only_component()*2));
		label.setLocation(d.getX_only_component(), d.getY_only_component()+10);
        
		
	}

	public void initView(Model m) {
		nomevisitatore.setText("Nome");
		
	}

	public void setHolder() {
		setholder(nomevisitatore);
		
	}

	public void aggiungiPersonale(Model model) {
			if(model.checkPersonale(nomevisitatore.getText())) {
				model.addPersonale(nomevisitatore.getText());
				initView(model);
				//ok
			}
			initView(model);
			//non ok
	}

	

}
