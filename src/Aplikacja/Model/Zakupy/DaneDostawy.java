package Aplikacja.Model.Zakupy;

public class DaneDostawy {

	public String imie;
	public String nazwisko;
	public String miejscowosc;
	public String kodPocztowy;
	public String ulica;
	public String nrDomu;
	public String nrMieszkania;
	public String nrTelefonu;

	/**
	 *  @param imie
	 * @param nazwisko
	 * @param miejscowosc
	 * @param kod_pocztowy
	 * @param ulica
	 * @param nrDomu
	 */
	public DaneDostawy(String imie, String nazwisko, String miejscowosc, String kod_pocztowy, String ulica, String nrDomu, String nrMieszkania, String nrTelefonu) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.miejscowosc = miejscowosc;
		this.kodPocztowy = kod_pocztowy;
		this.ulica = ulica;
		this.nrDomu = nrDomu;
		this.nrMieszkania = nrMieszkania;
		this.nrTelefonu = nrTelefonu;
	}

}