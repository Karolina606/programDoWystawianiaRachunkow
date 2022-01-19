package AplikacjaTest.Zakupy;

import Aplikacja.Model.Zakupy.Rachunek;
import Aplikacja.Model.Zakupy.Zakup;
import mockit.Injectable;
import mockit.StrictExpectations;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(JMockit.class)
public class RachunekTest1 {
	@Tested
	Rachunek rachunek;

	@Injectable
	Zakup zakup1, zakup2, zakup3;

//	@Capturing
//	Zakup zakup1, zakup2, zakup3;

	@Test
	public void testDodajZakup(){
		System.out.println("Test dodawania zakupu: Rachunek Mockit");
		Zakup zakupy[] = {zakup1, zakup2, zakup3, zakup1};
		Rachunek rachunek = new Rachunek();

		new StrictExpectations() {
			{
				zakup1.getLiczba();			returns(1);
				zakup1.zwiekszIlosc(1);		returns(2);
				zakup1.getLiczba();			returns(2);
				zakup1.getNazwa();			returns("foo");
				zakup1.getLiczba();			returns(2);
			}
		};

		for(int i = 0; i < 4; i++){
			rachunek.dodajZakup(zakupy[i]);
		}

		assertEquals(2, rachunek.getKoszyk().get(0).getLiczba());
		System.out.println(rachunek.getKoszyk());
		System.out.println(rachunek.getKoszyk().get(0).getNazwa());
		System.out.println(rachunek.getKoszyk().get(0).getLiczba());
		assertEquals(3, rachunek.getKoszyk().size());

		new Verifications(){
//			{
//				zakup1.getLiczba();			maxTimes = 1;
//				zakup1.zwiekszIlosc(1);		maxTimes = 1;
//				zakup1.getLiczba();			maxTimes = 1;
//				zakup1.getNazwa();			maxTimes = 1;
//				zakup1.getLiczba();			maxTimes = 1;
//			}
		};
	}

	@Test
	public void testObliczWartoscRachunku(){
		Zakup zakupy[] = {zakup1, zakup2, zakup3};
		float ceny[] = {5.00f, 8.00f, 20.00f};
		String katPod[] = {"A", "B", "C"};

		System.out.println("Test obliczanie wartości rachunku: Rachunek Mockit");
		Rachunek rachunek = new Rachunek();

		new StrictExpectations(){
			{
				zakupy[0].getLiczba();		returns(1);
				zakupy[1].getLiczba();		returns(1);
				zakupy[2].getLiczba();		returns(1);
				zakupy[0].getCena();		returns(ceny[0]);
				zakupy[1].getCena();		returns(ceny[1]);
				zakupy[2].getCena();		returns(ceny[2]);
				zakupy[0].getKategoriaPodatkowa();		returns(ceny[0]);
				zakupy[1].getKategoriaPodatkowa();		returns(ceny[1]);
				zakupy[2].getKategoriaPodatkowa();		returns(ceny[2]);
			}
		};

		rachunek.setKoszyk(Arrays.asList(zakupy));

		assertEquals(33.00f, rachunek.getSumaRachunku(), 0.0f);
	}
}
