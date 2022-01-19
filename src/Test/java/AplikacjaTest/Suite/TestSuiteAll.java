package AplikacjaTest.Suite;

import AplikacjaTest.AplikacjaTest;
import AplikacjaTest.Model.Magazyn.MagazynTest;
import AplikacjaTest.Model.Magazyn.ProduktTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({MagazynTest.class, ProduktTest.class, AplikacjaTest.class})
public class TestSuiteAll { }