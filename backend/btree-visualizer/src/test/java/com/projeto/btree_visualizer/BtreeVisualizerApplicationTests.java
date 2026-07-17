package com.projeto.btree_visualizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto.model.BTree;
import com.projeto.model.BTreeNode;

@SpringBootTest
class BtreeVisualizerApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void btreeNodeVazia() {
		BTreeNode node = new BTreeNode();
		assertEquals("[]", node.toString());
		assertTrue(node.isLeaf());
	}
	
	@Test
	void btreeNodeComElementoUnico() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		assertEquals("[10]", node.toString());
	}
	
	@Test
	void btreeNodeComElementosOrdenados() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		node.insert(20);
		node.insert(30);
		assertEquals("[10, 20, 30]", node.toString());
	}
	
	@Test
	void btreeNodeComElementosDesordenados() {
		BTreeNode node = new BTreeNode();
		node.insert(30);
		node.insert(20);
		node.insert(10);
		assertEquals("[10, 20, 30]", node.toString());
	}
	
	@Test
	void btreeNodeComElementosIguais() {
		BTreeNode node = new BTreeNode();
		node.insert(30);
		node.insert(30);
		node.insert(30);
		assertEquals("[30, 30, 30]", node.toString());
	}
	
	@Test
	void btreeNodeComElementos() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		node.insert(30);
		node.insert(20);
		assertEquals("[10, 20, 30]", node.toString());
	}
	
	@Test
	void btreeNodeComDoisElementosEmOrdem() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		node.insert(40);
		assertEquals("[10, 40]", node.toString());
	}
	
	@Test
	void btreeNodeComDoisElementosDesordenados() {
		BTreeNode node = new BTreeNode();
		node.insert(40);
		node.insert(10);
		assertEquals("[10, 40]", node.toString());
	}
	
	@Test
	void btreeVazia() {
		BTree tree = new BTree();
		assertEquals("vazia", tree.toString());
		assertEquals(0 , tree.getSize());
		assertTrue(tree.isEmpty());
	}
	
	@Test
	void btreeElementoUnico() {
		BTree tree = new BTree();
		tree.add(100);
		assertEquals("[100]", tree.toString());
		assertEquals(1 , tree.getSize());
		assertTrue(!tree.isEmpty());
	}
	
	@Test
	void btreeRaizCheia() {
		BTree tree = new BTree();
		tree.add(200);
		tree.add(300);
		tree.add(100);
		assertEquals("[100, 200, 300]", tree.toString());
		assertEquals(3 , tree.getSize());
		assertTrue(!tree.isEmpty());
	}
	
	@Test
	void btreeSplitRaiz() {
		BTree tree = new BTree();
		tree.add(200);
		tree.add(300);
		tree.add(100);
		tree.add(500);
		assertEquals("[200], [100], [300, 500]", tree.toString());
		assertEquals(4 , tree.getSize());
		assertTrue(!tree.isEmpty());
	}
	
	@Test
	void btreeAdiçãoDecrescente() {
		BTree tree = new BTree();
		for (int i = 10; i >= 0; i--) {
			tree.add(i);
		}
		assertEquals("[7], [3, 5], [0, 1, 2], [4], [6], [9], [8], [10]", tree.toString());
		assertEquals(11 , tree.getSize());
		assertTrue(!tree.isEmpty());
	}
	
	@Test
	void btreeAdiçãoCrescente() {
		BTree tree = new BTree();
		for (int i = 10; i <= 100; i += 10) {
			tree.add(i);
		}
		assertEquals("[40], [20], [10], [30], [60, 80], [50], [70], [90, 100]", tree.toString());
		assertEquals(10 , tree.getSize());
		assertTrue(!tree.isEmpty());
	}
}
