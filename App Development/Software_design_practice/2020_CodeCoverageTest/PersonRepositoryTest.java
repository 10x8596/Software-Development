
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PersonRepositoryTest {

    SequenceGenerator sequenceGenerator;
    PersonRepository personRepository;

    @Before
    public void before() {
        sequenceGenerator = new SequenceGenerator();
        personRepository = new PersonRepository();
        personRepository.setSequenceGenerator(sequenceGenerator);
    }

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    @Test
    public void personRepoTest() {
        PersonQ3 p = new PersonQ3(null, "John", 40, "policeman");
        assertEquals(p, personRepository);
    }

    // ########## YOUR CODE ENDS HERE ##########


}
