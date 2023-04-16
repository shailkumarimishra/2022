package dsa.tree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(30);
		bt.insert(40);
		bt.insert(50);
		bt.insert(70);
		bt.insert(60);
		bt.insert(80);
		bt.levelOrder();
		System.out.println();
//		bt.preOrder(bt.getRoot());
//		System.out.println();
//		bt.postOrder(bt.getRoot());
//		System.out.println();
//		bt.inOrder(bt.getRoot());
//		System.out.println();
//		System.out.println(bt.search(80));
//		bt.printLeafNodes();
//		System.out.println();
//		System.out.println(bt.size());
//		System.out.println(bt.height());
		bt.delete(30);
		bt.levelOrder();
		System.out.println();
		bt.printAllLeafNodes();
		System.out.println();
		bt.delete(40);
		bt.levelOrder();
		
		
	}

}
