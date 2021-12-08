package Aplikacja.Model.Magazyn;

public class Produkt {

	protected String nazwa;
	protected int liczba;
	protected float cena;
	protected String kategoriaPodatkowa;


	public void zmienCene(float nowaCena) {
		// TODO - implement Produkt.zmienCene
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param ilosc
	 */
	public void zwiekszIlosc(int ilosc) {
		// TODO - implement Produkt.zwiekszIlosc
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param ilosc
	 */
	public void zmniejszIlosc(int ilosc) {
		// TODO - implement Produkt.zmniejszIlosc
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nazwa
	 * @param liczba
	 * @param cena
	 * @param kategoriaPodatkowa
	 */
	public Produkt(String nazwa, int liczba, float cena, String kategoriaPodatkowa) {
		// TODO - implement Produkt.Produkt
		throw new UnsupportedOperationException();
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public int getLiczba() {
		return this.liczba;
	}

	public float getCena() {
		return this.cena;
	}

	public String getKategoriaPodatkowa() {
		return this.kategoriaPodatkowa;
	}

}