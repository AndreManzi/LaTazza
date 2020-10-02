package manipolazioneDati;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import reparti.*;

public class Persistenza{
	/**
	 * 
	 */
	private RisorseUmane s;
	private SettoreLogistico m;
	private SettoreRiscossione r;
	private SettoreFinanziario c;
	private File f;
	private String name_f="Dati.dat";
	public   Persistenza() {
		try {
			f=new File(name_f);
			if(!f.exists()) {
				f.createNewFile();
				s= new RisorseUmane();
				m= new SettoreLogistico();
				r= new SettoreRiscossione();
				c=new SettoreFinanziario();
				write(s,m,r,c); 
			}
			} catch (IOException e) {
			e.printStackTrace();
			f=null;
		}
		reads();
	}
	public File getF() {return f;}
	public void control() {
		while(!f.exists())
			f=new File(name_f);
		return;
	}
	
	public void write(RisorseUmane segretarie,SettoreLogistico storage, SettoreRiscossione reg,SettoreFinanziario cash) {
		s=segretarie;
		m=storage;
		r=reg;
		c=cash;
		control();
		try {
			
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(s);
			oos.writeObject(m);
			oos.writeObject(r);
			oos.writeObject(c);
			oos.flush();
			oos.close();
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public Object[] reads() {
		Object[] arr= new Object[4];
		control();
		if(!f.exists()) {
			arr[0]= new RisorseUmane();
			arr[1]= new SettoreLogistico();
			arr[2]= new SettoreRiscossione();
			arr[3]= new SettoreFinanziario();
			write((RisorseUmane)arr[0],(SettoreLogistico) arr[1], (SettoreRiscossione) arr[2], (SettoreFinanziario) arr[3]);
			return arr;
		}
		try {
			
			FileInputStream fout = new FileInputStream(f);
			ObjectInputStream oos = new ObjectInputStream(fout);
		
			arr[0] = s = (RisorseUmane) oos.readObject();
			arr[1] = m = (SettoreLogistico) oos.readObject();
			arr[2] = r = (SettoreRiscossione)  oos.readObject();
			arr[3] = c = (SettoreFinanziario) oos.readObject();
			oos.close();
		} catch (IOException e ) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return arr;
	}
}

