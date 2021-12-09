package Aplikacja.Model.Magazyn;

import java.util.ArrayList;
import java.util.List;

public class Rabat {

	private int id_rabatu;
	private static int licznikRabatow = 0;
	private float wartoscRabatu;
	private List<String> listaNazwProduktowZRabatem = new ArrayList<>();


	/**
	 *
	 * @param wartosc
	 * @param nazwyProduktow
	 */
	public Rabat(float wartosc, List<String> nazwyProduktow) {
		this.wartoscRabatu = wartosc;
		this.listaNazwProduktowZRabatem = nazwyProduktow;
		this.id_rabatu = licznikRabatow;
		licznikRabatow += 1;
	}

	public int getId_rabatu() {
		return id_rabatu;
	}

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

	@Override
	public String toString() {
		return "Rabat{" +
				"id_rabatu=" + id_rabatu +
				", wartoscRabatu=" + wartoscRabatu +
				", listaNazwProduktowZRabatem=" + listaNazwProduktowZRabatem +
				'}';
	}
}