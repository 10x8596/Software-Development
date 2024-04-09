import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BranchCompleteTest {

	@Test(timeout = 1000)
	public void test() {

		// TODO
		// START YOUR CODE
		// HINT: assertTrue(BranchComplete.findSomething(a, b, c));
		// OR assertFalse(BranchComplete.findSomething(a, b, c));

		assertTrue(BranchComplete.findSomething(2, 3, 1));
		assertTrue(BranchComplete.findSomething(-1, -2, -3));

		// END YOUR CODE
	}
}
