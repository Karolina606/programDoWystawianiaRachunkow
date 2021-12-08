package Aplikacja.Model.Magazyn;

import java.util.ArrayList;
import java.util.List;

public class Rabat {

	private int id_rabatu;
	private static int licznikRabatow;
	private float wartoscRabatu;
	private List<String> listaNazwProduktowZRabatem = new ArrayList<>();

	public float getWartoscRabatu() {
		return this.wartoscRabatu;
	}

	/**
	 *
	 * @param wartoscRabatu
	 */
	public void setWartoscRabatu(float wartoscRabatu) {
		this.wartoscRabatu = wartoscRabatu;
	}

	public List<String> getListaNazwProduktowZRabatem() {
		return this.listaNazwProduktowZRabatem;
	}

	/**
	 *
	 * @param listaNazwProduktowZRabatem
	 */
	public void setListaNazwProduktowZRabatem(List<String> listaNazwProduktowZRabatem) {
		this.listaNazwProduktowZRabatem = listaNazwProduktowZRabatem;
	}

	/**
	 *
	 * @param wartosc
	 * @param nazwyProduktow
	 */
	public Rabat(float wartosc, List<String> nazwyProduktow) {
		// TODO - implement Rabat.Rabat
		throw new UnsupportedOperationException();
	}

}