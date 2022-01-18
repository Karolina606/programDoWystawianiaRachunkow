package Test.Suite;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import Test.*;
import Test.Model.Magazyn.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({MagazynTest.class, ProduktTest.class, AplikacjaTest.class})
public class TestSuiteAll { }