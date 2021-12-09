package Aplikacja.Model.Magazyn;

public class Produkt {

	protected String nazwa;
	protected int liczba;
	protected float cena;
	protected String kategoriaPodatkowa;

	/**
	 *
	 * @param nazwa
	 * @param liczba
	 * @param cena
	 * @param kategoriaPodatkowa
	 */
	public Produkt(String nazwa, int liczba, float cena, String kategoriaPodatkowa) {
		this.nazwa = nazwa;
		this.liczba = liczba;
		this.cena = cena;
		this.kategoriaPodatkowa = kategoriaPodatkowa;
	}

	public void zmienCene(float nowaCena) {
		this.cena = nowaCena;
	}

	/**
	 *
	 * @param ilosc
	 */
	public void zwiekszIlosc(int ilosc) {
		this.liczba += ilosc;
	}

	/**
	 *
	 * @param ilosc
	 */
	public void zmniejszIlosc(int ilosc) {
		this.liczba -= ilosc;
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

	@Override
	public String toString() {
		return "Produkt{" +
				"nazwa='" + nazwa + '\'' +
				", liczba=" + liczba +
				", cena=" + cena +
				", kategoriaPodatkowa='" + kategoriaPodatkowa + '\'' +
				'}';
	}
}