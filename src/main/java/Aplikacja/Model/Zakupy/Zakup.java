package Aplikacja.Model.Zakupy;


import Aplikacja.Model.Magazyn.Produkt;
import Aplikacja.Model.Magazyn.Rabat;

public class Zakup extends Produkt {

	private Rabat rabat;

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

	public float obliczWartoscZakupuZPodatkiem(){
		return this.getCena() * this.getLiczba();
	}

	public float obliczWartoscZakupuOdjacRabat(){
		return this.getCena() * this.getLiczba() - this.getRabat().getWartoscRabatu() * this.liczba;
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