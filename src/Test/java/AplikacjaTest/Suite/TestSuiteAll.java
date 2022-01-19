package AplikacjaTest.Suite;

import AplikacjaTest.AplikacjaTest;
import AplikacjaTest.Model.Magazyn.MagazynTest;
import AplikacjaTest.Model.Magazyn.ProduktTest;
import AplikacjaTest.Zakupy.RachunekTest1;
import AplikacjaTest.Zakupy.ZakupTest1;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({MagazynTest.class, ProduktTest.class, AplikacjaTest.class, RachunekTest1.class, ZakupTest1.class})
public class TestSuiteAll { }