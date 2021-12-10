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
	 */
	public void dodajProdukt(Produkt produktDoDodania) {
		for(Produkt produkt: produkty){
			if (produkt.getNazwa().equals(produktDoDodania.getNazwa())){
				produkt.zwiekszIlosc(produktDoDodania.getLiczba());
				return;
			}
		}
		produkty.add(produktDoDodania);
	}

	/**
	 *
	 * @param nazwa
	 */
	public void usunProdukt(String nazwa) {
		for(Produkt produkt: produkty){
			if (produkt.getNazwa().equals(nazwa)){
				produkty.remove(produkt);
				break;
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