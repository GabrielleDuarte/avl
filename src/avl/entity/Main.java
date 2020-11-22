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
		
		BinarySearchTree full = new BinarySearchTree();
		BinarySearchTree full1 = new BinarySearchTree();
		BinarySearchTree completeNotFull = new BinarySearchTree();
		BinarySearchTree avl = new BinarySearchTree();
		
		  full.add(10);
		  full.add(5);
		  full.add(15);
		  full.add(3);
		  full.add(8);
		  full.add(2);
		  full.add(4);
		  full.add(6);
		  full.add(9);
		  full.add(13);
		  full.add(18);
		  full.add(12);
		  full.add(14);
		  full.add(18);
		  full.add(16);
		  full.add(19);
		  
		  full1.add(25);
		  full1.add(20);
		  full1.add(36);
		  full1.add(10);
		  full1.add(22);
		  full1.add(30);
		  full1.add(40);
		  full1.add(5);
		  full1.add(12);
		  full1.add(21);
		  full1.add(23);
		  full1.add(28);
		  full1.add(31);
		  full1.add(38);
		  full1.add(48);
		  
		  completeNotFull.add(100);
		  completeNotFull.add(20);
		  completeNotFull.add(130);
		  completeNotFull.add(8);
		  completeNotFull.add(50);
		  completeNotFull.add(4);
		  completeNotFull.add(9);
		  completeNotFull.add(126);
		  completeNotFull.add(112);
		  completeNotFull.add(170);
		  
		  avl.add(4);
		  avl.add(2);
		  avl.add(6);
		  avl.add(1);
		  avl.add(3);
		  avl.add(5);
		  avl.add(7);
		  avl.add(15);
		  avl.add(14);
		  //avl.add(12);
		  
		  
		  
		  //avl.leftRotation();
		  
		
		
	}
}
