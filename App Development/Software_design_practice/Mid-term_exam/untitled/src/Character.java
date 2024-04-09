public class Character {

	private static Character instance;
	public static Character getInstance() {
		if (instance == null) { instance = new Character(); }
		return instance;
	}

	private State state =  StandState.getInstance();

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
