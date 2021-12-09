package Aplikacja;

import Aplikacja.Model.Magazyn.*;
import java.util.*;
import Aplikacja.Model.Zakupy.*;

public class Aplikacja {

	private static Magazyn magazyn = new Magazyn();
	private static Collection<Rabat> rabaty = new ArrayList<>();
	private Collection<Rachunek> rachunki = new ArrayList<>();
	private boolean czyKoniecZakupow;
	// Konsola jako wejście programu
	private static Scanner programInput = new Scanner(System.in).useLocale(Locale.US);

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args){
		// Rozpoczęcie działania aplikacji
		System.out.println("############################## Dzień dobry ##############################");

		// Zapytanie użytkownika -- pracownik czy klient
		String kindOfUser;
		System.out.println("Jesteś pracownikiem czy klientem?");
		System.out.print("Wpisz \"pracownik\" dla pracownika lub \"klient\" dla klienta: ");
		kindOfUser = programInput.nextLine();
		System.out.println(kindOfUser);

		// Prosta inicjalizacja
		inicjacja();

		// Podejmij działania w zależności od typu klienta
		if (kindOfUser.equals("pracownik")){
			zarzadzaj();
		}else if (kindOfUser.equals("klient")){

		}else{
			System.out.println("Niestety nie ma tego typu użytkownika. Do zobaczenia kolejnym razem!");
		}

	}

	public static Integer pokazMenu(String uzytkownik){
		Integer choosenActivity = -1;

		if (uzytkownik.equals("pracownik")) {
			System.out.println("############################## MENU ##############################");
			System.out.println("1. Pokaz produkty");
			System.out.println("2. Dodaj produkt");
			System.out.println("3. Zmien cene");
			System.out.println("4. Pokaz rabaty");
			System.out.println("5. Dodaj rabat");
			System.out.println("6. Usun rabat");
			System.out.println("7. Koniec zarzadzania");

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

	public static void pokazProdukty() {
		System.out.println("######################## Produkty #######################");
		List<Produkt> produkty = (List<Produkt>) magazyn.getProdukty();
		for (Produkt produkt: produkty){
			System.out.println(produkt.toString());
		}
	}


	public void rozpocznijZakupy() {
		// TODO - implement Aplikacja.rozpocznijZakupy
		throw new UnsupportedOperationException();
	}

	public Rachunek utworzNowyRachunek() {
		// TODO - implement Aplikacja.utworzNowyRachunek
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

	public boolean zapytajCzyKoniecZakupow() {
		// TODO - implement Aplikacja.zapytajCzyKoniecZakupow
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

	public static void zarzadzaj() {
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
					// Zmien cene
					zmienCene();
					break;
				case 4:
					// Pokaz rabaty
					pokazRabaty();
					break;
				case 5:
					dodajRabat();
					break;
				case 6:
					usunRabat();
					break;
				case 7:
					continueProgram = false;
					break;
				default:
					System.out.println("Nie ma takiego polecenia");
					break;
			}
		}
	}
	/**
	 *
	 */
	public static void dodajProdukt() {
		// Dodaj produkt
		String nazwa, kategoriaPodatkowa;
		int liczba;
		float cena;

		System.out.println("######################## Dodajesz Produkty #######################");
		System.out.print("Nazwa: ");
		nazwa = programInput.nextLine();

		System.out.print("Liczba: ");
		liczba = programInput.nextInt();

		System.out.print("Cena: ");
		cena = programInput.nextFloat();

		System.out.print("Kategoria podatkowa: ");
		kategoriaPodatkowa = programInput.nextLine();

		// Stworz nowy produkt
		Produkt nowyProdukt = new Produkt(nazwa, liczba, cena, kategoriaPodatkowa);
		magazyn.dodajProdukt(nowyProdukt);
	}

	/**
	 *
	 */
	public static void zmienCene() {
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

	public static void pokazRabaty() {
		System.out.println("######################## Rabaty #######################");
		for(Rabat rabat: rabaty){
			System.out.println(rabat.toString());
		}
	}

	/**
	 *
	 */
	public static void dodajRabat() {
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

	/**
	 *
	 */
	public static void usunRabat() {
		System.out.println("######################## Usuwasz rabat #######################");
		System.out.print("Numer rabatu: ");
		int numer = programInput.nextInt();

		for (Rabat rabat: rabaty){
			if (rabat.getId_rabatu() == numer){
				rabaty.remove(rabat);
				System.out.println("Rabat został usunięty");
				break;
			}
		}
	}

	public static void inicjacja(){

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

}