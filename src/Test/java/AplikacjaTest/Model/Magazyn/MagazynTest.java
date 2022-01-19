package AplikacjaTest.Model.Magazyn;

import AplikacjaTest.Dane;
import Aplikacja.Model.Magazyn.Magazyn;
import Aplikacja.Model.Magazyn.Produkt;
import AplikacjaTest.TestEntity;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@Category({TestEntity.class})
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MagazynTest {

	public static List<Magazyn> magazyny;
	public static Dane dane;

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
		dane.setMagazyny();

		dane.setMagazynyPoUsunPierwszegoElem();
		magazyny = new ArrayList<>();
	}

	@Test
	public void test1SetProdukty() {
		System.out.println("Test ustawienia produktow w magazynie: Magazyn");

		Produkt produkt1 = dane.produkty[numer1];
		Produkt produkt2 = dane.produkty[numer2];

		ArrayList<Produkt> listaProduktow = new ArrayList();
		listaProduktow.add(produkt1);
		listaProduktow.add(produkt2);

		// Sprawdzany magazyn
		Magazyn magazyn = new Magazyn();
		magazyn.setProdukty(listaProduktow);
		magazyny.add(magazyn);

		assertEquals(dane.magazyny[numer1/2].getProdukty(), magazyn.getProdukty());
	}

	@Test
	public void test2UsunProdukt() {
		System.out.println("Test usuniecia produktow z magazynu: Magazyn");

		// Usuniecie pierwszego elementu z magazynu
		magazyny.get(numer1/2).usunProdukt(dane.produkty[numer1].getNazwa());
		List<Produkt> result = magazyny.get(numer1/2).getProdukty();

		// Sprawdzenie równości
		assertEquals(dane.magazynyPoUsunPierwszegoElem[numer1/2].getProdukty(), result);
	}

	@Test
	public void test3ZnadzProdukt() {
		System.out.println("Test szukania nieobecnego produktu w magazynie: Magazyn");

		// Szukaj usuniętego produktu
		String nazwaSzukanegoProduktu = dane.produkty[numer1].getNazwa();
		Produkt result = magazyny.get(numer1/2).znadzProdukt(nazwaSzukanegoProduktu);
		assertNull(result);
	}

	//	@Test
//	public void getProdukty() {
//	}

//	@Test
//	public void dodajProdukt() {
//
//	}
}