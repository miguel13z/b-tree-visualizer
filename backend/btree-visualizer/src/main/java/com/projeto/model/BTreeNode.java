package com.projeto.model;

import java.util.Arrays;

public class BTreeNode {
	public int[] keys;
	public BTreeNode[] children;
	public int numKeys;
	
	public BTreeNode() {
		this.keys = new int[3];
		this.children = new BTreeNode[4];
		this.numKeys = 0;
	}
	
	public boolean isFull() {
		return numKeys == 3;
	}
	
	public boolean isLeaf() {
		return children[0] == null;
	}

	public void insert(int value) {
		int i = 0;
		while (i < numKeys) {
			if (value < keys[i]) break;
			i++;
		}
		shiftRightKeys(i);
		keys[i] = value;
		
		numKeys++;
	}
	
	@Override
	public String toString() {
		int[] v = new int[numKeys];
		for (int i = 0; i < numKeys; i++) {
			v[i] = keys[i];
		}
		
		return Arrays.toString(v);
	}
	
	public void shiftRightChildren(int index) {
		for (int i = numKeys; i >= index; i--) {
			children[i + 1] = children[i];
		}
	}
	
	public void shiftRightKeys(int index) {
		for (int i = numKeys - 1; i >= index; i--) {
			keys[i + 1] = keys[i];
		}
	}
}

