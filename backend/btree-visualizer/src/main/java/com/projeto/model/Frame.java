package com.projeto.model;

public class Frame {
	private BTreeNode stateTree;
	private String idBTreeNode;
	private int indexKey;
	private String status;
	private String caption;
	
	public Frame(BTreeNode stateTree, String idBTreeNode, int indexKey, String status, String caption) {
		this.stateTree = stateTree;
		this.idBTreeNode = idBTreeNode;
		this.indexKey = indexKey;
		this.status = status;
		this.caption = caption;
	}

	public BTreeNode getStateTree() {
		return stateTree;
	}

	public void setStateTree(BTreeNode stateTree) {
		this.stateTree = stateTree;
	}

	public String getIdBTreeNode() {
		return idBTreeNode;
	}

	public void setIdBTreeNode(String idBTreeNode) {
		this.idBTreeNode = idBTreeNode;
	}

	public int getIndexKey() {
		return indexKey;
	}

	public void setIndexKey(int indexKey) {
		this.indexKey = indexKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Override
	public String toString() {
		return "Frame [stateTree=" + stateTree + ", idBTreeNode=" + idBTreeNode + ", indexKey=" + indexKey + ", status="
				+ status + ", caption=" + caption + "]";
	}
	
}
