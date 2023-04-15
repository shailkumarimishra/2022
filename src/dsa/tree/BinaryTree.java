package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;
	
	public void insert(int data) {
		Node newNode = new Node(data, null, null);
		if(root==null) {
			root = newNode;
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.left==null) {
				node.left = newNode;
				break;
			}else if(node.right == null) {
				node.right = newNode;
				break;
			}else {
				queue.add(node.left);
				queue.add(node.right);
			}
			
		}
		
	}
	
	public void preOrder(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(Node root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public void inOrder(Node root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public void levelOrder() {
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
	
	public Node getRoot() {
		return root;
	}
	
	public boolean search(int data) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.data==data)
				return true;
			if(node.left!=null) {
				queue.add(node.left);
			}
			if(node.right!=null) {
				queue.add(node.right);
			}
		}
		return false;
	}
	
	public int delete(int data) {
		//Todo
		return -1;
	}
	
	public void printLeafNodes() {
		//Todo
	}
	
	public void deleteAll() {
		//Todo
	}
	
	public int size() {
		//Todo
		return -1;
	}
	
	public int height() {
		//Todo
		return -1;
	}
	
	public int deleteLeaf() {
		//Todo
		return -1;
	}
private class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
}
