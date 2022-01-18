package Test.Suite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import Test.*;
import Test.Model.Magazyn.*;

@Categories.SuiteClasses({MagazynTest.class, ProduktTest.class, AplikacjaTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestControl.class)
@Categories.ExcludeCategory(TestClient.class)
public class TestSuiteControlExClient { }
