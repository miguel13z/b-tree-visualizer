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
		shiftRight(i);
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
	
	private void shiftRight(int index) {
		for (int i = 1; i >= index; i--) {
			swapKeys(i, i + 1);
		}
	}
	
	private void swapKeys(int index1, int index2) {
		int aux = keys[index1];
		keys[index1] = keys[index2];
		keys[index2] = aux;
	}
}

