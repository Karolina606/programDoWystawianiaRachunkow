package Aplikacja;

import Aplikacja.Model.Magazyn.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import Aplikacja.Model.Zakupy.*;

public class Aplikacja {

	private Magazyn magazyn = new Magazyn();
	private List<Rabat> rabaty = new ArrayList<>();
	private List<Rachunek> rachunki = new ArrayList<>();
	// Konsola jako wejście programu
	private Scanner programInput = new Scanner(System.in).useLocale(Locale.US);


	public static void main(String[] args){
		Aplikacja app = new Aplikacja();

		// Rozpoczęcie działania aplikacji
		System.out.println("############################## Dzień dobry ##############################");

		// Zapytanie użytkownika -- pracownik czy klient
		String kindOfUser;
		System.out.println("Jesteś pracownikiem czy klientem?");
		System.out.print("Wpisz \"pracownik\" dla pracownika lub \"klient\" dla klienta: ");
		kindOfUser = app.programInput.nextLine();
		System.out.println(kindOfUser);

		// Prosta inicjalizacja
		// inicjacja();
		app.wczytaj();

		// Podejmij działania w zależności od typu klienta
		if (kindOfUser.equals("pracownik")){
			app.zarzadzaj();
		}else if (kindOfUser.equals("klient")){
			app.rozpocznijZakupy();
		}else{
			System.out.println("Niestety nie ma tego typu użytkownika. Do zobaczenia kolejnym razem!");
		}

	}

	public int pokazMenu(String uzytkownik){
		int choosenActivity = -1;

		if (uzytkownik.equals("pracownik")) {
			System.out.println("############################## MENU ##############################");
			System.out.println("1. Pokaz produkty");
			System.out.println("2. Dodaj produkt");
			System.out.println("3. Usun produkt");
			System.out.println("4. Zmien cene");
			System.out.println("5. Pokaz rabaty");
			System.out.println("6. Dodaj rabat");
			System.out.println("7. Usun rabat");
			System.out.println("8. Koniec zarzadzania");

		} else if (uzytkownik.equals("klient")){
			System.out.println("############################## MENU ##############################");
			System.out.println("1. Pokaz produkty");
			System.out.println("2. Dodaj produkt do koszyka");
			System.out.println("3. Pokaz koszyk");
			System.out.println("4. Potwierdz i zakoncz zakupy");
		}
		System.out.print("Wybierz czynnosc: ");
		choosenActivity = programInput.nextInt();

		return choosenActivity;
	}

	public void pokazProdukty() {
		System.out.println("######################## Produkty #######################");
		List<Produkt> produkty = (List<Produkt>) magazyn.getProdukty();
		for (Produkt produkt: produkty){
			System.out.println(produkt.toString());
		}
	}


	public void rozpocznijZakupy() {
		// Stworz nowy rachunek
		Rachunek nowyRachunek = new Rachunek();
		rachunki.add(nowyRachunek);

		// Zmienne pomocnicze
		int choosenActivity;
		boolean czyKoniecZakupow = false;
		
		while(!czyKoniecZakupow) {
			choosenActivity = pokazMenu("klient");

			// Wybierz czynnosc
			switch (choosenActivity) {
				case 1:
					// Pokaz produkty
					pokazProdukty();
					break;
				case 2:
					// Dodaj produkt do koszyka
					wybierzProdukt();
					break;
				case 3:
					// Pokaz koszyk
					pokazKoszyk();
					break;
				case 4:
					// Zakoncz zakupy
					potwierdzZakup();
					czyKoniecZakupow = true;
					zapisz();
					break;
				default:
					System.out.println("Nie ma takiego polecenia");
					break;
			}
		}
	}

	public void pokazKoszyk() {
		System.out.println("######################## Twoj koszyk #######################");
		Rachunek ostatniRachunek = rachunki.get(rachunki.size()-1);

		for(Zakup zakup: ostatniRachunek.getKoszyk()){
			System.out.println(zakup);
		}
	}

	public boolean czyProduktNaRachunku(Rachunek rachunek, Produkt produkt) {
		return rachunek.czyProduktNaRachunku(produkt);
	}

//	public int podajIlosc() {
//		// TODO - implement Aplikacja.podajIlosc
//		throw new UnsupportedOperationException();
//	}

