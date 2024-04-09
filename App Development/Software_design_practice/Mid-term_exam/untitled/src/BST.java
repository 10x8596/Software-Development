import java.util.ArrayList;
import java.util.List;

public class BST {

	private Node root;

	public BST() {
		this.root = null;
	}

	public void insert(Key key) {
		Node parent = null;
		Node current = this.root;
		while (current != null) {
			if (current.key.compareTo(key) < 0) {
				parent = current;
				current = current.right;
			} else if (current.key.compareTo(key) > 0) {
				parent = current;
				current = current.left;
			}
		}

		if (parent == null) {
			this.root = new Node(key);
		} else {
			Node newNode = new Node(key);
			if (parent.key.compareTo(key) < 0) {
				parent.right = newNode;
			} else if (parent.key.compareTo(key) > 0) {
				parent.left = newNode;
			}
		}
	}

	public List<Key> invertedInOrder() {
		// TODO
		// HINT: Use recursion
		// START YOUR CODE
		List <Key> keyList = new ArrayList<>();
		inOrder(root, keyList);
		return keyList;
	}

	private void inOrder(Node root, List<Key> keyList) {
		if (root == null) {return;}
		inOrder(root.getRight(), keyList);
		System.out.println("right:"+root.getKey());
		keyList.add(root.getKey());
		inOrder(root.getLeft(), keyList);
		System.out.println("left:"+root.getKey());
		System.out.println(keyList);
		// END YOUR CODE

	}
}