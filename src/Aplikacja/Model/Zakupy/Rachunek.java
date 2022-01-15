package Aplikacja.Model.Zakupy;

import java.io.Serializable;
import java.util.*;
import Aplikacja.Model.Magazyn.*;

public class Rachunek implements Serializable {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";


	protected int rachunekId;
	private static int licznikRachunkow = 0;
	private List<Zakup> koszyk = new ArrayList<>();
	private float sumaRachunku = 0;
	private float sumaRabatu = 0;
	private DaneDostawy daneDostawy;

	public Rachunek() {
		licznikRachunkow += 1;
		rachunekId = licznikRachunkow;
	}

	public int getRachunekId() {
		return rachunekId;
	}

	public void zwiekszIloscZakupu(Produkt produkt, int ilosc) {
		produkt.zwiekszIlosc(ilosc);
	}

	public void dodajZakup(Produkt produkt, int ilosc, Rabat rabat) {
		Zakup nowyZakup = new Zakup(produkt, ilosc, rabat);

		this.koszyk.add(nowyZakup);
	}

	public void policzSume() {
		for(Zakup zakup: koszyk){
			sumaRachunku += zakup.getCena() * zakup.getLiczba();
			if (zakup.getRabat() != null){
				sumaRabatu += zakup.getRabat().getWartoscRabatu() * zakup.getLiczba();
			}
		}
	}

	public void wystaw(DaneDostawy dane) {
		this.daneDostawy = dane;
		float podatekA = 0;
		float podatekB = 0;
		float podatekC = 0;
		float podatekD = 0;
		float wartoscRabatu;
		float wartoscZakupu;
		String wystawionyRachunek = "########################### RACHUNEK ###########################\n";
		wystawionyRachunek += "Sklep sportowy \"Hops\" sp. z o.o.\n" +
				"Prusicka 15\n" +
				"00-100 Wroclaw\n" +
				"\n";
		wystawionyRachunek += "Wystawiony na: \n";
		wystawionyRachunek += dane.toString() + "\n";

		// Obliczen
		for(Zakup zakup: koszyk){
			wartoscRabatu = 0;

			wartoscZakupu = zakup.getCena() * zakup.getLiczba();
			if (zakup.getRabat() != null){
				wartoscRabatu = zakup.getRabat().getWartoscRabatu() * zakup.getLiczba();
				sumaRabatu += wartoscRabatu;
			}
			sumaRachunku += wartoscZakupu;


			switch(zakup.getKategoriaPodatkowa()){
				case "A":
					podatekA += (wartoscZakupu - wartoscRabatu) * 0.22;
					break;
				case "B":
					podatekB += (wartoscZakupu - wartoscRabatu) * 0.7;
					break;
				case "C":
					podatekC += (wartoscZakupu - wartoscRabatu) * 0.5;
					break;
				case "D":
					podatekD += (wartoscZakupu - wartoscRabatu) * 0.3;
					break;
			}
			wystawionyRachunek += String.format("%-30s  %10d * %-15.2f %-10s \n", zakup.getNazwa(), zakup.getLiczba(), zakup.getCena(),
					zakup.getKategoriaPodatkowa());
			if(zakup.getRabat() != null){
				wystawionyRachunek += String.format( ANSI_RED + "%-40s  -%-10.2f" + ANSI_RESET + "\n", "Rabat", wartoscRabatu);
			}
		}

		wystawionyRachunek += "\n";
		wystawionyRachunek += String.format("Sp.op.A %-30.2f PTU A = 22.00 \n", podatekA );
		wystawionyRachunek += String.format("Sp.op.B %-30.2f PTU B = 7.00 \n", podatekB );
		wystawionyRachunek += String.format("Sp.op.C %-30.2f PTU C = 5.00 \n", podatekC );
		wystawionyRachunek += String.format("Sp.op.D %-30.2f PTU D = 3.00 \n", podatekD );
		wystawionyRachunek += String.format("Razem %40.2f \n", sumaRachunku-sumaRabatu );

		wystawionyRachunek += "################################################################\n";

		System.out.println(wystawionyRachunek);
	}

	public boolean czyProduktNaRachunku(Produkt produnkt) {
		for(Zakup zakup: koszyk){
			if (zakup.getNazwa() == produnkt.getNazwa()){
				return true;
			}
		}
		return false;
	}

	public static void ustawLicznikRachunkow(int nowyLicznik){
		licznikRachunkow = nowyLicznik;
	}

	public List<Zakup> getKoszyk() {
		return koszyk;
	}

	@Override
	public String toString() {
		return "Rachunek{" +
				", koszyk=" + koszyk +
				", sumaRachunku=" + sumaRachunku +
				", sumaRabatu=" + sumaRabatu +
				", daneDostawy=" + daneDostawy +
				'}';
	}

	public float getSumaRachunku() {
		return sumaRachunku;
	}

	public float getSumaRabatu() {
		return sumaRabatu;
	}
}