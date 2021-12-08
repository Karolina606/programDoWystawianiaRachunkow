package Aplikacja;

import Aplikacja.Model.Magazyn.*;
import java.util.*;
import Aplikacja.Model.Zakupy.*;

public class Aplikacja {

	private Magazyn magazyn;
	private Collection<Rabat> rabaty = new ArrayList<>();
	private Collection<Rachunek> rachunki = new ArrayList<>();
	private boolean czyKoniecZakupow;

	public Rachunek utworzNowyRachunek() {
		// TODO - implement Aplikacja.utworzNowyRachunek
		throw new UnsupportedOperationException();
	}

	public void pokazProdukty() {
		// TODO - implement Aplikacja.pokazProdukty
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nazwa
	 */
	public void wybierzProdukt(String nazwa) {
		// TODO - implement Aplikacja.wybierzProdukt
		throw new UnsupportedOperationException();
	}

	public void potwierdzZakup() {
		// TODO - implement Aplikacja.potwierdzZakup
		throw new UnsupportedOperationException();
	}

	private DaneDostawy podajDaneDostawy() {
		// TODO - implement Aplikacja.podajDaneDostawy
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param rachunek
	 * @param daneDostawy
	 */
	private void wystawRachunek(Rachunek rachunek, DaneDostawy daneDostawy) {
		// TODO - implement Aplikacja.wystawRachunek
		throw new UnsupportedOperationException();
	}

	public void zarzadzaj() {
		// TODO - implement Aplikacja.zarzadzaj
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param nazwa
	 * @param liczba
	 * @param cena
	 */
	public void dodajProdukt(String nazwa, int liczba, float cena) {
		// TODO - implement Aplikacja.dodajProdukt
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nazwa
	 */
	public void usunProdukt(String nazwa) {
		// TODO - implement Aplikacja.usunProdukt
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nazwa
	 * @param nowaCena
	 */
	public void zmienCene(String nazwa, float nowaCena) {
		// TODO - implement Aplikacja.zmienCene
		throw new UnsupportedOperationException();
	}

	public void pokazRabaty() {
		// TODO - implement Aplikacja.pokazRabaty
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param wartosc
	 * @param nazwyProduktowZRabatem
	 */
	public void dodajRabat(float wartosc, List<String> nazwyProduktowZRabatem) {
		// TODO - implement Aplikacja.dodajRabat
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param id_rabatu
	 */
	public void usunRabat(int id_rabatu) {
		// TODO - implement Aplikacja.usunRabat
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO - implement Aplikacja.main
		throw new UnsupportedOperationException();
	}

	public String wybierzCzynnosc() {
		// TODO - implement Aplikacja.wybierzCzynnosc
		throw new UnsupportedOperationException();
	}

	public void rozpocznijZakupy() {
		// TODO - implement Aplikacja.rozpocznijZakupy
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param rachunek
	 * @param produkt
	 */
	public boolean czyProduktNaRachunku(Rachunek rachunek, Produkt produkt) {
		// TODO - implement Aplikacja.czyProduktNaRachunku
		throw new UnsupportedOperationException();
	}

	public int podajIlosc() {
		// TODO - implement Aplikacja.podajIlosc
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param ilosc
	 */
	public boolean sprawdzCzyIloscJestDostępna(int ilosc) {
		// TODO - implement Aplikacja.sprawdzCzyIloscJestDostępna
		throw new UnsupportedOperationException();
	}

	public void poinformujBrak() {
		// TODO - implement Aplikacja.poinformujBrak
		throw new UnsupportedOperationException();
	}

	public boolean zapytajCzyKoniecZakupow() {
		// TODO - implement Aplikacja.zapytajCzyKoniecZakupow
		throw new UnsupportedOperationException();
	}

}