package Aplikacja.Model.Zakupy;

import java.util.*;
import Aplikacja.Model.Magazyn.*;

public class Rachunek {

	protected int id_rachunku;
	private static int licznikRachunkow;
	private Collection<Zakup> koszyk = new ArrayList<>();
	private int sumaRachunku;
	private DaneDostawy daneDostawy;

	public void zwiekszIloscZakupu(Produkt produkt, int ilosc) {}

	/**
	 *
	 * @param produkt
	 * @param ilosc
	 */
	public void dodajZakup(Produkt produkt, int ilosc) {
		// TODO - implement Rachunek.dodajZakup
		throw new UnsupportedOperationException();
	}

	public void policzSume() {
		// TODO - implement Rachunek.policzSume
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param dane
	 */
	public void wystaw(DaneDostawy dane) {
		// TODO - implement Rachunek.wystaw
		throw new UnsupportedOperationException();
	}

	public Rachunek() {
		// TODO - implement Rachunek.Rachunek
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param produnkt
	 */
	public boolean czyProduktNaRachunku(Produkt produnkt) {
		// TODO - implement Rachunek.czyProduktNaRachunku
		throw new UnsupportedOperationException();
	}

}