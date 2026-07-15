package com.projeto.model;

public class BTreeNode {
	public int[] keys;
	public BTreeNode[] children;
	public int numKeys;
	
	public BTreeNode() {
		this.keys = new int[3];
		this.children = new BTreeNode[4];
		this.numKeys = 0;
	}
	
	public boolean isLeaf() {
		return children[0] == null;
	}
	
	public Pair search(int target) {
		int index = 0;
		while (index < numKeys) {
			if (target <= keys[index]) break;
			index++;
		}
	}
}

