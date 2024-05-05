package default_package;

import java.util.List;

abstract class Kniha implements Comparable <Kniha> {
	
	private String nazev;
	private List<String> autori;
	private int rokVydani;
	private boolean vypujceno;
	
	
	public Kniha(String nazev, List<String> autori, int rokVydani, boolean vypujceno)
	{
		this.nazev = nazev;
		this.autori = autori;
		this.rokVydani = rokVydani;
		this.vypujceno = vypujceno;
	}

	
	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	public List<String> getAutori() {
		return autori;
	}

	public void setAutori(List<String> autori) {
		this.autori = autori;
	}

	public int getRokVydani() {
		return rokVydani;
	}

	public void setRokVydani(int rokVydani) {
		this.rokVydani = rokVydani;
	}

	public boolean isVypujceno() {
		return vypujceno;
	}

	public void setVypujceno(boolean vypujceno) {
		this.vypujceno = vypujceno;
	}
	
	
	public String vypisAutoru(List<String> autori)
	{
		int size = autori.size();
		int idx = 0;
		String sAutori = autori.get(0);
		if(size > 1)
		{
			sAutori += ", ";
			for(String a: autori)
			{
				idx++;
				if(size == idx)
					sAutori += a;
				else if(idx == 1);
				else
					sAutori += a + ", ";
			}
		}
		return sAutori;
		
	}
	
	@Override
	public int compareTo(Kniha k)
	{
		return this.nazev.compareTo(k.getNazev());
	}
	
	public int compareToByRok (Kniha k)
	{
		return Integer.compare(this.rokVydani, k.getRokVydani());
	}
	
	@Override
	public abstract String toString();
	
}
