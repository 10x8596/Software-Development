import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StateTest {

	private Character character;

	@Before
	public void init() {
		this.character = new Character();
	}

	@Test(timeout = 1000)
	public void testAllStates() {

		List<Key> keys = Arrays.asList(Key.DOWN, Key.RIGHT, Key.LEFT, Key.UP, Key.RIGHT, Key.LEFT);
		List<State> expected = Arrays.asList(LieProneState.getInstance(), CrawlState.getInstance(),
				LieProneState.getInstance(), StandState.getInstance(), RunState.getInstance(), StandState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}

	@Test(timeout = 1000)
	public void testStatesWithRandomKeys1() {

		List<Key> keys = Arrays.asList(Key.DOWN, Key.DOWN, Key.UP, Key.RIGHT, Key.DOWN, Key.LEFT, Key.UP);
		List<State> expected = Arrays.asList(LieProneState.getInstance(), LieProneState.getInstance(),
				StandState.getInstance(), RunState.getInstance(), RunState.getInstance(), StandState.getInstance(),
				StandState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}

	@Test(timeout = 1000)
	public void testStatesWithRandomKeys2() {

		List<Key> keys = Arrays.asList(Key.LEFT, Key.UP, Key.DOWN, Key.RIGHT, Key.UP, Key.DOWN);
		List<State> expected = Arrays.asList(StandState.getInstance(), StandState.getInstance(),
				LieProneState.getInstance(), CrawlState.getInstance(), CrawlState.getInstance(), CrawlState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}
}
