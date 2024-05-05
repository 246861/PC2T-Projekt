package default_package;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import default_package.Roman.Zanr;
import default_package.Ucebnice.Skola;

public class Program {

	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	

//pokud je zadáno A - ano, vrací true, pokud zadáno N - ne, vrací false, jinak vrací vyjímku
	public static boolean anoNe (Scanner sc)
	{
		boolean volba;	
		String input;
		System.out.println("A - ano, N - ne");
		try
		{
			input = sc.next();
			if(input.equals("a") || input.equals("A"))
				volba = true;
			else if(input.equals("n") || input.equals("N"))
				volba = false;
			else throw new Exception("Neznámý input");
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim: A - ano, N - ne");
			sc.nextLine();
			volba = anoNe(sc);
		}
		return volba;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int volba;
		boolean run = true;
		List<Kniha> seznamVsechKnih = new ArrayList<>();
		
		
		
		while(run)
		{
			System.out.println("1...Přidat novou knihu");
			System.out.println("2...Upravit existující knihu");
			System.out.println("3...Smazat knihu");
			System.out.println("4...Změna dostupnosti knihy");
			System.out.println("5...Výpis knih");
			System.out.println("6...Vyhledat knihu");
			System.out.println("7...Uložení jedné knihy do souboru");
			System.out.println("8...Načtení knihy ze souboru");
			System.out.println("9...Ukončení programu");
//pracovní přidání knih
			System.out.println("10...Přidat 10 různých knih");
			
			volba=pouzeCelaCisla(sc);
			
			switch(volba)
			{
				case 1:
					
					int typ;
					String nazev;
					int pocetAutoru;
					List<String> autori = new ArrayList<>();
					int rokVydani;
					boolean vypujceno;
					
					System.out.println();
					System.out.println("Vyberte typ knihy: 1 - román, 2 - učebnice");
					do
					{
						typ = pouzeCelaCisla(sc);
						if((typ != 1) && (typ !=2)) 
							System.out.println("Zadejte platný typ knihy: 1 - román, 2 - učebnice");
					}while((typ != 1) && (typ !=2));
					sc.nextLine();
					System.out.println("Zadejte název");
					nazev = sc.nextLine();
					
					System.out.println("Zadejte počet autorů");
					pocetAutoru = pouzeCelaCisla(sc);
					sc.nextLine();
					
					for(int i = 0; i<pocetAutoru; i++)
					{
						System.out.println("Zadejte autora " + (i+1));
						autori.add(sc.nextLine());
					}
					
					System.out.println("Zadejte rok vydání");
					rokVydani = pouzeCelaCisla(sc);
					sc.nextLine();
					
					System.out.println("Je kniha vypůjčená?");
					vypujceno = anoNe(sc);
					sc.nextLine();
					
					switch(typ)
					{
						case(1):
							Zanr zanr = null;
							System.out.println("Zadejte žánr: 1 - detektivní, 2 - scifi, 3 - fantasy, 4 - horor, 5 - realistický");
							do
							{
								volba = pouzeCelaCisla(sc);
								sc.nextLine();
								if(volba != 1 && volba != 2 && volba != 3 && volba != 4 && volba != 5)
									System.out.println("Zadejte platný žánr");
							}while(volba != 1 && volba != 2 && volba != 3 && volba != 4 && volba != 5);
							switch(volba)
							{
							case(1):
								zanr = Zanr.detektivní;
								break;
							case(2):
								zanr = Zanr.scifi;
								break;
							case(3):
								zanr = Zanr.fantasy;
								break;
							case(4):
								zanr = Zanr.horor;
								break;
							case(5):
								zanr = Zanr.realistický;
								break;
							}
							
				            Roman roman = new Roman(nazev, autori, rokVydani, vypujceno, zanr);
				            
							System.out.println("Opravdu chcete přidat knihu: " + roman.toString());
							
							if(anoNe(sc))
							{
//zde možná přidat kontrolu, jestli už ta kniha neexistuje podle názvu
								seznamVsechKnih.add(roman);
								System.out.println("Kniha přidána");
							}
							System.out.println();
							break;
						case(2):
							Skola skola = null;
							System.out.println("Zadejte školu: 1 - základní, 2 - střední");
							do
							{
								volba = pouzeCelaCisla(sc);
								sc.nextLine();
								if(volba != 1 && volba != 2 )
									System.out.println("Zadejte platnou školu");
							}while(volba != 1 && volba != 2);
							System.out.println("Zadejte ročník: ");
							int rocnik = pouzeCelaCisla(sc);
							sc.nextLine();
							
							switch(volba)
							{
							case(1):
								skola = Skola.základní;
							break;
							case(2):
								skola = Skola.střední;
							break;
							}
							
							Ucebnice ucebnice = new Ucebnice(nazev, autori, rokVydani, vypujceno, skola, rocnik);
							
							System.out.println("Opravdu chcete přidat knihu: " +ucebnice.toString());
							if(anoNe(sc))
							{	
//zde možná přidat kontrolu, jestli už ta kniha neexistuje podle názvu
								seznamVsechKnih.add(ucebnice);
								System.out.println("Kniha přidána");
							}
							sc.nextLine();
							System.out.println();
							break;
					}
					
					break;
				case 2:
					sc.nextLine();
					System.out.println();
					System.out.println("Zadejte název knihy: ");
					String hledani = sc.nextLine();
					boolean nalezeno = false;
					for(Kniha k: seznamVsechKnih)
					{
						if((k.getNazev().equals(hledani)))
						{
							nalezeno = true;
							System.out.println("Nalezena kniha: " +k.toString());
							System.out.println("Chcete ji upravit?");
							if(anoNe(sc))
							{
								System.out.println("Chcete upravit název?");
								if(anoNe(sc))
									System.out.println("Zadejte název: ");
									sc.nextLine();
									k.setNazev(sc.nextLine());
								System.out.println("Chcete upravit autora/y?");
								if(anoNe(sc))
								{
									autori = new ArrayList<>();
									System.out.println("Zadejte počet autorů");
									pocetAutoru = pouzeCelaCisla(sc);
									sc.nextLine();
							        
									for(int i = 0; i<pocetAutoru; i++)
									{
										System.out.println("Zadejte autora " + (i+1));
										autori.add(sc.nextLine());
									}
									k.setAutori(autori);
								}
								System.out.println("Chcete upravit rok vydání?");
								if(anoNe(sc))
									System.out.println("Zadejte rok vydání: ");
									k.setRokVydani(pouzeCelaCisla(sc));
								if(k.isVypujceno())
								{
									System.out.println("Chcete změnit dostupnost z \"vypůjčeno\" na \"k dispozici\"?");
									if(anoNe(sc))
										k.setVypujceno(false);
										
								}
								else
								{
									System.out.println("Chcete změnit dostupnost z \"k dispozici\" na \"vypůjčeno\"?");
									if(anoNe(sc))
										k.setVypujceno(true);
								}
								if(k instanceof Roman)
								{
									System.out.println("Chcete změnit žánr?");
									if(anoNe(sc))
									{
										System.out.println("Zadejte žánr: 1 - detektivní, 2 - scifi, 3 - fantasy, 4 - horor, 5 - realistický");
										do
										{
											volba = pouzeCelaCisla(sc);
											sc.nextLine();
											if(volba != 1 && volba != 2 && volba != 3 && volba != 4 && volba != 5)
												System.out.println("Zadejte platný žánr");
										}while(volba != 1 && volba != 2 && volba != 3 && volba != 4 && volba != 5);
										switch(volba)
										{
										case(1):
											((Roman) k).setZanr(Zanr.detektivní);
											break;
										case(2):
											((Roman) k).setZanr(Zanr.scifi);
											break;
										case(3):
											((Roman) k).setZanr(Zanr.fantasy);
											break;
										case(4):
											((Roman) k).setZanr(Zanr.horor);
											break;
										case(5):
											((Roman) k).setZanr(Zanr.realistický);
											break;
										}
									}
									System.out.println("Nová verze knihy byla uložena: " +((Roman)k).toString());
										
								}
								else if(k instanceof Ucebnice)
								{
									System.out.println("Chcete změnit typ školy?");
									if(anoNe(sc))
									{
										System.out.println("Zadejte školu: 1 - základní, 2 - střední");
										do
										{
											volba = pouzeCelaCisla(sc);
											sc.nextLine();
											if(volba != 1 && volba != 2 )
												System.out.println("Zadejte platnou školu");
										}while(volba != 1 && volba != 2);
										switch(volba)
										{
										case(1):
											((Ucebnice)k).setSkola(Skola.základní);
										break;
										case(2):
											((Ucebnice)k).setSkola(Skola.střední);
										break;
										}
									}
									System.out.println("Chcete změnit ročník?");
									if(anoNe(sc))
									{
										((Ucebnice)k).setRocnik(pouzeCelaCisla(sc));
									}
									System.out.println("Nová verze knihy byla uložena: " +((Ucebnice)k).toString());
								}
							}
							break;
						}
					}
					if(nalezeno == false)
							System.out.println("Kniha s názvem " +hledani+" neexistuje");
					System.out.println();
					break;
				case 3:
					sc.nextLine();
					System.out.println();
					System.out.println("Zadejte název knihy: ");
					hledani = sc.nextLine();
					nalezeno = false;
					boolean smazat = false;
					int idx = 0;
					for(Kniha k: seznamVsechKnih)
					{
						if((k.getNazev().equals(hledani)))
						{
							nalezeno = true;
							System.out.println("Nalezena kniha: " +k.toString());
							System.out.println("Chcete ji smazat?");
							if(anoNe(sc))
							{
								smazat = true;
								idx = seznamVsechKnih.indexOf(k);
							}
							break;
						}
					}
					if(nalezeno == false)
					{
						System.out.println("Kniha s názvem " +hledani+" neexistuje");
						System.out.println();
					}
					if(smazat)
					{
						seznamVsechKnih.remove(idx);
						System.out.println("Kniha smazána");
					}	
					System.out.println();
					break;
				case 4:
					sc.nextLine();
					System.out.println();
					System.out.println("Zadejte název knihy: ");
					hledani = sc.nextLine();
					nalezeno = false;
					boolean zmenit = false;
					idx = 0;
					boolean stav = false;
					for(Kniha k: seznamVsechKnih)
					{
						if((k.getNazev().equals(hledani)))
						{
							nalezeno = true;
							System.out.println("Nalezena kniha: " +k.toString());
								if(k.isVypujceno())
								{
									System.out.println("Chcete změnit její dostupnost z \"vypůjčeno\" na \"k dispozici\"?");
									stav = false;
								}
								else 
								{
									System.out.println("Chcete změnit její dostupnost z \"k dispozici\" na \"vypůjčeno\"?");
									stav = true;
								}
								if(anoNe(sc))
								{
									zmenit = true;
									idx = seznamVsechKnih.indexOf(k);
								}
							break;
						}
					}
					if(nalezeno == false)
					{
						System.out.println("Kniha s názvem " +hledani+" neexistuje");
						System.out.println();
					}
					if(zmenit)
					{
						seznamVsechKnih.get(idx).setVypujceno(stav);
						System.out.println("Dostupnost změněna");
					}					
					break;
				case 5:
					System.out.println();
					System.out.println("1...Výpis všech knih");
					System.out.println("2...Výpis všech knih daného autora");
					System.out.println("3...Výpis všech románů konkrétního žánru");
					System.out.println("4...Výpis všech vypůjčených knih");
					System.out.println("5...Návrat do hlavního menu");
					
					volba=pouzeCelaCisla(sc);
					switch(volba)
					{
						case 1:
							List<Kniha> abecedniSeznam = seznamVsechKnih;
							Collections.sort(abecedniSeznam);
							for(Kniha k: abecedniSeznam)
							{
								System.out.println(k.toString());
							}
							System.out.println();
							break;
						case 2:
							sc.nextLine();
							List<Kniha> seznamDleRoku = seznamVsechKnih;
							Collections.sort(seznamDleRoku, Comparator.comparingInt(Kniha::getRokVydani));
							String hledanyAutor;
							nalezeno = false;
							System.out.println("Zadejte jméno autora:");
							hledanyAutor = sc.nextLine();
							for(Kniha k: seznamDleRoku)
							{
								autori = k.getAutori();
								if(autori.contains(hledanyAutor))
								{
									nalezeno = true;
									System.out.println(k.toString());
								}
							}
							if(nalezeno == false)
							{
								System.out.println("Autor " +hledanyAutor+" nemá v databázi žádné knihy");
							}
							System.out.println();
							break;
						case 3:
							sc.nextLine();
							Zanr zanr = null;
							nalezeno = false;
							abecedniSeznam = seznamVsechKnih;
							Collections.sort(abecedniSeznam);
							System.out.println("Zadejte žánr: 1 - detektivní, 2 - scifi, 3 - fantasy, 4 - horor, 5 - realistický");
							do
							{
								volba = pouzeCelaCisla(sc);
								sc.nextLine();
								if(volba != 1 && volba != 2 && volba != 3 && volba != 4 && volba != 5)
									System.out.println("Zadejte platný žánr");
							}while(volba != 1 && volba != 2 && volba != 3 && volba != 4 && volba != 5);
							switch(volba)
							{
							case(1):
								zanr = Zanr.detektivní;
								break;
							case(2):
								zanr = Zanr.scifi;
								break;
							case(3):
								zanr = Zanr.fantasy;
								break;
							case(4):
								zanr = Zanr.horor;
								break;
							case(5):
								zanr = Zanr.realistický;
								break;
							}
							for(Kniha k: abecedniSeznam)
							{
								if(k instanceof Roman) 
								{
									if(((Roman)k).getZanr() == zanr)
									{
										nalezeno = true;
										System.out.println(k.toString());
									}
								}
							}
							if(nalezeno == false)
							{
								System.out.println("V databázi není žádná kniha se zadaným žánrem");
							}
							System.out.println();
							break;
						case 4:
							abecedniSeznam = seznamVsechKnih;
							Collections.sort(abecedniSeznam);
							nalezeno = false;
							for(Kniha k: abecedniSeznam)
							{
								if(k.isVypujceno())
								{
									nalezeno = true;
									System.out.println(k.toString());
								}
							}
							if(nalezeno == false)
							{
								System.out.println("V databázi není žádná vypůjčená kniha");
							}
							System.out.println();
							break;
						case 5:
							break;
					}
					break;
				case 6:
					sc.nextLine();
					System.out.println("Zadejte název knihy:");
					hledani = sc.nextLine();
					nalezeno = false;
					for(Kniha k: seznamVsechKnih)
					{
						
						if((k.getNazev().equals(hledani)))
						{
							nalezeno = true;
							System.out.println("Nalezena kniha: " +k.toString());
							break;
						}
					}
					if(nalezeno == false)
					{
						System.out.println("V databázi není žádná kniha s názvem: " +hledani);
					}
					System.out.println();
					break;
				case 7:
					sc.nextLine();
					System.out.println("Zadejte název knihy, kterou chcete uložit do souboru: ");
					hledani = sc.nextLine();
					nalezeno = false;
					boolean ulozit = false;
					idx = 0;
					String filePath = "";
					for(Kniha k: seznamVsechKnih)
					{
						
						if((k.getNazev().equals(hledani)))
						{
							nalezeno = true;
							System.out.println("Nalezena kniha: " +k.toString());
							System.out.println("Chcete ji uložit?");
							if(anoNe(sc))
							{
								ulozit = true;
								idx = seznamVsechKnih.indexOf(k);
								sc.nextLine();
								System.out.println("Zadejte adresu, kam chcete soubor uložit");
								filePath = sc.nextLine();
							}
							break;
						}
					}
					if(ulozit = true)
					{
						Kniha k = seznamVsechKnih.get(idx);
						File ulozenaKniha = new File(filePath + "\\" + k.getNazev() + ".txt");
						FileWriter fw = null;
						try {
							fw = new FileWriter(ulozenaKniha);
							if(k instanceof Roman)
							{
								if(k.isVypujceno())
									fw.write("1;" + k.getNazev() + ";" + k.vypisAutoru(k.getAutori()) + ";" + k.getRokVydani() + ";" + ((Roman)k).getZanr().toString() + ";" + 1);
								else 
									fw.write("1;" + k.getNazev() + ";" + k.vypisAutoru(k.getAutori()) + ";" + k.getRokVydani() + ";" + ((Roman)k).getZanr().toString() + ";" + 0);
								System.out.println("Kniha uložena na adresu: " + filePath + "\\" + k.getNazev() + ".txt");
							}
							else if (k instanceof Ucebnice)
							{
								if(k.isVypujceno())
									fw.write("2;" + k.getNazev() + ";" + k.vypisAutoru(k.getAutori()) + ";" + k.getRokVydani() + ";" + ((Ucebnice)k).getSkola().toString() + ";" + ((Ucebnice)k).getRocnik() + ";"+ 1);
								else 
									fw.write("2;" + k.getNazev() + ";" + k.vypisAutoru(k.getAutori()) + ";" + k.getRokVydani() + ";" + ((Ucebnice)k).getSkola().toString() + ";" + ((Ucebnice)k).getRocnik() + ";"+ 0);
								System.out.println("Kniha uložena na adresu: " + filePath + "\\" + k.getNazev() + ".txt");
							}
							else
								System.out.println("Doslo k chybě");
								
							}
						catch (IOException e) {
							System.out.println("Soubor " + filePath + "\\" + k.getNazev() + ".txt"  + "nelze otevřít");
							} 
						finally { 
							try {
								fw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					
					if(nalezeno == false)
					{
						System.out.println("V databázi není žádná kniha s názvem: " +hledani);
					}
					System.out.println();
					System.out.println();
					break;
				case 8:
					sc.nextLine();
					System.out.println("Zadejte adresu souboru");
					filePath = sc.nextLine();
					FileReader fr = null;
					BufferedReader br = null;
					String ulozenaKniha = "";
					try {
						fr = new FileReader(filePath);
						br = new BufferedReader(fr);
						do{
							ulozenaKniha = br.readLine();
						}while (br.readLine() != null);
						}
						catch (IOException e) {
						System.out.println("Soubor " + filePath + "nelze otevřít");
						} finally { 
							try {
								fr.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					String[] ulozenaKnihaArray = ulozenaKniha.split(";");
					typ = Integer.parseInt(ulozenaKnihaArray[0]);
					nazev = ulozenaKnihaArray[1];
					String autoriString = ulozenaKnihaArray[2];
					String [] autoriArray = autoriString.split(",");
					autori = new ArrayList<>();
					for(int i = 0; i < autoriArray.length; i++)
					{
					autori.add(autoriArray[i]);
					}
					rokVydani = Integer.parseInt(ulozenaKnihaArray[3]);
					if(typ == 1)
					{
						String zanrS = ulozenaKnihaArray[4];
						Zanr zanr = null;
						switch(zanrS)
						{
						case("detektivní"):
							zanr = Zanr.detektivní;
							break;
						case("scifi"):
							zanr = Zanr.scifi;
							break;
						case("fantasy"):
							zanr = Zanr.fantasy;
							break;
						case("horor"):
							zanr = Zanr.horor;
							break;
						case("realistický"):
							zanr = Zanr.realistický;
							break;
						}
						int vypujcenoInt = Integer.parseInt(ulozenaKnihaArray[5]);
						
						if(vypujcenoInt == 1)
						{
							seznamVsechKnih.add(new Roman(nazev, autori, rokVydani, true, zanr));
							System.out.println("Kniha uložena do databáze");
						}
						else
						{
							seznamVsechKnih.add(new Roman(nazev, autori, rokVydani, false, zanr));
							System.out.println("Kniha uložena do databáze");
						}
					}
					else if(typ == 2)
					{
						String skolaS = ulozenaKnihaArray[4];
						Skola skola = null;
						switch(skolaS)
						{
						case("základní"):
							skola = Skola.základní;
						break;
						case("střední"):
							skola = Skola.střední;
						break;
						}
						int rocnik = Integer.parseInt(ulozenaKnihaArray[5]);
						int vypujcenoInt = Integer.parseInt(ulozenaKnihaArray[6]);
						if(vypujcenoInt == 1)
						{
							seznamVsechKnih.add(new Ucebnice(nazev, autori, rokVydani, true, skola, rocnik));
							System.out.println("Kniha uložena do databáze");
						}
						else
						{
							seznamVsechKnih.add(new Ucebnice(nazev, autori, rokVydani, false, skola, rocnik));
							System.out.println("Kniha uložena do databáze");
						}
					}
					else 
						System.out.println("Došlo k chybě");
					System.out.println();
					break;
				case 9:
					run = false;
					break;
					
//zde kód pro pracovní přidání knih
				case 10:
					seznamVsechKnih.add(new Roman("1984", new ArrayList<String>() {{add("George Orwell");}}, 1948, true, Zanr.realistický));
					seznamVsechKnih.add(new Roman("Zločin a Trest", new ArrayList<String>() {{add("Fjodor Michajlovič Dostojevskij");}}, 1866, false, Zanr.realistický));
					seznamVsechKnih.add(new Roman("Pán Prstenů", new ArrayList<String>() {{add("J.R.R. Tolkien");}}, 1954, true, Zanr.fantasy));
					seznamVsechKnih.add(new Roman("Duna", new ArrayList<String>() {{add("Frank Herbert");}}, 1965, false, Zanr.scifi));
					seznamVsechKnih.add(new Roman("Drakula", new ArrayList<String>() {{add("Bram Stoker");}}, 1897, false, Zanr.horor));
					seznamVsechKnih.add(new Ucebnice("Český Jazyk", new ArrayList<String>() {{add("George Orwell"); add("Ondřej Pernica");}}, 2016, false, Skola.základní, 9));
					seznamVsechKnih.add(new Ucebnice("Matematika", new ArrayList<String>() {{add("Oleg Bramborslav"); add("Adéla Dokoupilová");}}, 1999, true, Skola.střední, 3));
					seznamVsechKnih.add(new Ucebnice("Fyzika", new ArrayList<String>() {{add("Josef Sedlák"); add("Marsela Ledecká"); add("Bořivoj Adam"); add("Jakub Kalina");}}, 2023, false, Skola.střední, 7));
					seznamVsechKnih.add(new Ucebnice("Chemie", new ArrayList<String>() {{add("Kryštof Matuška"); add("Adamko"); add("George Orwell");}}, 2009, true, Skola.základní, 8));
					seznamVsechKnih.add(new Ucebnice("Prvouka", new ArrayList<String>() {{add("Štepán Kučera");}}, 2024, false, Skola.základní, 3));
					break;
			}
		}
	}
}
