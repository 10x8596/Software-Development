
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TreeBuilder {

    public RBTreeQ1<Integer, List<String>> build(String text) {
        // ########## YOUR CODE STARTS HERE ##########
        RBTreeQ1<Integer, List<String>> RBTree = new RBTreeQ1<>();
        List<Token> token = new LinkedList<>();
        MyTokenizer tokenizer = new MyTokenizer(text);

        while (tokenizer.hasNext()) {
            token.add(tokenizer.current());
            tokenizer.next();
        }

        List<String> upperCaseTokens = new LinkedList<>();
        for (Token t : token) {
            if (t.getType() == Token.Type.UPPER_CASE_WORD) {
                upperCaseTokens.add(t.getValue());
            }
        }
        System.out.println("list of Upper case tokens"+upperCaseTokens);

        // add same length words to a new list
        List<String> lst = new LinkedList<>();
        for (int i = 0; i < upperCaseTokens.size()-1; i++) {
            for (int j = i+1; j < upperCaseTokens.size(); j++) {
                if (upperCaseTokens.get(i).length() == upperCaseTokens.get(j).length()) {
                    lst.add(upperCaseTokens.get(i));
                    lst.add(upperCaseTokens.get(j));
                }
            }
        }
        System.out.println("this is lst:"+lst);

        RBTree.insert(lst.get(0).length(), lst);

        for (String s : upperCaseTokens) {
            System.out.println(s.length());
            System.out.println(Collections.singletonList(s));
            RBTree.insert(s.length(), Collections.singletonList(s));
        }


        return RBTree;
        // ########## YOUR CODE ENDS HERE ##########
    }




}
