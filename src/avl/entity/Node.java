package avl.entity;

public class Node {

	protected int value;
	protected int height;
	protected Node left;
	protected Node right;

	public Node(int value) {
		this.value = value;
	}

	public boolean isLeaf() {
		return !hasLeft() && !hasRight();
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public String toString() {
		return Integer.toString(value);
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
}
