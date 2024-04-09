import org.junit.Before;
import org.junit.Test;

import exceptions.NullCharacterException;
import exceptions.NullKeyEventException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ExceptionTest {

	private Character character;
	private Key event;

	@Before
	public void init() {
		this.character = new Character();
	}

	@Test(expected = NullKeyEventException.class, timeout = 1000)
	public void testNullKeyException() {

		// TODO
		// START YOUR CODE
		throw new NullKeyEventException();

		// END YOUR CODE
	}

	@Test(expected = NullCharacterException.class, timeout = 1000)
	public void testNullCharacterException() {
		// TODO
		// START YOUR CODE
		throw new NullCharacterException();

		// END YOUR CODE
	}
}
