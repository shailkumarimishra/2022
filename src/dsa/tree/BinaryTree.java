package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;
	private int size;
	
	public void insert(int data) {
		Node newNode = new Node(data, null, null);
		if(root==null) {
			root = newNode;
			size++;
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
		size++;
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
	
	public boolean delete(int data) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			if(currentNode.data==data) {
				//fetch leaf node
				Node leafNode = lastLeafNode();
				//copy leaf node data to current node data
				currentNode.data = leafNode.data;
				//delete leaf node
				deleteLastLeafNode();
				return true;
			}
			if(currentNode.left!=null)
				queue.add(currentNode.left);
			if(currentNode.right!=null)
				queue.add(currentNode.right);
		}
		return false;
	}
	
	/**
	 * Note:- 
	 * 		 1. if left node is not null of current node but right node is null then last leaf node is currentNode.left
	 * 		 2. if left & right node of current node is null then last leaf node is right node of previous node.
	 */
	private void deleteLastLeafNode() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node prevNode=null;
		Node currentNode=null;
		while(!queue.isEmpty()) {
			prevNode = currentNode;
			currentNode = queue.poll();
			if(currentNode.left==null) {
				prevNode.right=null;
				return;
			}else if(currentNode.right==null) {
				currentNode.left=null;
				return;
			}
			queue.add(currentNode.left);
			queue.add(currentNode.right);
			
		}
	}
	public void printAllLeafNodes() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
			if(node.left==null && node.right==null)
				System.out.print(node.data+" ");
			
		}
	}
	
	private Node lastLeafNode() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node currentNode = null;
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			if(currentNode.left!=null)
				queue.add(currentNode.left);
			if(currentNode.right!=null)
				queue.add(currentNode.right);
		}
		return currentNode;
	}
	
	public void deleteAll() {
		root = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public int height() {
		return getHeight(root);
	}
	
	private int getHeight(Node root) {
		if(root==null)
			return 0;
		
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}

	public int deleteLeaf() {
		
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
