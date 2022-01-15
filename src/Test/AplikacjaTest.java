package Test;

import Aplikacja.Aplikacja;
import Aplikacja.Model.Magazyn.Magazyn;
import Aplikacja.Model.Zakupy.Rachunek;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@Category({TestEntity.class})
@RunWith(Parameterized.class)
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

	@BeforeClass
	public static void setUp() throws Exception {
		dane = new Dane();
		dane.setUpRachunek();

		aplikacja = new Aplikacja();
		aplikacja.setMagazyn(new Magazyn());
		aplikacja.setRachunki(new ArrayList<>());
	}


	@Test
	public void pokazMenu() {
	}

	@Test
	public void pokazProdukty() {
	}

	@Test
	public void rozpocznijZakupy() {
	}

	@Test
	public void pokazKoszyk() {
	}

	@Test
	public void czyProduktNaRachunku() {
	}

	@Test
	public void sprawdzCzyIloscJestDostepna() {

	}

	@Test
	public void wybierzProdukt() {
		aplikacja.getRachunki().add(new Rachunek());

		aplikacja.wybierzProdukt( );

	}

	@Test
	public void potwierdzZakup() {
	}

	@Test
	public void zarzadzaj() {
	}

	@Test
	public void dodajProdukt() {
		// dodaj produkt
		aplikacja.dodajProdukt();
	}

	@Test
	public void usunProdukt() {
	}

	@Test
	public void zmienCene() {
	}

	@Test
	public void pokazRabaty() {
	}

	@Test
	public void dodajRabat() {
	}

	@Test
	public void usunRabat() {
	}
}