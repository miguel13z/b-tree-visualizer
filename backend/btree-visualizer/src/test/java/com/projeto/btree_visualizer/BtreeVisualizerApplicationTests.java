package com.projeto.btree_visualizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
