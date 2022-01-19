package AplikacjaTest.Suite;

import AplikacjaTest.AplikacjaTest;
import AplikacjaTest.Model.Magazyn.MagazynTest;
import AplikacjaTest.Model.Magazyn.ProduktTest;
import AplikacjaTest.TestControl;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({MagazynTest.class, ProduktTest.class, AplikacjaTest.class})
@RunWith(Categories.class)
@Categories.ExcludeCategory(TestControl.class)
public class TestSuiteExControl { }
