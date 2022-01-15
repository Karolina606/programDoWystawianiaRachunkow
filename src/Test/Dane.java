package Test;

import Aplikacja.Model.Magazyn.Magazyn;
import Aplikacja.Model.Magazyn.Produkt;
import Aplikacja.Model.Zakupy.Rachunek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dane {


	// ######################################################## DANE TEST PRODUKT ########################################################

	public String nazwyProduktow[] =
	{
			"Pilka tenisowa",
			"Pilka do koszykowki",
			"Pilka nozna",
			"Pilka siatkowa",
			"Stroj kapielowy damski",
			"Kapielowki meskie",
			"Baton bialkowy",
			"Guma do zucia"
	};

	public Float cenyProduktow[] =
			{
					5.99F,
					29.99F,
					59.99F,
					39.99F,
					79.99F,
					39.99F,
					3.99F,
					2.99F,
					1.99F
			};

	public String katPodatkowa[] = {
		"A",
		"B",
		"C",
		"D"
	};

	public Produkt produkty[] = {
		new Produkt(nazwyProduktow[0], 30, cenyProduktow[0], katPodatkowa[0]),
		new Produkt(nazwyProduktow[1], 12, cenyProduktow[1], katPodatkowa[0]),
		new Produkt(nazwyProduktow[2], 15, cenyProduktow[2], katPodatkowa[0]),
		new Produkt(nazwyProduktow[3], 20, cenyProduktow[3], katPodatkowa[0]),

		new Produkt(nazwyProduktow[4], 20, cenyProduktow[4], katPodatkowa[3]),
		new Produkt(nazwyProduktow[5], 24, cenyProduktow[5], katPodatkowa[2]),

		new Produkt(nazwyProduktow[6], 100, cenyProduktow[6], katPodatkowa[1]),
		new Produkt(nazwyProduktow[7], 56, cenyProduktow[7], katPodatkowa[1]),
	};

	public String opisyProduktow[] = {
			"Produkt{" +
					"nazwa='" + nazwyProduktow[0] + '\'' +
					", liczba=" + 30 +
					", cena=" + cenyProduktow[0] +
					", kategoriaPodatkowa='" + katPodatkowa[0] + '\'' +
					'}',
			"Produkt{" +
					"nazwa='" + nazwyProduktow[1] + '\'' +
					", liczba=" + 12 +
					", cena=" + cenyProduktow[1] +
					", kategoriaPodatkowa='" + katPodatkowa[0] + '\'' +
					'}',
			"Produkt{" +
					"nazwa='" + nazwyProduktow[2] + '\'' +
					", liczba=" + 15 +
					", cena=" + cenyProduktow[2] +
					", kategoriaPodatkowa='" + katPodatkowa[0] + '\'' +
					'}',
			"Produkt{" +
					"nazwa='" + nazwyProduktow[3] + '\'' +
					", liczba=" + 20 +
					", cena=" + cenyProduktow[3] +
					", kategoriaPodatkowa='" + katPodatkowa[0] + '\'' +
					'}',
			"Produkt{" +
					"nazwa='" + nazwyProduktow[4] + '\'' +
					", liczba=" + 20 +
					", cena=" + cenyProduktow[4] +
					", kategoriaPodatkowa='" + katPodatkowa[3] + '\'' +
					'}',
			"Produkt{" +
					"nazwa='" + nazwyProduktow[5] + '\'' +
					", liczba=" + 24 +
					", cena=" + cenyProduktow[5] +
					", kategoriaPodatkowa='" + katPodatkowa[2] + '\'' +
					'}',
			"Produkt{" +
					"nazwa='" + nazwyProduktow[6] + '\'' +
					", liczba=" + 100 +
					", cena=" + cenyProduktow[6] +
					", kategoriaPodatkowa='" + katPodatkowa[1] + '\'' +
					'}',
			"Produkt{" +
					"nazwa='" + nazwyProduktow[7] + '\'' +
					", liczba=" + 56 +
					", cena=" + cenyProduktow[7] +
					", kategoriaPodatkowa='" + katPodatkowa[1] + '\'' +
					'}'
	};

	public Integer iloscProduktowDoDodania[] = {
			10, 6, 12, 30, 45, 11, 9, 21
	};

	public Integer iloscProduktowPoDodaniu[] = {
			40, 18, 27, 50, 65, 35, 109, 77
	};


	// ######################################################## DANE TEST MAGAZYN ########################################################

	// Deklaracje magazynów
	public Magazyn magazyny[] = {
			new Magazyn(), new Magazyn(), new Magazyn(), new Magazyn()
	};

	public void setMagazyny(){
		magazyny[0].setProdukty(new ArrayList<>(Arrays.asList(produkty[0], produkty[1])));
		magazyny[1].setProdukty(new ArrayList<>(Arrays.asList(produkty[2], produkty[3])));
		magazyny[2].setProdukty(new ArrayList<>(Arrays.asList(produkty[4], produkty[5])));
		magazyny[3].setProdukty(new ArrayList<>(Arrays.asList(produkty[6], produkty[7])));
	}

	// Jak powinny wygladac magazyny po usunieciu pierwszego elementu
	public Magazyn magazynyPoUsunPierwszegoElem[] = {
			new Magazyn(), new Magazyn(), new Magazyn(), new Magazyn()
	};

	public void setMagazynyPoUsunPierwszegoElem(){
		magazynyPoUsunPierwszegoElem[0].setProdukty(new ArrayList<>(Arrays.asList(produkty[1])));
		magazynyPoUsunPierwszegoElem[1].setProdukty(new ArrayList<>(Arrays.asList(produkty[3])));
		magazynyPoUsunPierwszegoElem[2].setProdukty(new ArrayList<>(Arrays.asList(produkty[5])));
		magazynyPoUsunPierwszegoElem[3].setProdukty(new ArrayList<>(Arrays.asList(produkty[7])));
	}

	// ######################################################## DANE TEST APLIKACJA ########################################################

	public Rachunek[] rachunki = {
			new Rachunek(),
			new Rachunek(),
			new Rachunek(),
			new Rachunek()
	};

	public void setUpRachunek(){
		rachunki[0].dodajZakup(produkty[0], 1, null);
		rachunki[0].dodajZakup(produkty[1], 2, null);

		rachunki[1].dodajZakup(produkty[2], 1, null);
		rachunki[1].dodajZakup(produkty[3], 2, null);

		rachunki[2].dodajZakup(produkty[4], 1, null);
		rachunki[2].dodajZakup(produkty[5], 2, null);

		rachunki[3].dodajZakup(produkty[6], 1, null);
		rachunki[3].dodajZakup(produkty[7], 2, null);
	}


}
