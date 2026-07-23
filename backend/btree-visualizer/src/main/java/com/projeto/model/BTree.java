package com.projeto.model;

public class BTree {
	private BTreeNode root;
	private int size;
	
	public BTree() {
		this.root = null;
		this.size = 0;
	}
	
	public BTree(int[] v) {
		this.root = null;
		this.size = 0;
		
		for (int value : v) {
			add(value);
		}
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
			newNode.insert(value);
			root = newNode;
			size++;
			
			return;
		} 
		
		size++;
		if (root.isFull()) {
			BTreeNode newRoot = new BTreeNode();
			newRoot.children[0] = root;
			splitChild(newRoot, 0, root);
			insertNode(newRoot, value);
			root = newRoot;
		} else {
			insertNode(root, value);
		}
	}
	
	public Pair search(int target) {
		if (isEmpty()) return null;
		return search(target, root);
	}
	
	public void remove(int target) {
		if (isEmpty()) return;
		removeNode(root, target);
		
		if (root.numKeys == 0 && !root.isLeaf()) {
	        root = root.children[0];
	    }
	}
	
	private void removeNode(BTreeNode current, int target) {
		int index = current.indexOf(target);
		if (index != -1) {
			if (current.isLeaf()) {
				current.removeIndex(index);
				size--;
			} else {
				int predecessor = getPredecessor(current, index);
				current.keys[index] = predecessor;
				removeNode(current.children[index], predecessor);
				if (current.children[index].isEmpty()) {
					fixUnderflow(current, index);
				}
			}
			return;
		}
		
		if (current.isLeaf()) return;
		
		index = 0;
		while (index < current.numKeys) {
			if (target <= current.keys[index]) break;
			index++;
		}
		removeNode(current.children[index], target);
		
		if (current.children[index].isEmpty()) {
            fixUnderflow(current, index);
        }
	}
	
	private void fixUnderflow(BTreeNode parent, int childIndex) {
		if (childIndex > 0 && parent.children[childIndex - 1].numKeys > 1) {
			borrowFromLeft(parent, childIndex);
			return;
		}
		if (childIndex < parent.numKeys && parent.children[childIndex + 1].numKeys > 1) {
			borrowFromRight(parent, childIndex);
			return;
		}
		if (childIndex == parent.numKeys) {
	        merge(parent, childIndex - 1);
	    } else {
	        merge(parent, childIndex);
	    }
	}
	
	private void merge(BTreeNode parent, int childIndex) {
		BTreeNode leftBrother = parent.children[childIndex];
		leftBrother.keys[leftBrother.numKeys] = parent.keys[childIndex];
		
		BTreeNode rightBrother = parent.children[childIndex + 1];
		for (int i = 0; i < rightBrother.numKeys; i++) {
			leftBrother.keys[leftBrother.numKeys + 1 + i] = rightBrother.keys[i];
		}
		
		if (!rightBrother.isLeaf()) {
			for (int i  = 0; i < rightBrother.numKeys + 1; i++) {
				leftBrother.children[leftBrother.numKeys + 1 + i] = rightBrother.children[i];
			}
		}
		
		parent.shiftLeftKeys(childIndex);
		parent.shiftLeftChildren(childIndex + 1);
		
		leftBrother.numKeys += rightBrother.numKeys + 1;
		parent.numKeys -= 1;
	}

	private void borrowFromRight(BTreeNode parent, int childIndex) {
		BTreeNode childNode = parent.children[childIndex];
		childNode.keys[0] = parent.keys[childIndex];
		
		BTreeNode rightBrother = parent.children[childIndex + 1];
		int firstKey = rightBrother.keys[0];
		parent.keys[childIndex] = firstKey;
		
		rightBrother.shiftLeftKeys(0);
		if (!rightBrother.isLeaf()) {
			BTreeNode firstChildren = rightBrother.children[0];
			childNode.children[childNode.numKeys + 1] = firstChildren;
		}
		rightBrother.shiftLeftChildren(0);
		
		rightBrother.numKeys -= 1;
		childNode.numKeys += 1;
	}

	private void borrowFromLeft(BTreeNode parent, int childIndex) {
		BTreeNode childNode = parent.children[childIndex];
		childNode.shiftRightKeys(0);
		if (!childNode.isLeaf()) {
			childNode.shiftRightChildren(0);
		}
		
		childNode.keys[0] = parent.keys[childIndex - 1];
		
		BTreeNode leftBrother = parent.children[childIndex - 1];
		int lastKey = leftBrother.keys[leftBrother.numKeys - 1];
		parent.keys[childIndex - 1] = lastKey;
		
		if (!childNode.isLeaf()) {
			childNode.children[0] = leftBrother.children[leftBrother.numKeys];
		}
		
		leftBrother.numKeys -= 1;
		childNode.numKeys += 1;
	}

	private int getPredecessor(BTreeNode node, int index) {
		BTreeNode left = node.children[index];
		return getMax(left);
	}
	
	private int getMax(BTreeNode node) {
		if (node.isLeaf()) return node.keys[node.numKeys - 1];
		else return getMax(node.children[node.numKeys]);
	}

	private Pair search(int target, BTreeNode current) {
		int i = 0;
		while (i < current.numKeys) {
			if (target <= current.keys[i]) break;
			i++;
		}
		
		if (i < current.numKeys && current.keys[i] == target) return new Pair(current, i);
		if (current.isLeaf()) return null;
		return search(target, current.children[i]);
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "[]";
		StringBuilder sb = new StringBuilder();
		toStringCurrentNode(root, sb);
		return sb.substring(0, sb.length() - 2).toString();
	}
	
	private void toStringCurrentNode(BTreeNode current, StringBuilder sb) {
		sb.append(current.toString() + ", ");
		if (current.isLeaf()) return;
		for (int i = 0; i <= current.numKeys; i++) {
			toStringCurrentNode(current.children[i], sb);
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
			splitChild(node, i, childrenNode);
			if (value > node.keys[i]) i++;
			insertNode(node.children[i], value);
		} else {
			insertNode(childrenNode, value);
		}
	}
	
	private void splitChild(BTreeNode parent, int index, BTreeNode fullChild) {
		BTreeNode newNode = new BTreeNode();
		for (int i = (fullChild.numKeys / 2) + 1; i < fullChild.numKeys; i++) {
			newNode.insert(fullChild.keys[i]);
		}
		
		if (!fullChild.isLeaf()) {
			int j = 0;
			for (int i = (fullChild.numKeys - 1) / 2 + 1; i <= fullChild.numKeys; i++) {
				newNode.children[j] = fullChild.children[i];
				j++;
			}
		}
		
		parent.shiftRightChildren(index + 1);
		parent.children[index + 1] = newNode;
		
		parent.shiftRightKeys(index);
		parent.keys[index] = fullChild.keys[(fullChild.numKeys - 1) / 2];
		
		newNode.numKeys = fullChild.numKeys - (fullChild.numKeys - 1) / 2 - 1;
		fullChild.numKeys = (fullChild.numKeys - 1) / 2;
		parent.numKeys += 1;
	}

}
