package avl.entity;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree {

	protected Node root;

	private void updateHeight(Node node, int value) {
		if (value > node.value) {
			updateHeight(node.right, value);
		} else if (value < node.value) {
			updateHeight(node.left, value);
		}
		int l = 0;
		if (node.hasLeft()) {
			l = node.left.height;
		}
		int r = 0;
		if (node.hasRight()) {
			r = node.right.height;
		}
		node.height = 1 + Math.max(l, r);
	}

	private boolean isAVL(Node node) {
		if (node != null) {
			int l = 0;
			if (node.hasLeft()) {
				l = node.left.height;
			}
			int r = 0;
			if (node.hasRight()) {
				r = node.right.height;
			}

			boolean isavl = Math.abs(l - r) <= 1;
			if (isavl) {
				isavl = isAVL(node.left) && isAVL(node.right);
			}
			return isavl;
		}
		return true;
	}

	public boolean isAVL() {
		return root == null ? true : isAVL(root);
	}

	private boolean add(Node node, int value) {
		if (value > node.value) {
			if (node.hasRight()) {
				return add(node.right, value);
			} else {
				Node newNode = new Node(value);
				newNode.height = 1;
				node.right = newNode;
				return true;
			}
		} else if (value < node.value) {
			if (node.hasLeft()) {
				return add(node.left, value);
			} else {
				Node newNode = new Node(value);
				newNode.height = 1;
				node.left = new Node(value);
				return true;
			}
		}
		return false;
	}

	public boolean add(int value) {
		if (isEmpty()) {
			root = new Node(value);
		} else {
			add(root, value);
		}
		updateHeight(root, value);
		return true;
	}

	private boolean contains(Node node, int value) {
		if (value < node.value && node.hasLeft()) {
			return contains(node.left, value);
		} else if (value > node.value && node.hasRight()) {
			return contains(node.right, value);
		} else {
			return node.value == value;
		}
	}

	public boolean contains(int value) {
		return root == null ? false : contains(root, value);
	}

	public boolean isFull(Node node, int level, int lastLevel) {
		//return size() == Math.pow(2, height()) - 1;

		if (node.hasLeft() && node.hasRight()) {
			return isFull(node.left, level + 1, lastLevel) && isFull(node.right, level + 1, lastLevel);
		} else if (!node.hasLeft() && node.hasRight()) {
			return level == lastLevel && isFull(node.right, level + 1, lastLevel);
		} else if (node.hasLeft() && !node.hasRight()) {
			return level == lastLevel && isFull(node.left, level + 1, lastLevel);
		} else {
			return level == lastLevel;
		}
	}

	public boolean isFull() {
		return root == null ? true : isFull(root, 1, height());
	}

	private boolean isComplete(Node node, int level, int lastLevel) {
		if (node == null) {
			return true;
		} else if (node.hasLeft() && node.hasRight()) {
			return isComplete(node.left, level + 1, lastLevel) && isComplete(node.right, level + 1, lastLevel);
		} else if (node.hasLeft()) {
			return level == lastLevel - 1 && isComplete(node.left, level + 1, lastLevel);
		} else if (node.hasRight()) {
			return level == lastLevel - 1 && isComplete(node.right, level + 1, lastLevel);
		} else {
			return level == lastLevel || level == lastLevel-1;
		}
	}

	protected boolean isStrictComplete(Node node, int index, int size) {
		if (node == null) {
			return true;
		}
		if (index >= size) {
			return false;
		}
		int count = 2 * index + 1;
		return isStrictComplete(node.left, count, size) && isComplete(node.right, count + 1, size);
	}

	public boolean isComplete() {
		return isComplete(root, 1, height());
	}

	private int height(Node node) {
		return node == null ? 0 : 1 + Math.max(height(node.left), height(node.right));
	}

	public int height() {
		return height(root);
	}

	private int size(Node node) {
		return node == null ? 0 : 1 + size(node.left) + size(node.right);
	}

	public int size() {
		return size(root);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void inOrder(Visitor visitor) {
		inOrder(root, visitor);
	}

	private void inOrder(Node node, Visitor visitor) {
		if (node != null) {
			inOrder(node.left, visitor);
			visitor.visit(node.value, node.height);
			inOrder(node.right, visitor);
		}
	}

	public void preOrder(Visitor visitor) {
		preOrder(root, visitor);
	}

	private void posOrder(Node node, Visitor visitor) {
		if (node != null) {
			posOrder(node.left, visitor);
			posOrder(node.right, visitor);
			visitor.visit(node.value, node.height);
		}
	}

	public void posOrder(Visitor visitor) {
		posOrder(root, visitor);
	}

	private void preOrder(Node node, Visitor visitor) {
		if (node != null) {
			System.out.print("("); //TODO print
			visitor.visit(node.value, node.height);
			preOrder(node.left, visitor);
			preOrder(node.right, visitor);
			System.out.print(")"); //TODO print
		}
	}

	public void levelOrder(Visitor visitor) {
		Deque<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();
			visitor.visit(node.value, node.height);
			if (node.hasLeft()) {
				queue.addLast(node.left);
			}
			if (node.hasRight()) {
				queue.addLast(node.right);
			}
		}
	}
}
