import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    //To test the `calcInsurancePrice()` method, which returns void, you can use the `getHealthInsurancePrice()` method, for example:
    //PersonQ3 p = new PersonQ3("XYZ", 10, "XYZ", true, true);
    //assertEquals(0, p.getHealthInsurancePrice().intValue());


    @Test
    public void BranchCompleteTest() {
        // (branch 6) everything false if first condition
        Person person1 = new Person("John", 30, "Doctor", false, false);
        assertEquals(350, person1.getHealthInsurancePrice().intValue());

        // (branch 5) age condition false
        Person person2 = new Person("John", 40, "policeman", false, false);
        assertEquals(200, person2.getHealthInsurancePrice().intValue());

        // (branch 4) age condition true and diabetes but not heart disease
        Person person3 = new Person("John", 50, "policeman", true, false);
        assertEquals(400, person3.getHealthInsurancePrice().intValue());

        // (branch 3) age condition true, and heart disease but no diabetes
        Person person4 = new Person("John", 50, "policeman", false, true);
        assertEquals(500, person4.getHealthInsurancePrice().intValue());

        // (branch 2) age condition true, and both illness false
        Person person5 = new Person("John", 50, "policeman", true, true);
        assertEquals(1100, person5.getHealthInsurancePrice().intValue());

        // (branch 1) age condition true, and both illness true
        Person person6 = new Person("John", 50, "policeman", false, false);
        assertEquals(360, person6.getHealthInsurancePrice().intValue());
    }

    // ########## YOUR CODE ENDS HERE ##########

}
