package AplikacjaTest.Suite;

import AplikacjaTest.AplikacjaTest;
import AplikacjaTest.Model.Magazyn.MagazynTest;
import AplikacjaTest.Model.Magazyn.ProduktTest;
import AplikacjaTest.TestClient;
import AplikacjaTest.TestControl;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@Categories.SuiteClasses({MagazynTest.class, ProduktTest.class, AplikacjaTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestControl.class)
@Categories.ExcludeCategory(TestClient.class)
public class TestSuiteControlExClient { }