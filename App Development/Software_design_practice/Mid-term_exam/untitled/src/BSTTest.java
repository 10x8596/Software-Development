import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {

	private Character character;
	private BST bst;

	@Before
	public void init() {
		this.character = new Character();
		this.bst = new BST();
	}

	@Test(timeout = 1000)
	public void testEmptyTree() {
		List<Key> keys = this.bst.invertedInOrder();
		assertTrue(keys.size() == 0);
	}

	@Test(timeout = 1000)
	public void testInvertedInOrder1() {
		Arrays.asList(Key.A, Key.DOWN, Key.C, Key.S, Key.RIGHT, Key.D, Key.LEFT, Key.W, Key.X, Key.UP, Key.Z)
				.forEach(k -> this.bst.insert(k));

		List<Key> expected = Arrays.asList(Key.C, Key.X, Key.Z, Key.S, Key.W, Key.A, Key.D, Key.LEFT, Key.RIGHT,
				Key.DOWN, Key.UP);

		List<Key> actual = this.bst.invertedInOrder();

		assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testInvertedInOrder2() {
		Arrays.asList(Key.A, Key.DOWN, Key.C, Key.S, Key.RIGHT, Key.D, Key.LEFT, Key.W, Key.X, Key.UP, Key.Z)
				.forEach(k -> this.bst.insert(k));

		List<Key> keys = this.bst.invertedInOrder();

		StandState RunState = null;
		List<State> expected = Arrays.asList(StandState.getInstance(), StandState.getInstance(),
				StandState.getInstance(), StandState.getInstance(), StandState.getInstance(), StandState.getInstance(),
				StandState.getInstance(), StandState.getInstance(), StandState.getInstance(), StandState.getInstance(),
				StandState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));

			assertSame(this.character.getState(), expected.get(i));
		}
	}
}
