public class Tokeniser {

	private String buffer; // save text
	private Token currentToken; // save token extracted from next()

	public Tokeniser(String text) {
		buffer = text; // save input text (string)
		next(); // extracts the first token.
	}

	/**
	 * This function will find and extract a next token from {@code buffer} and save
	 * the token to {@code currentToken}.
	 */
	public void next() {

		buffer = buffer.trim(); // remove whitespace
		if (buffer.isEmpty()) {
			currentToken = null; // if there's no string left, set currentToken null and return
			return;
		}

		// ########## YOUR CODE STARTS HERE ##########
		// TERMINATOR Token
		if (buffer.charAt(0) == ';') {
			currentToken = new Token(Token.Type.TERMINATOR, ";");
		} else if (buffer.substring(0,2).toUpperCase().equals("LO")) {
			currentToken = new Token(Token.Type.LOAD, buffer.substring(0,4));
		} else if (buffer.substring(0,2).toUpperCase().equals("FR")) {
			currentToken = new Token(Token.Type.FROM, buffer.substring(0,4));
		} else if (buffer.substring(0,2).toUpperCase().equals("SA")) {
			currentToken = new Token(Token.Type.SAVE, buffer.substring(0,4));
		} else if (buffer.substring(0,2).toUpperCase().equals("TO")) {
			currentToken = new Token(Token.Type.TO, buffer.substring(0,2));
		} else {
			StringBuilder tmp = new StringBuilder();
			int i = 0;
			while (Character.isAlphabetic(buffer.charAt(i)) || buffer.charAt(i) == '.') {
				tmp.append(buffer.charAt(i));
				i++;
			}
			String res = tmp.toString();
			currentToken = new Token(Token.Type.PARAMETER, res);
		}

		// ########## YOUR CODE ENDS HERE ##########

		// Remove the extracted token from buffer
		int tokenLen = currentToken.getValue().length();
		buffer = buffer.substring(tokenLen);
	}

	/**
	 * returned the current token extracted by {@code next()} **** please do not
	 * modify this part ****
	 * 
	 * @return type: Token
	 */
	public Token current() {
		return currentToken;
	}

	/**
	 * check whether there still exists another tokens in the buffer or not ****
	 * please do not modify this part ****
	 * 
	 * @return type: boolean
	 */
	public boolean hasNext() {
		return currentToken != null;
	}

}