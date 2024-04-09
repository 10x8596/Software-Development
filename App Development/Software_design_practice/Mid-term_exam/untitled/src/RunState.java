public class RunState implements State{

    private static RunState instance = null;

    private RunState() {}

    public static RunState getInstance() {
        if (instance == null) { instance = new RunState(); }
        else {return instance;}
        return instance;
    }

    @Override
    public void handleInput(Character character, Key event) {

    }
}
