public class Node {

	public Key key;
	public Node left;
	public Node right;

	public Node(Key key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public Key getKey() {
		return key;
	}

	public Node getRight() {return right;}

	public Node getLeft() {return left;}
}
