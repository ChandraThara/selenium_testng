package interviewPrep;
/*
 Q. Write a method that return true if given STring is an integer, false otherwise.
    Write tests
 */

import com.sun.org.apache.xpath.internal.operations.Number;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsNumeric {
    public Boolean isNumeric( String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    @DataProvider(name="data")
    Object[][] data() {
        //+ve tests
        return new Object[][]{
                {"123"},
                {"-123"}
        };
    }

    @Test(dataProvider ="data")
    void isNumericTest(String input) {
        Assert.assertTrue(isNumeric(input));
    }

    @DataProvider(name="invalid-data")
    Object[][] invalidData() {
        //+ve tests
        return new Object[][]{
                {"abc"},
                {"@#$"},
                {""},
                {null},
                {"12.23"},
                {"21474836479"}//max val that int can hold is 2,147,483, 647
        };
    }

    @Test(dataProvider ="invalid-data")
    void isNumericTestWithInvalidData(String input) {
        Assert.assertFalse(isNumeric(input));
    }
}
