package Test.Model.Magazyn;


import java.util.*;
import mockit.Injectable;
import mockit.Mocked;
import org.junit.Test;
import static org.junit.Assert.*;
import Aplikacja.Model.Magazyn.Magazyn;
import Aplikacja.Model.Magazyn.Produkt;

public class MagazynTestMock {
    @Injectable
    Produkt produkt1, produkt2, produkt3;

    @Test
    public void testZnadzProdukt(){
        System.out.println("Test szukania produktu w magazynie: Magazyn");
        ArrayList<Produkt> produkty = new ArrayList<>(Arrays.asList(produkt1, produkt2, produkt3));
        Magazyn magazyn = new Magazyn();
        magazyn.setProdukty(produkty);

        for(int i = 0; i < 3; i++)
            assertEquals(magazyn.znadzProdukt(produkty[i].getNazwa()), produkty[i]);

    };
}
