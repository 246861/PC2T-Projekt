package default_package;

import java.util.List;

public class Ucebnice extends Kniha{
	
	public enum Skola {základní, střední}
	private Skola skola;
	private int rocnik;
	
	
	public Ucebnice(String nazev, List<String> autori, int rokVydani, boolean vypujceno, Skola skola, int rocnik)
	{
		super(nazev, autori, rokVydani, vypujceno);
		this.skola = skola;
		this.rocnik = rocnik;
	}


	public Skola getSkola() {
		return skola;
	}

	public void setSkola(Skola skola) {
		this.skola = skola;
	}

	public int getRocnik() {
		return rocnik;
	}

	public void setRocnik(int rocnik) {
		this.rocnik = rocnik;
	}
	
	
	@Override
	public String toString()
	{
		if(isVypujceno())
			return "Učebnice: " +getNazev()+ " od autora/ů: " +vypisAutoru(getAutori())+ ", rok vydání: " +getRokVydani()+ ", škola: " +skola.toString()+ ", ročník: " + rocnik +", stav: vypůjčeno";
		else 
			return "Učebnice: " +getNazev()+ " od autora/ů: " +vypisAutoru(getAutori())+ ", rok vydání: " +getRokVydani()+ ", škola: " +skola.toString()+ ", ročník: " + rocnik +", stav: k dispozici";
	}
	
}
