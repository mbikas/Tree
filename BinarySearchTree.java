package com.bikas;

import java.util.Vector;

public class BinarySearchTree {

	public static void main(String[] args) {
		

	}
	
	

	static Node Insert(Node root,int value)
    {
        Node n = new Node();
        n.data = value;
        if (root == null) return n;
        
        Node current = root;
        while (current != null){
        	if (value < current.data){
        		if (current.left == null) {
        			current.left = n;
        			return root;
        		}
        		current = current.left;
        	}
        	else{
        		if (current.right == null) {
        			current.right = n;
        			return root;
        		}
        		current = current.right;
        	}
        }
        return root;
	       
    }
	
	void preOrder(Node root) {
		if (root == null) return;
	    System.out.print(root.data + " ");
	    preOrder(root.left);
	    preOrder(root.right);
	}
	
	void postOrder(Node root) {
		if (root == null) return;
	    postOrder(root.left);
	    postOrder(root.right);
	    System.out.print(root.data + " ");

	}
	
	void inOrder(Node root) {
		if (root == null) return;
		inOrder(root.left);
	    System.out.print(root.data + " ");
	    inOrder(root.right);
	}
	
	
	int height(Node root)
    {
       if (root == null) return -1;
       return 1 + Math.max(height(root.left), height(root.right));
		
    }
	
	void goLeft(Node node){
		if (node.left != null) goLeft(node.left);
		System.out.print(node.data + " ");
	}
	void goRight(Node node){
		System.out.print(node.data + " ");
		if (node.right != null) goRight(node.right);
		
	}
	void top_view(Node root)
    {
		if (root.left != null){
			goLeft(root.left);
		}
		System.out.print(root.data + " ");
		if (root.right != null){
			goRight(root.right);
		}
    }
	
	void LevelOrder(Node root)
	{
		if (root == null) return;
		
		//3 5 2 
		//|2 1 4|
		//using  queue like technique (FIFO)
		Vector<Node> nodes = new Vector<Node>();
		nodes.add(root);
		while (nodes.size() > 0){
			Node n = nodes.remove(0);
			System.out.print(n.data + " ");
			if(n.left != null){
				nodes.add(n.left);
			}
			if(n.right != null){
				nodes.add(n.right);
			}
		}

	}
	
	//huffman decoding
	void decode(String S ,Node root)
    {
		if (root == null) return; 
	    String decodedString = "";
	    int currentIndex = 0;

	    Node current = root;
	    for (int i= currentIndex;i<S.length();i++){

	        if (S.charAt(i) == '0'){
	            current = current.left;
	        }
	        else{
	            current = current.right;
	        }
	        if (current.data != '\0'){
	            decodedString += String.valueOf(current.data);
	            current = root;
	        }
	    }

	    System.out.println(decodedString);  
        

       
    }
	
	static Node lca(Node root,int v1,int v2)
    {
		if (root.data < v1 && root.data < v2){
			return lca(root.right,v1,v2);
		}
		if (root.data > v1 && root.data > v2){
			return lca(root.left,v1,v2);
		}
		
		return root;
       
    }
	
	boolean checkBST(Node root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
    
		if (root.data < minValue || root.data > maxValue) {
			return false;
		}
	    
	    return (    checkBST(root.left, minValue, root.data - 1) 
	            &&  checkBST(root.right, root.data + 1, maxValue)
	            );
	}
	    
	boolean checkBST(Node root) {
	    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	
	
	public static class Node
	{
		int data;
	    Node left;
	    Node right;
	}
}