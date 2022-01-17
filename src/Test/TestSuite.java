package Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import Test.Model.Magazyn.MagazynTest;
import Test.Model.Magazyn.ProduktTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({MagazynTest.class, ProduktTest.class, AplikacjaTest.class})
public class TestSuite { }