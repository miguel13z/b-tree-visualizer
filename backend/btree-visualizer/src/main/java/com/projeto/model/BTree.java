package com.projeto.model;

public class BTree {
	private BTreeNode root;
	private int size;
	
	public BTree() {
		this.root = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(int value) {
		if (isEmpty()) {
			BTreeNode newNode = new BTreeNode();
			newNode.keys[0] = value;
			root = newNode;
			size++;
		} 
		if (root.isFull()) {
			BTreeNode newRoot = new BTreeNode();
			newRoot.children[0] = root;
			root = newRoot;
		} else {
			
		}
	}
	
	private void insert(BTreeNode node, int value) {
		if (node.isLeaf()) {
			node.insert(value);
		}
	}

}