	public boolean sprawdzCzyIloscJestDostepna(Produkt produkt, int ilosc) {
		if (produkt.getLiczba() >= ilosc){
			return true;
		}else{
			return false;
		}
	}

//	public boolean zapytajCzyKoniecZakupow() {
//		// TODO - implement Aplikacja.zapytajCzyKoniecZakupow
//		throw new UnsupportedOperationException();
//	}

	public void wybierzProdukt() {
		System.out.println("######################## Wybierasz produkt #######################");

		System.out.print("Podaj nazwe produktu: ");
		programInput.nextLine();
		String nazwaProduktu = programInput.nextLine();

		System.out.print("Podaj ilosc: ");
		int ilosc = Integer.parseInt(programInput.nextLine());

		Produkt produktDoZakupu = magazyn.znadzProdukt(nazwaProduktu);
		Rachunek obecnyRachunek = rachunki.get(rachunki.size()-1);

		if(produktDoZakupu != null){
			if (sprawdzCzyIloscJestDostepna(produktDoZakupu, ilosc)){
				if(obecnyRachunek.czyProduktNaRachunku(produktDoZakupu)){
					obecnyRachunek.zwiekszIloscZakupu(produktDoZakupu, ilosc);
				}
				else {
					Rabat znalezionyRabat = null;
					for(Rabat rabat: rabaty){
						if(rabat.sprawdzCzyProduktMaRabat(produktDoZakupu)){
							znalezionyRabat = rabat;
							break;
						}
					}
					obecnyRachunek.dodajZakup(produktDoZakupu, ilosc, znalezionyRabat);
					produktDoZakupu.zmniejszIlosc(ilosc);
				}
			}else{
				System.out.println("Taka ilość nie jest dostepna");
			}
		}else{
			System.out.println("Niestety chyba nie ma takiego produktu");
		}
	}

	public void potwierdzZakup() {
		System.out.println("######################## Koniec zakupow #######################");
		DaneDostawy daneDostawy = podajDaneDostawy();
		Rachunek obecnyRachunek = rachunki.get(rachunki.size()-1);
		wystawRachunek(obecnyRachunek, daneDostawy);
	}

	private  DaneDostawy podajDaneDostawy() {
		System.out.print("Imie: ");
		programInput.nextLine();
		String imie = programInput.nextLine();
		System.out.print("Nazwisko: ");
		String nazwisko = programInput.nextLine();
		System.out.print("Miejscowosc: ");
		String miejscowosc = programInput.nextLine();
		System.out.print("Kod pocztowy: ");
		String kodPocztowy = programInput.nextLine();
		System.out.print("Ulica: ");
		String ulica = programInput.nextLine();
		System.out.print("Numer domu: ");
		String nrDomu = programInput.nextLine();
		System.out.print("Numer mieszkania: ");
		String nrMieszkania = programInput.nextLine();
		System.out.print("Numer telefonu: ");
		String nrTelefonu = programInput.nextLine();

		DaneDostawy noweDane = new DaneDostawy(imie, nazwisko, miejscowosc, kodPocztowy, ulica,  nrDomu, nrMieszkania, nrTelefonu);
		return noweDane;
	}

	private void wystawRachunek(Rachunek rachunek, DaneDostawy daneDostawy) {
		rachunek.wystaw(daneDostawy);
	}

	public void zarzadzaj() {
		// Zmienne pomocnicze
		Integer choosenActivity;
		Boolean continueProgram = true;

		// Dopoki nie zakonczono programu
		while(continueProgram) {
			// Wybierz czynnosc
			choosenActivity = pokazMenu("pracownik");

			// Wybierz czynnosc
			switch (choosenActivity) {
				case 1:
					// Pokaz produkty
					pokazProdukty();
					break;
				case 2:
					// Dodaj produkt
					dodajProdukt();
					break;
				case 3:
					// Usun
					usunProdukt();
					break;
				case 4:
					// Zmien cene
					zmienCene();
					break;
				case 5:
					// Pokaz rabaty
					pokazRabaty();
					break;
				case 6:
					dodajRabat();
					break;
				case 7:
					usunRabat();
					break;
				case 8:
					continueProgram = false;
					zapisz();
					break;
				default:
					System.out.println("Nie ma takiego polecenia");
					break;
			}
		}
	}

