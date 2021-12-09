package Aplikacja.Model.Magazyn;

import java.util.*;

public class Magazyn {

	private Collection<Produkt> produkty = new ArrayList<>();

	public List<Produkt> getProdukty() {
		return (List<Produkt>) this.produkty;
	}


	public Magazyn() {}

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
		produkty.add(produkt);
	}

	/**
	 *
	 * @param nazwa
	 */
	public void usunProdukt(String nazwa) {
		for(Produkt produkt: produkty){
			if (produkt.getNazwa().equals(nazwa)){
				produkty.remove(produkt);
			}
		}
	}

	/**
	 *
	 * @param nazwa
	 */
	public Produkt znadzProdukt(String nazwa) {
		Produkt znalezionyProdukt = null;
		for(Produkt produkt: produkty){
			if (produkt.getNazwa().equals(nazwa)){
				znalezionyProdukt = produkt;
			}
		}
		return znalezionyProdukt;
	}
}