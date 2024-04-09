import java.util.LinkedList;
import java.util.List;

public class Parser {

	private final Tokeniser tokeniser;

	public Parser(Tokeniser tokeniser) {
		this.tokeniser = tokeniser;
	}

	public List<Command> parseCmds() {

		List<Command> commands = new LinkedList<>();

		// ########## YOUR CODE STARTS HERE ##########
		while (tokeniser.hasNext()) {
			if (tokeniser.current().getType().equals(Token.Type.SAVE)) {
				// get next token after SAVE
				tokeniser.next(); // move on from SAVE
				Token value = tokeniser.current();
				tokeniser.next(); // move on from person
				tokeniser.next(); // move on from TO
				Token fileName = tokeniser.current(); // file to save in
				tokeniser.next();
				tokeniser.next();
				SaveCommand cmd = new SaveCommand(value.getValue(), fileName.getValue());
				commands.add(cmd);
			} else if (tokeniser.current().getType().equals(Token.Type.LOAD)) {
				// get next token after LOAD
				tokeniser.next(); // move on from LOAD
				Token value = tokeniser.current();
				tokeniser.next(); // move on from person
				tokeniser.next(); // move on from TO
				Token fileName = tokeniser.current(); // file to load in from
				tokeniser.next();
				tokeniser.next();
				LoadCommand cmd = new LoadCommand(value.getValue(), fileName.getValue());
				commands.add(cmd);
			}
		}
		// ########## YOUR CODE ENDS HERE ##########

		return commands;
	}
}
