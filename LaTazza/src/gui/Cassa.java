package gui;

public class Cassa {
	private static Euro money;
	public Cassa() {money=new Euro(1000.00);}
	public Cassa(Euro c) {money=c;}
	public static Euro getMoney() {return money;}
	public void addMoney(Euro c) {money.somma(c);}
	public void minusMoney(Euro c) {money.sottrai(c);}
	public boolean checkCassa(Euro c) {return money.minoreDi(c);}
	
}
