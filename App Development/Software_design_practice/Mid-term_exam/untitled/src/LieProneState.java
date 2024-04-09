public class LieProneState implements State {

    private static LieProneState instance = null;

    private LieProneState() {}

    public static LieProneState getInstance() {
        if (instance == null) { instance = new LieProneState(); }
        else {return instance;}
        return instance;
    }

    @Override
    public void handleInput(Character character, Key event) {

    }
}
