package dsa.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	private Node root;

	public void insert(int data) {
		root = insert(root, data);
	}
	
	/**
	 * if root is null then  return the node
	 * if current node is less than root node, do recursion on left sub tree and update the root.left
	 * if current node is greater than root node, do recursion on right sub tree and updated the root.right
	 * finally return the updated root
	 * @param root
	 * @param data
	 * @return updated root
	 */
	private Node insert(Node root, int data) {
		if (root == null)
			return new Node(data, null, null);
		if (root.data > data)
			root.left = insert(root.left, data);
		if (root.data < data)
			root.right = insert(root.right, data);
		return root;

	}
	
	public void delete(int data) {
		root = delete(root,data);
		
	}

	private Node delete(Node root, int data) {
		if(root==null)
			return root;
		if(root.data>data) {
			root.left = delete(root.left, data);
		}else if(root.data<data) {
			root.right = delete(root.right, data);
		}else {
			if(root.left==null) {
				return root.right;
			}else if(root.right==null) {
				return root.left;
			}else {
				Node successor = getSuccessor(root);
				root.data=successor.data;
				root.right=delete(root.right, successor.data);
			}
		}
		return root;
	}
	
    public Node getSuccessor(Node currentNode) {
    	currentNode=currentNode.right;
    	while(currentNode!=null && currentNode.left!=null) {
    		currentNode = currentNode.left;
    	}
    	return currentNode;
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
    
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	private class Node {
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
