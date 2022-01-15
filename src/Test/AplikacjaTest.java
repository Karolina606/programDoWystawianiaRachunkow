package Test;

import Aplikacja.Aplikacja;
import Aplikacja.Model.Magazyn.Magazyn;
import Aplikacja.Model.Magazyn.Rabat;
import Aplikacja.Model.Zakupy.DaneDostawy;
import Aplikacja.Model.Zakupy.Rachunek;
import Aplikacja.Model.Zakupy.Zakup;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@Category({TestEntity.class})
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AplikacjaTest {

	public static Dane dane;
	public static Aplikacja aplikacja;

	@Parameterized.Parameter(value = 0)
	public int numer1;
	@Parameterized.Parameter(value = 1)
	public int numer2;
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data1 = new Object[][]{
				{0, 1}, {2, 3}, {4, 5}, {6, 7} };
		return Arrays.asList(data1);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@BeforeClass
	public static void setUp() throws Exception {
		dane = new Dane();
		dane.setUpRachunek();
		dane.setUpRabaty();

		aplikacja = new Aplikacja();
		aplikacja.setMagazyn(new Magazyn());
		aplikacja.setRachunki(new ArrayList<>());

		aplikacja.getMagazyn().setProdukty(new ArrayList<>(Arrays.asList(dane.produkty)));
	}


	@Test
	public void test1wybierzProdukt() {
		System.out.println("Test dodawania produktu do rachunku: Aplikacja");

		aplikacja.getRachunki().add(new Rachunek());

		aplikacja.wybierzProdukt(dane.produkty[numer1].getNazwa(), 1);
		aplikacja.wybierzProdukt(dane.produkty[numer2].getNazwa(), 2);

		String result = aplikacja.getRachunki().get(aplikacja.getRachunki().size()-1).toString();

		assertEquals(dane.rachunki[numer1/2].toString(), result);

	}

	@Test
	public void test2dodajRabat() {
		System.out.println("Test dodawania rabatu: Aplikacja");

		// Dodaje rabat o wartości takiej jak drugi numer do obu produktow (numer1 i numer2)
		ArrayList<String> nazwyProduktowZRabatem = new ArrayList<>();
		nazwyProduktowZRabatem.add(dane.produkty[numer1].getNazwa());
		nazwyProduktowZRabatem.add(dane.produkty[numer2].getNazwa());
		aplikacja.dodajRabat(numer2%4, nazwyProduktowZRabatem);

		assertTrue(
				aplikacja.getRabaty().get(aplikacja.getRabaty().size()-1).getWartoscRabatu() == dane.rabaty.get(numer1/2).getWartoscRabatu()
		);

		assertTrue(
				aplikacja.getRabaty().get(aplikacja.getRabaty().size()-1).getListaNazwProduktowZRabatem().equals(dane.rabaty.get(numer1/2).getListaNazwProduktowZRabatem())
		);
	}

	@Test
	public void test3potwierdzZakup() {
		System.out.println("Test potwierdzania zakupu / obliczania sumy rachunku: Aplikacja");

		aplikacja.potwierdzZakup(new DaneDostawy());

		assertEquals(dane.sumyRachunkow[numer1/2], aplikacja.getRachunki().get(aplikacja.getRachunki().size()-1).getSumaRachunku(), 0.0f);
		assertEquals(dane.sumyRabatow[numer1/2], aplikacja.getRachunki().get(aplikacja.getRachunki().size()-1).getSumaRabatu(), 0.0f);

	}

//	@Test
//	public void czyProduktNaRachunku() {
//	}
//
//	@Test
//	public void sprawdzCzyIloscJestDostepna() {
//
//	}
//	@Test
//	public void dodajProdukt() {
//	}
//
//	@Test
//	public void usunProdukt() {
//	}
//
//	@Test
//	public void zmienCene() {
//	}
//
//	@Test
//	public void pokazRabaty() {
//	}

//	@Test
//	public void usunRabat() {
//	}
}