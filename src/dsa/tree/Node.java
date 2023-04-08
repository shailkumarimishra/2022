package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
private int key;
private Node left;
private Node right;

public Node(int key) {
	super();
	this.key = key;
}

public static void inOrder(Node root) {
	if(root==null)
		return;
	inOrder(root.left);
	System.out.print(root.key+" ");
	inOrder(root.right);
}

public static void preOrder(Node root) {
	if(root==null)
		return;
	System.out.print(root.key+" ");
	preOrder(root.left);
	preOrder(root.right);
}

/**
 * Time complexity - O(n)
 * @param root
 */
public static void postOrder(Node root) {
	if(root==null)
		return;
	postOrder(root.left);
	postOrder(root.right);
	System.out.print(root.key+" ");
}

public static int getHeight(Node root) {
	if(root==null)
		return 0;
	return Math.max(getHeight(root.left), getHeight(root.right))+1;
}

public static void printKDistanceNodes(Node root, int k) {
	if(root==null)
		return;
	if(k==0)
		System.out.print(root.key+" ");
	else {
		printKDistanceNodes(root.left, k-1);
		printKDistanceNodes(root.right ,k-1);
	}
}

/**
 * Algo:-
 * step 1: create a queue
 * step 2: enqueue root
 * step 3: while queue is not empty 
 * 	       3.1) dequeue and print
 * 		   3.2) enqueue the child nodes
 * @param root
 */
public static void levelOrder(Node root) {
	Queue<Node> queue = new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty()) {
		Node node = queue.poll();
		System.out.print(node.key+" ");
		if(node.left!=null) {
			queue.add(node.left);
		}
		if(node.right!=null) {
			queue.add(node.right);
		}
	}
}

public static void main(String[] args) {
	Node root = new Node(30);
	root.left = new Node(40);
	root.right = new Node(50);
	root.left.left = new Node(70);
	root.right.left = new Node(60);
	root.right.right = new Node(80);
	
	inOrder(root);
	System.out.println();
	preOrder(root);
	System.out.println();
	postOrder(root);
	System.out.println();
	System.out.println(getHeight(root));
	printKDistanceNodes(root, 2);
	System.out.println();
	levelOrder(root);
}
}
