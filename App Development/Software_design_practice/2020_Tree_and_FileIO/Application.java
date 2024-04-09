
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Application {

	public RBTreeQ3<Integer, PersonQ3> createTree(List<PersonQ3> personList) {

		RBTreeQ3<Integer, PersonQ3> tree = new RBTreeQ3<>();

		// ########## YOUR CODE STARTS HERE ##########
		if (personList != null) {
			for (PersonQ3 person : personList) {
				tree.insert(person.getId(), person);
			}
		}
		
		// ########## YOUR CODE ENDS HERE ##########

		return tree;
	}

	public List<PersonQ3> readCsv(String fileName) throws IOException {

		List<PersonQ3> list = new LinkedList<>();

		// ########## YOUR CODE STARTS HERE ##########
		String line = "";
		String splitBy = ";";

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] person = line.split(splitBy);
				System.out.println("ID:"+person[0]+", Name:"+person[1]);

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		// ########## YOUR CODE ENDS HERE ##########

		return list;
	}

	public void saveXML(RBTreeQ3<Integer, PersonQ3> tree) {

		if (tree == null) {
			return;
		}

		List<NodeQ3> list = tree.levelTraversal();

		// ########## YOUR CODE STARTS HERE ##########
		
		

		// ########## YOUR CODE ENDS HERE ##########
	}

}
