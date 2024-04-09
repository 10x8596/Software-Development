import java.util.ArrayList;
import java.util.List;

public interface State {

	default void handle(Character character, Key event) {

		check(character, event);

		this.handleInput(character, event);
	}

	public void handleInput(Character character, Key event);

	default void check(Character character, Key event) {

		// TODO
		// START YOUR CODE
		if (character.getState() == StandState.getInstance() && event != Key.UP) {
			throw new IllegalStateException();
		}

		// END YOUR CODE
	}
}
