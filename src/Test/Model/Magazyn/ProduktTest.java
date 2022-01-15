package Test.Model.Magazyn;

import Test.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@Category({TestEntity.class})
@RunWith(Parameterized.class)
public class ProduktTest {

	Dane dane;

	@Parameterized.Parameter
	public int number1;

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data1 = new Object[][]{ {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7} };
		return Arrays.asList(data1);
	}


	@Before
	public void setUp(){
		dane = new Dane();
	}

//	@Test
//	public void zmienCene() {
//	}

	@Test
	public void zwiekszIlosc() {
		System.out.println("Test zwiekszania ilosci: Produkt");

		// Zwiekszenie ilosci produktu
		Integer iloscDoDodania = dane.iloscProduktowDoDodania[number1];
		dane.produkty[number1].zwiekszIlosc(iloscDoDodania);
		Integer result = dane.produkty[number1].getLiczba();

		assertEquals(dane.iloscProduktowPoDodaniu[number1], result);
	}

	@Test
	public void zmniejszIlosc() {
		System.out.println("Test zmniejszania ilosci: Produkt");

		// Zmniejsz ilość każdego produktu o 100
		dane.produkty[number1].zmniejszIlosc(100);
		int result = dane.produkty[number1].getLiczba();
		assertEquals(0, result);
	}

//	@Test
//	public void getNazwa() {
//	}
//
//	@Test
//	public void getLiczba() {
//	}
//
//	@Test
//	public void getCena() {
//	}
//
//	@Test
//	public void getKategoriaPodatkowa() {
//	}

	@Test
	public void testToString() {
		System.out.println("Test generowania opisu: Produkt");

		String result = dane.produkty[number1].toString();
		assertEquals(dane.opisyProduktow[number1], result);
	}
}