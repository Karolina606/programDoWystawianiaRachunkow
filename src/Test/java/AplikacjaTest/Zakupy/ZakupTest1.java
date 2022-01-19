package AplikacjaTest.Zakupy;

import Aplikacja.Model.Magazyn.Produkt;
import Aplikacja.Model.Magazyn.Rabat;
import Aplikacja.Model.Zakupy.Zakup;
import mockit.Injectable;
import mockit.Mocked;
import mockit.StrictExpectations;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JMockit.class)
public class ZakupTest1 {

//	@Mocked
//	Rabat rabat;
	@Mocked
	Produkt produkt;

	@Injectable
	Produkt produkt1;

	@Injectable
	Rabat rabat;

	@Test
	public void testEquals(){
		System.out.println("Test equals zakupów: Zakup Mockit");
		Rabat rabat1 = new Rabat(14.55F, Arrays.asList("Pilka"));
		Produkt produkt1 = new Produkt("Pilka", 10, 35.99f, "C");

		Zakup zakupy[] = {
				new Zakup(produkt, 1, null),
				new Zakup(produkt1, 2, null),
		};

		// System.out.println("Zakup equals");
		for (int i = 0; i < 1; i++){
			for(int j = 0; j < 2; j++){
				if(i == j){
					assertTrue(zakupy[i].equals(zakupy[i]));
				}else{
					assertFalse(zakupy[i].equals(zakupy[j]));
				}
			}
		}

		new Verifications(){
//			{
//				produkt.equals(any); 		maxTimes = 2;
//			}
		};
	}

	@Test
	public void testObliczWartoscZakupowZPodatkami(){
		System.out.println("Test obliczania wartosci zakupu: Zakup Mokit");


		new StrictExpectations(){
			{
				produkt1.getNazwa(); 				returns("Pilka");
				produkt1.getCena(); 				returns(5.89f);
				produkt1.getKategoriaPodatkowa(); 	returns("D");
			}
		};

		Produkt produkt2 = new Produkt("Baton", 20, 4.99f, "B");
		Zakup zakupy[] = {
				new Zakup(produkt1, 1, null),
				new Zakup(produkt2, 3, null),
		};

		float cenyZakupow[] = {0, 0};
		for (int i = 0; i < 2; i++){
			cenyZakupow[i] = zakupy[i].obliczWartoscZakupuZPodatkiem();
		}

		assertEquals(5.89f, cenyZakupow[0] ,0.0f);
		assertNotEquals(5.89f, cenyZakupow[1] ,0.0f);

	}

	@Test
	public void testObliczWartoscZakupuZRabatem(){
		System.out.println("Test obliczania wartosci zakupu z rabatem: Zakup Mokit");

		new StrictExpectations(){
			{
				rabat.getWartoscRabatu(); 			returns(1.99f);
			}
		};


		Produkt produkt3 = new Produkt("Pilka", 30, 19.99f, "A");
		Zakup zakup = new Zakup(produkt3, 2, rabat);

		assertEquals(36.00f, zakup.obliczWartoscZakupuOdjacRabat(),0.0f);

	}

}
