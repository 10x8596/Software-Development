public class StandState implements State {

    private static StandState instance = null;

    private StandState() {}

    public static StandState getInstance() {
        if (instance == null) { instance = new StandState(); }
        else {return instance;}
        return instance;
    }

    @Override
    public void handleInput(Character character, Key event) {

    }
}
