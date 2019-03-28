package gui;

import java.util.ArrayList;

public class App {
		public static void main(String[] args) {
			String nomep[]= {"Nome Personale","Enzo","enzo1","nomep"};
			ArrayList <Personale>  p = new ArrayList<Personale>();
			//Creazione del personale molto alla leggera
			for(int i=0;i<nomep.length;i++) {
				p.add(new Personale(nomep[i]));
			}
			
			Model m = new Model(p);
			View v = new View("LaTazza");
			Controller c = new Controller(m, v);
			c.initController();
		 }
}
