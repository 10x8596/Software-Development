public class CrawlState implements State {

    private static CrawlState instance = null;

    private CrawlState() {}

    public static CrawlState getInstance() {
        if (instance == null) { instance = new CrawlState(); }
        else {return instance;}
        return instance;
    }

    @Override
    public void handleInput(Character character, Key event) {

    }
}
