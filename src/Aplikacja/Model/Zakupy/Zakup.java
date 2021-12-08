package Aplikacja.Model.Zakupy;

import Aplikacja.Model.Magazyn.*;

public class Zakup extends Produkt {

	Rabat rabat;

	public void setRabat(Rabat rabat) {
		this.rabat = rabat;
	}

	public Rabat getRabat() {
		return this.rabat;
	}

	public Zakup(Produkt produkt, int liczba) {
		super(produkt.getNazwa(), liczba, produkt.getCena(), produkt.getKategoriaPodatkowa());}

}