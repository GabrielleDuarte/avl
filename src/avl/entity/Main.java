package avl.entity;

class PrintVisitor implements Visitor {
	@Override
	public void visit(int element, int height) {
		System.out.print( element + " ["+height+"]");
	}
}

public class Main {	

	public static void main(String[] args) {
		Visitor visitor = new PrintVisitor();

		BinarySearchTree tree = new BinarySearchTree();
		
		tree.preOrder(visitor);
	}
}
