package Aplikacja.Model.Magazyn;

import java.util.*;

public class Magazyn {

	private Collection<Produkt> produkty = new ArrayList<>();

	public Produkt getProdukty() {
		return (Produkt) this.produkty;
	}

	/**
	 *
	 * @param produkty
	 */
	public void setProdukty(Produkt produkty) {
		this.produkty = (Collection<Produkt>) produkty;
	}

	/**
	 *
	 * @param produkt
	 */
	public void dodajProdukt(Produkt produkt) {
		// TODO - implement Magazyn.dodajProdukt
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nazwa
	 */
	public void usunProdukt(String nazwa) {
		// TODO - implement Magazyn.usunProdukt
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nazwa
	 */
	public Produkt znadzProdukt(String nazwa) {
		// TODO - implement Magazyn.znadzProdukt
		throw new UnsupportedOperationException();
	}

	public Magazyn() {}

}