import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name="calc-test")
    Object[][] testData() {
        return new Object[][] {
                {"2+3","5"},
                {"sqrt 16","4"},
                {"3-1","2"}
        };
    }
}
