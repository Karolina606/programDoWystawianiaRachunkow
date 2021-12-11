package Aplikacja.Model.Zakupy;

import java.io.Serializable;

public class DaneDostawy implements Serializable {

	public String imie;
	public String nazwisko;
	public String miejscowosc;
	public String kodPocztowy;
	public String ulica;
	public String nrDomu;
	public String nrMieszkania;
	public String nrTelefonu;

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

	@Override
	public String toString() {
		return imie + " " + nazwisko + "\n"
				+ miejscowosc + ", " + kodPocztowy + "\n"
				+ ulica + " " + nrDomu + " " + nrMieszkania + "\n"
				+ nrTelefonu + "\n";
	}
}