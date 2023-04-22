package dsa.bst;

import java.util.LinkedList;
import java.util.Queue;


public class Node {
private int data;
private Node left;
private Node right;


public Node(int data) {
	super();
	this.data = data;
}

public static void levelOrder(Node root) {
	Queue<Node> queue = new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty()) {
		Node node = queue.poll();
		System.out.print(node.data+" ");
		if(node.left!=null) {
			queue.add(node.left);
		}
		if(node.right!=null) {
			queue.add(node.right);
		}
	}
}

public static void preOrder(Node root) {
	if(root==null)
		return;
	System.out.print(root.data+" ");
	preOrder(root.left);
	preOrder(root.right);
}

public static void postOrder(Node root) {
	if(root==null)
		return;
	postOrder(root.left);
	postOrder(root.right);
	System.out.print(root.data+" ");
}

public static void inOrder(Node root) {
	if(root==null)
		return;
	inOrder(root.left);
	System.out.print(root.data+" ");
	inOrder(root.right);
}

public static boolean search(int data,Node root) {
	if(root==null)
		return false;
	if(root.data == data)
		return true;
	
	if(root.data>data) {
		return search(data,root.left);
	}else {
		return search(data, root.right);
	}
}

public static void main(String[] args) {
	Node root = new Node(10);
	root.left = new Node(5);
	root.right = new Node(15);
	root.right.left = new Node(12);
	root.right.right = new Node(18);
	levelOrder(root);
	System.out.println();
//	System.out.println(search(20, root));
	preOrder(root);
	System.out.println();
	postOrder(root);
	System.out.println();
	inOrder(root);// In BST inorder traversal produce sorted nodes
	
}

}
