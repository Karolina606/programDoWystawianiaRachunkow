package Aplikacja.Model.Zakupy;

import Aplikacja.Model.Magazyn.*;

public class Zakup extends Produkt {

	Rabat rabat;

	public Zakup(Produkt produkt, int liczba, Rabat rabat) {
		super(produkt.getNazwa(), liczba, produkt.getCena(), produkt.getKategoriaPodatkowa());
		this.rabat = rabat;
	}

	public void setRabat(Rabat rabat) {
		this.rabat = rabat;
	}

	public Rabat getRabat() {
		return this.rabat;
	}

	@Override
	public String toString() {
		if (rabat != null){
			return "Zakup{" +
					"nazwa='" + nazwa + '\'' +
					", liczba=" + liczba +
					", cena=" + cena +
					", kategoriaPodatkowa='" + kategoriaPodatkowa +
					", rabat=" + rabat.getWartoscRabatu()  + '\'' +
					'}';
		}else{
			return "Zakup{" +
					"nazwa='" + nazwa + '\'' +
					", liczba=" + liczba +
					", cena=" + cena +
					", kategoriaPodatkowa='" + kategoriaPodatkowa + '\'';
		}

	}
}