	public void dodajProdukt() {
		// Dodaj produkt
		String nazwa, kategoriaPodatkowa;
		int liczba;
		float cena;

		System.out.println("######################## Dodajesz Produkty #######################");
		System.out.print("Nazwa: ");
		programInput.nextLine();
		nazwa = programInput.nextLine();

		System.out.print("Liczba: ");
		liczba = programInput.nextInt();

		if (magazyn.znadzProdukt(nazwa) != null){
			Produkt nowyProdukt = new Produkt(nazwa, liczba, 0, "");
			magazyn.dodajProdukt(nowyProdukt);
		}else{
			System.out.print("Cena: ");
			cena = programInput.nextFloat();

			System.out.print("Kategoria podatkowa: ");
			programInput.nextLine();
			kategoriaPodatkowa = programInput.nextLine();

			// Stworz nowy produkt
			Produkt nowyProdukt = new Produkt(nazwa, liczba, cena, kategoriaPodatkowa);
			magazyn.dodajProdukt(nowyProdukt);
		}
	}

	public void usunProdukt() {
		System.out.println("######################## Usuwasz produkt #######################");
		System.out.print("Nazwa produktu: ");
		programInput.nextLine();
		String nazwa = programInput.nextLine();

		List<Produkt> produkty = magazyn.getProdukty();
		for (Produkt produkt: produkty){
			if (produkt.getNazwa().equals(nazwa)){
				magazyn.usunProdukt(produkt.getNazwa());
				System.out.println("Produkt został usunięty");
				return ;
			}
		}
		System.out.println("Produkt chyba nie został usuniety, mozliwa zla nazwa");
	}

	public void zmienCene() {
		String nazwa, kategoriaPodatkowa;
		float cena;

		System.out.println("######################## Zmieniasz cene #######################");
		System.out.print("Nazwa produktu: ");
		programInput.nextLine();
		nazwa = programInput.nextLine();

		System.out.print("Nowa cena: ");
		cena = programInput.nextFloat();

		// Znajdz produkt ktoremu chcesz zmienic cene
		Produkt produktDoZmianyCeny = magazyn.znadzProdukt(nazwa);
		if (produktDoZmianyCeny != null){
			produktDoZmianyCeny.zmienCene(cena);
		}else{
			System.out.println("Niestety nie znaleziono takiego produktu");
		}
	}

	public void pokazRabaty() {
		System.out.println("######################## Rabaty #######################");
		for(Rabat rabat: rabaty){
			System.out.println(rabat.toString());
		}
	}

	public void dodajRabat() {
		System.out.println("######################## Dodajesz rabat #######################");
		System.out.print("Wartosc rabatu: ");
		float wartosc = programInput.nextFloat();

		System.out.print("Nazwy produktow z rabatem (po przecinku): ");
		programInput.nextLine();
		String produkty = programInput.nextLine();
		ArrayList<String> nazwyProduktowZRabatem = new ArrayList<>(List.of(produkty.split(",")));

		Rabat nowyRabat = new Rabat(wartosc, nazwyProduktowZRabatem);
		rabaty.add(nowyRabat);
	}


	public void usunRabat() {
		System.out.println("######################## Usuwasz rabat #######################");
		System.out.print("Numer rabatu: ");
		int numer = programInput.nextInt();

		for (Rabat rabat: rabaty){
			if (rabat.getRabatId() == numer){
				rabaty.remove(rabat);
				System.out.println("Rabat został usunięty");
				return ;
			}
		}
		System.out.println("Rabat chyba nie został usuniety, sprawdz indeks");
	}

