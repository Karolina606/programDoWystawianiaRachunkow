package Aplikacja.Model.Zakupy;

import java.util.*;
import Aplikacja.Model.Magazyn.*;

public class Rachunek {

	protected int rachunekId;
	private static int licznikRachunkow = 0;
	private List<Zakup> koszyk = new ArrayList<>();
	private int sumaRachunku = 0;
	private int sumaRabatu= 0;
	private DaneDostawy daneDostawy;

	public void zwiekszIloscZakupu(Produkt produkt, int ilosc) {}

	public Rachunek() {
		rachunekId = licznikRachunkow;
		licznikRachunkow += 1;
	}

	/**
	 *
	 * @param produkt
	 * @param ilosc
	 */
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

	/**
	 *
	 * @param dane
	 */
	public void wystaw(DaneDostawy dane) {
		// TODO - implement Rachunek.wystaw
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param produnkt
	 */
	public boolean czyProduktNaRachunku(Produkt produnkt) {
		for(Zakup zakup: koszyk){
			if (zakup.getNazwa() == produnkt.getNazwa()){
				return true;
			}
		}
		return false;
	}

	public List<Zakup> getKoszyk() {
		return koszyk;
	}
}