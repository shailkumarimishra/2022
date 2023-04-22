package dsa.bst;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(12);
		bst.insert(18);
//		bst.inOrder();
//		System.out.println();
		bst.levelOrder();
		System.out.println();
		bst.delete(10);
//		bst.delete(15);
//		bst.delete(10);
		bst.levelOrder();
		System.out.println();
		bst.inOrder();
	}

}