	public void inicjacja(){

		// Dodaje produkty
		ArrayList<String> nazwyProduktow = new ArrayList<>(List.of("Pilka tenisowa", "Kapielowki meskie", "Stroj kapielowy damski", "Baton bialkowy"));
		ArrayList<Integer> ilosc = new ArrayList<>(List.of(50, 10, 8, 100));
		ArrayList<Float> cena = new ArrayList<>();
		cena.add(new Float(4.99)); cena.add(new Float(39.99)); cena.add(new Float(59.99)); cena.add(new Float(3.99));
		ArrayList<String> kategoriaPodatkowa = new ArrayList<>(List.of("A", "B", "C", "D"));

		Produkt nowyProdukt;
		int iloscProduktow = nazwyProduktow.size();
		for(int i = 0; i < iloscProduktow; i++){
			nowyProdukt = new Produkt(nazwyProduktow.get(i), ilosc.get(i), cena.get(i), kategoriaPodatkowa.get(i));
			magazyn.dodajProdukt(nowyProdukt);
		}


		// Dodaje rabaty
		ArrayList<Float> wartoscRabatu = new ArrayList<>();
		wartoscRabatu.add(new Float(9.89));
		ArrayList<String> listaProduktowZRabatem = new ArrayList<>(List.of("Kapielowki meskie"));

		Rabat nowyRabat;
		int iloscRabatow = wartoscRabatu.size();
		for(int i = 0; i < iloscRabatow; i++){
			nowyRabat = new Rabat(wartoscRabatu.get(i), Collections.singletonList(listaProduktowZRabatem.get(i)));
			rabaty.add(nowyRabat);
		}
	}

	public void wczytaj(){
		ObjectInputStream inputStream;
		try
		{
			// RACHUNKI
			// tworzy strumień do wczytania
			inputStream = new ObjectInputStream(
					new FileInputStream("rachunki.ser")
			);

			Rachunek rachunek;
			while((rachunek = (Rachunek) inputStream.readObject())  != null){
				rachunki.add(rachunek);
			}
			Rachunek.ustawLicznikRachunkow(rachunki.get(rachunki.size()-1).getRachunekId() + 1);
			inputStream.close();
		} catch (Exception ex) // zgłasza wyjątki
		{}

		try{
			// RABATY
			// tworzy strumień do wczytania
			inputStream = new ObjectInputStream(
					new FileInputStream("rabaty.ser")
			);

			Rabat rabat;
			while((rabat = (Rabat) inputStream.readObject())  != null){
				rabaty.add(rabat);
			}
			Rabat.ustawLicznikRabatow(rabaty.get(rabaty.size()-1).getRabatId() + 1);
			inputStream.close();

		} catch (Exception ex) // zgłasza wyjątki
		{}

		try{
			// MAGAZYN
			// tworzy strumień do zapisu
			inputStream = new ObjectInputStream(
					new FileInputStream("magazyn.ser")
			);
			magazyn = (Magazyn) inputStream.readObject();
			inputStream.close(); // zamknięcie strumienia

		} catch (Exception ex) // zgłasza wyjątki
		{}
	}

	public void zapisz(){
		try
		{
			// RACHUNKI
			// tworzy strumień do zapisu
			ObjectOutputStream outputStream = new ObjectOutputStream(
					new FileOutputStream("rachunki.ser")
			);
			for(Rachunek rachunek: rachunki){
				outputStream.writeObject(rachunek); // zapisanie obiektu
			}
			outputStream.close(); // zamknięcie strumienia


			// RABATY
			// tworzy strumień do zapisu
			outputStream = new ObjectOutputStream(
					new FileOutputStream("rabaty.ser")
			);
			for(Rabat rabat: rabaty){
				outputStream.writeObject(rabat); // zapisanie obiektu
			}
			outputStream.close(); // zamknięcie strumienia


			// MAGAZYN
			// tworzy strumień do zapisu
			outputStream = new ObjectOutputStream(
					new FileOutputStream("magazyn.ser")
			);
			outputStream.writeObject(magazyn);
			outputStream.close(); // zamknięcie strumienia

		} catch (Exception ex) // zgłasza wyjątki
		{
			ex.printStackTrace();
		}
	}

	public Magazyn getMagazyn() {
		return magazyn;
	}

	public void setMagazyn(Magazyn magazyn) {
		this.magazyn = magazyn;
	}

	public List<Rabat> getRabaty() {
		return rabaty;
	}

	public void setRabaty(List<Rabat> rabaty) {
		this.rabaty = rabaty;
	}

	public List<Rachunek> getRachunki() {
		return rachunki;
	}

	public void setRachunki(List<Rachunek> rachunki) {
		this.rachunki = rachunki;
	}

}