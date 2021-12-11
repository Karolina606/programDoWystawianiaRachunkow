package Aplikacja.Model.Magazyn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rabat implements Serializable {

	private int rabatId;
	private static int licznikRabatow = 0;
	private float wartoscRabatu;
	private List<String> listaNazwProduktowZRabatem = new ArrayList<>();


	public Rabat(float wartosc, List<String> nazwyProduktow) {
		this.wartoscRabatu = wartosc;
		this.listaNazwProduktowZRabatem = nazwyProduktow;
		this.rabatId = licznikRabatow;
		licznikRabatow += 1;
	}

	public int getRabatId() {
		return rabatId;
	}

	public float getWartoscRabatu() {
		return this.wartoscRabatu;
	}

	public void setWartoscRabatu(float wartoscRabatu) {
		this.wartoscRabatu = wartoscRabatu;
	}

	public List<String> getListaNazwProduktowZRabatem() {
		return this.listaNazwProduktowZRabatem;
	}

	public void setListaNazwProduktowZRabatem(List<String> listaNazwProduktowZRabatem) {
		this.listaNazwProduktowZRabatem = listaNazwProduktowZRabatem;
	}

	public boolean sprawdzCzyProduktMaRabat(Produkt produkt){
		if(listaNazwProduktowZRabatem.contains(produkt.getNazwa())){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Rabat{" +
				"id_rabatu=" + rabatId +
				", wartoscRabatu=" + wartoscRabatu +
				", listaNazwProduktowZRabatem=" + listaNazwProduktowZRabatem +
				'}';
	}
}