package reparti;


import java.util.HashMap;

public class RisorseUmane implements RepartoNegozio {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  HashMap<String,char[]> segretarie;
	private char[] charArray ={ 'a', 'd', 'm', 'i', 'n' }; 
	public RisorseUmane() {
		segretarie=new HashMap<String, char[]>();
		segretarie.putIfAbsent("admin", charArray);

	}
	public  boolean checkSegretaria(String s, char[] cs) {
		if(segretarie.get(s)!=null)
		{
			if(segretarie.get(s).length!=cs.length)
				return false;
			char[] pw=segretarie.get(s);
			for(int i=0;i<pw.length;i++)
				if(pw[i]!=cs[i])
					return false;
			return true;
		}
		return false;
	}
	public boolean checkReg(String s, char[] cs) {
		if(segretarie.get(s)==null && cs.length!=0)
			return true;
		return false;
	}
	public  boolean registra(String s, char[] cs) {
			if(checkReg(s,cs))
				return segretarie.putIfAbsent(s, cs) == null;
		return false;
		
	}

}
