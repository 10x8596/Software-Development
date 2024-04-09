
public class MyTokenizer implements Tokenizer {

    private String buffer;		//save text
    private Token currentToken;	//save token extracted from next()

    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToken
     *  **** please do not modify this part ****
     */
    public MyTokenizer(String text) {
    	buffer = text;		// save input text (string)
    	next();		// extracts the first token.
    }

    /**
     *  This function will find and extract a next token from {@code buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() {


        buffer = buffer.trim(); // remove whitespace

         if(buffer.isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
         }

        // ########## YOUR CODE STARTS HERE ##########
//        char firstChar = buffer.charAt(0);
//        // Check for LOWER_CASE_WORD
//        if (isAllLower(buffer)) {
//            currentToken = new Token(buffer, Token.Type.LOWER_CASE_WORD);
//            return;
//        }
//        // Check for UPPER_CASE_WORD
//        if (isAllUpper(buffer)) {
//            currentToken = new Token(buffer, Token.Type.UPPER_CASE_WORD);
//            return;
//        }
//        // Check for INTEGER_NUMBER
//        if (Character.isDigit(firstChar)) {
//            String num = "";
//            for (int i = 0; i < buffer.length(); i++) {
//                if (Character.isDigit(buffer.charAt(i))) {num += buffer.charAt(i);}
//                else {
//                    // check for decimals
//                    if (buffer.charAt(i) == '.') {
//                        num += '.';
//                        if (Character.isDigit(buffer.charAt(i))) {num += buffer.charAt(i);}
//                    }
//                    // break if first char not a digit
//                    break;
//                }
//                currentToken = new Token(num, Token.Type.INTEGER_NUMBER);
//            }
//            return;
//        }
//        // Check for NON_ALPHANUMERIC
//        if (isAlphaNumeric(buffer)) {
//            currentToken = new Token(buffer, Token.Type.NON_ALPHANUMERIC);
//            return;
//        }
//        // Check for Long Camel Case
//        // using Regex
//        String camelCasePattern = "([a-z]+[A-Z]+\\w+)+";
//        if (buffer.matches(camelCasePattern)) {
//            currentToken = new Token(buffer, Token.Type.LONG_CAMEL_CASE_WORD);
//            return;
//        }
//        // Check for Short Camel Case
//        if (isShortCamelCase(buffer)) {
//            currentToken = new Token(buffer, Token.Type.SHORT_CAMEL_CASE_WORD);
//            return;
//        }

        char firstChar = buffer.charAt(0);

        if (Character.isDigit(firstChar)) {
            int pos = 0;
            while (pos < buffer.length() && Character.isDigit(buffer.charAt(pos))) {
                pos ++;
            }
            currentToken = new Token(buffer.substring(0, pos), Token.Type.INTEGER_NUMBER);
        }

        if (Character.isUpperCase(firstChar)){
            StringBuilder stringBuilder =  new StringBuilder();
            int pos = 0 ;
            char current = buffer.charAt(pos);
            boolean isCamel = false;

            while (pos < buffer.length() && Character.isLetter(buffer.charAt(pos))) {
                current = buffer.charAt(pos);
                if (Character.isLowerCase(current)){
                    isCamel = true;
                }
                stringBuilder.append(current);
                pos ++;
            }

            if (isCamel){
                if (stringBuilder.toString().length()<=3){
                    currentToken = new Token(stringBuilder.toString(), Token.Type.SHORT_CAMEL_CASE_WORD);
                } else {
                    currentToken = new Token(stringBuilder.toString(), Token.Type.LONG_CAMEL_CASE_WORD);
                }
            } else {
                currentToken = new Token(stringBuilder.toString(), Token.Type.UPPER_CASE_WORD);
            }
        }

        if (Character.isLowerCase(firstChar)){
            StringBuilder stringBuilder =  new StringBuilder();
            int pos = 0 ;
            char current = buffer.charAt(pos);
            boolean isCamel = false;

            while (pos < buffer.length() && Character.isLetter(buffer.charAt(pos))) {
                current = buffer.charAt(pos);
                if (Character.isUpperCase(current)){
                    isCamel = true;
                }
                stringBuilder.append(current);
                pos ++;
            }

            if (isCamel){
                if (stringBuilder.toString().length()<=3){
                    currentToken = new Token(stringBuilder.toString(), Token.Type.SHORT_CAMEL_CASE_WORD);
                } else {
                    currentToken = new Token(stringBuilder.toString(), Token.Type.LONG_CAMEL_CASE_WORD);
                }
            } else {
                currentToken = new Token(stringBuilder.toString(), Token.Type.LOWER_CASE_WORD);
            }
        }

        if (!Character.isLetter(firstChar) && !Character.isDigit(firstChar)){
            currentToken = new Token(Character.toString(firstChar), Token.Type.NON_ALPHANUMERIC);
        }

        // ########## YOUR CODE ENDS HERE ##########
        
        // Remove the extracted token from buffer
        int tokenLen = currentToken.getLength();
        buffer = buffer.substring(tokenLen);
    }

    /**
     *  returned the current token extracted by {@code next()}
     *  **** please do not modify this part ****
     *  
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  **** please do not modify this part ****
     *  
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }


    private static boolean isAllUpper(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private static boolean isAllLower(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) && Character.isLowerCase(c)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private static boolean isAlphaNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private static boolean isShortCamelCase(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }


}