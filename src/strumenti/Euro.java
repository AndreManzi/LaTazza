package strumenti;

public class Euro implements MateriaPrima{
    
	private static final long serialVersionUID = 1L;
	private long valore;
    public Euro(long euro, long cent)
    {
        if (euro >= 0)
            valore = euro*100 + cent;
        else
            valore = euro*100 - cent;
    }
    public Euro(double d){valore = (long)(d*100);}
    public long getValore(){return valore;}
    public Euro somma(Euro e){valore = valore + e.getValore(); return this;}
    public Euro sottrai(Euro e){valore = valore - e.getValore(); return this;}
    public boolean ugualeA(Euro e){
        if (valore == e.getValore())
            return true;
        else return false;
    }
    public boolean minoreDi(Euro e)
    {
        if (valore <= e.getValore())
            return true;
        else return false;
    }
   public String stampa(){return (double)valore/100 +" euro";}
}