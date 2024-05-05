package default_package;

import java.util.List;

public class Roman extends Kniha {
	
	public enum Zanr {detektivní, scifi, fantasy, horor, realistický}
	private Zanr zanr;
	
	
	public Roman(String nazev, List<String> autori, int rokVydani, boolean vypujceno, Zanr zanr)
	{
		super(nazev, autori, rokVydani, vypujceno);
		this.setZanr(zanr);
	}

	
	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}
	
	
	@Override
	public String toString()
	{
		if(isVypujceno())
			return "Román: " +getNazev()+ " od autora/ů: " +vypisAutoru(getAutori())+ ", rok vydání: " +getRokVydani()+ ", žánr: " +zanr.toString()+ ", stav: vypůjčeno";
		else 
			return "Román: " +getNazev()+ " od autora/ů: " +vypisAutoru(getAutori())+ ", rok vydání: " +getRokVydani()+ ", žánr: " +zanr.toString()+ ", stav: k dispozici";
	}
}
