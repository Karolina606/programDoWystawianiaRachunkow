package Test.Suite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import Test.*;
import Test.Model.Magazyn.*;

@Categories.SuiteClasses({MagazynTest.class, ProduktTest.class, AplikacjaTest.class})
@RunWith(Categories.class)
@Categories.ExcludeCategory(TestControl.class)
public class TestSuiteExControl { }
