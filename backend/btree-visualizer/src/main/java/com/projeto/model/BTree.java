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
	
	private void insertNode(BTreeNode node, int value) {
		if (node.isLeaf()) {
			node.insert(value);
			return;
		}
		
		int i = 0;
		while (i < node.numKeys) {
			if (value < node.keys[i]) break;
			i++;
		}
		
		BTreeNode childrenNode = node.children[i];
		if (childrenNode.isFull()) {
			
		} else {
			insertNode(childrenNode, value);
		}
	}
	
	private void splitChild(BTreeNode parent, int index, BTreeNode fullChild) {
		BTreeNode newNode = new BTreeNode();
		for (int i = (fullChild.numKeys / 2) + 1; i >= fullChild.numKeys - 1; i++) {
			newNode.insert(fullChild.keys[i]);
		}
		
		if (!fullChild.isLeaf()) {
			int j = 0;
			for (int i = (fullChild.children.length / 2); i < fullChild.children.length - 1; i++) {
				newNode.children[j] = fullChild.children[i];
				j++;
			}
		}
		
		parent.shiftRightChildren(index + 1);
		parent.children[index + 1] = newNode;
		
		
	}

}
