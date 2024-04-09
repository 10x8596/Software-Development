
/**
 * Base class for node
 *
 * @param <K, T> data type
 */
public class NodeQ1<K extends Comparable<K>, T>
{
	ColorQ1 color;			// Node color
	K key;					// Node key
	T data;					// Node associated data
	NodeQ1<K, T> parent; 		// Parent node
	NodeQ1<K, T> left, right; 	// Children nodes

	public NodeQ1(K key, T data)
	{
		this.key  	= key;
		this.data  	= data;
		this.color = ColorQ1.RED; //property 3 (if a node is read, both children are black) may be violated if parent is red
		this.parent = null;

		// Initialise children leaf nodes
		this.left 			= new NodeQ1<K, T>();  //leaf node
		this.right 			= new NodeQ1<K, T>();  //leaf node
		this.left.parent 	= this; //reference to parent
		this.right.parent 	= this; //reference to parent
	}

	// Leaf node
	public NodeQ1()
	{
		this.key 	= null; //leaf nodes are null
		this.data 	= null; //leaf nodes are null
		this.color = ColorQ1.BLACK; //leaf nodes are always black
	}
}