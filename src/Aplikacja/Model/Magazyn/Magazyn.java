package Aplikacja.Model.Magazyn;

import Aplikacja.Model.Zakupy.Rachunek;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Magazyn implements Serializable {

	private List<Produkt> produkty = new ArrayList<>();

	public List<Produkt> getProdukty() {
		return (List<Produkt>) this.produkty;
	}


	public Magazyn() {}

	public void setProdukty(ArrayList<Produkt> produkty) {
		this.produkty = produkty;
	}

	public void dodajProdukt(Produkt produktDoDodania) {
		for(Produkt produkt: produkty){
			if (produkt.getNazwa().equals(produktDoDodania.getNazwa())){
				produkt.zwiekszIlosc(produktDoDodania.getLiczba());
				return;
			}
		}
		produkty.add(produktDoDodania);
	}

	public void usunProdukt(String nazwa) {
		for(Produkt produkt: produkty){
			if (produkt.getNazwa().equals(nazwa)){
				produkty.remove(produkt);
				break;
			}
		}
	}

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