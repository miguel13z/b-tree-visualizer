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
		assertEquals("[]", tree.toString());
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
	
	@Test
	void btreeInicializadaSemValor() {
		BTree tree = new BTree(new int[] {});
		assertEquals("[]", tree.toString());
	}
	
	@Test
	void btreeInicializadaValorUnico() {
		BTree tree = new BTree(new int[] {1});
		assertEquals( "[1]", tree.toString());
	}
	
	@Test
	void btreeInicializadaDecrescente() {
		BTree tree = new BTree(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
		assertEquals("[7], [3, 5], [0, 1, 2], [4], [6], [9], [8], [10]", tree.toString());
	}
	
	@Test
	void btreeInicializadaCrescente() {
		BTree tree = new BTree(new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100});
		assertEquals("[40], [20], [10], [30], [60, 80], [50], [70], [90, 100]", tree.toString());
	}
	
	@Test
	void btreeBuscaSemElemento() {
		BTree tree = new BTree();
		assertEquals(null, tree.search(13));
		assertTrue(tree.isEmpty());
	}
	
	@Test
	void btreeBuscaComRaizCheia() {
		BTree tree = new BTree();
		tree.add(13);
		tree.add(40);
		tree.add(60);
		assertEquals(null, tree.search(-100));
		assertEquals(0, tree.search(13).index);
		assertEquals(1, tree.search(40).index);
		assertEquals(2, tree.search(60).index);
	}
	
	@Test
	void btreeDoisNiveis() {
		BTree tree = new BTree(new int[] {10, 20, 30, 40, 50, 60, 70, 80});
		assertEquals(2, tree.search(60).index);
		assertEquals(0, tree.search(70).index);
		assertEquals(1, tree.search(80).index);
	}
	
	@Test
	void btreeTresNiveis() {
		BTree tree = new BTree(new int[] {84, 99, 27, 80, 47, 62, 56, 10, 11, 74, 87, 91, 17, 14, 13});
		
		assertEquals(0, tree.search(62).index);
		assertEquals(0, tree.search(11).index);
		assertEquals(0, tree.search(13).index);
		assertEquals(0, tree.search(74).index);
		assertEquals(0, tree.search(87).index);
		
		assertEquals(1, tree.search(17).index);
		assertEquals(1, tree.search(14).index);
		assertEquals(1, tree.search(80).index);
		assertEquals(1, tree.search(91).index);
		
		assertEquals(2, tree.search(47).index);
		assertEquals(2, tree.search(99).index);
	}
	
	@Test
	void btreeNodeRemocaoUmElemento() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		node.remove(0);
		assertTrue(!node.isFull());
		assertTrue(node.isEmpty());
		assertEquals("[]", node.toString());
	}
	
	@Test
	void btreeNodeRemocaoDoisElementos() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		node.insert(20);
		node.remove(0);
		
		assertTrue(!node.isFull());
		assertTrue(!node.isEmpty());
		assertEquals("[20]", node.toString());
	}
	
	@Test
	void btreeNodeRemocaoUltimoElemento() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		node.insert(20);
		node.insert(30);
		node.remove(2);
		
		assertTrue(!node.isFull());
		assertTrue(!node.isEmpty());
		assertEquals("[10, 20]", node.toString());
	}
	
	@Test
	void btreeNodeRemocaoPrimeiroElemento() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		node.insert(20);
		node.insert(30);
		node.remove(0);
		
		assertTrue(!node.isFull());
		assertTrue(!node.isEmpty());
		assertEquals("[20, 30]", node.toString());
	}
	
	@Test
	void btreeNodeRemocaoElementoCentral() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		node.insert(20);
		node.insert(30);
		node.remove(1);
		
		assertTrue(!node.isFull());
		assertTrue(!node.isEmpty());
		assertEquals("[10, 30]", node.toString());
	}
	
	@Test
	void btreeNodeRemocaoSeguidaDaAdicao() {
		BTreeNode node = new BTreeNode();
		node.insert(10);
		node.insert(20);
		node.insert(30);
		node.remove(1);
		
		assertTrue(!node.isFull());
		assertTrue(!node.isEmpty());
		assertEquals("[10, 30]", node.toString());
		
		node.insert(15);
		assertTrue(node.isFull());
		assertTrue(!node.isEmpty());
		assertEquals("[10, 15, 30]", node.toString());
	}
	
	@Test
	void btreeRemoveEmArvoreVazia() {
		BTree tree = new BTree();
		assertTrue(tree.isEmpty());
		assertEquals("[]", tree.toString());
		tree.remove(20);
		assertTrue(tree.isEmpty());
		assertEquals("[]", tree.toString());
	}
	
	@Test
	void btreeRemoveElementoInexistente() {
		BTree tree = new BTree(new int[] {84, 99, 27, 80, 47, 62, 56, 10, 11, 74, 87, 91, 17, 14, 13});
		assertTrue(!tree.isEmpty());
		assertEquals(15, tree.getSize());
		assertEquals("[62], [11, 17, 47], [10], [13, 14], [27], [56], [84], [74, 80], [87, 91, 99]", tree.toString());
		tree.remove(20);
		assertTrue(!tree.isEmpty());
		assertEquals(15, tree.getSize());
		assertEquals("[62], [11, 17, 47], [10], [13, 14], [27], [56], [84], [74, 80], [87, 91, 99]", tree.toString());
	}
	
	@Test
	void btreeRemoveElementoFolha() {
		BTree tree = new BTree(new int[] {84, 99, 27});
		assertEquals(3, tree.getSize());
		assertEquals("[27, 84, 99]", tree.toString());
		
		tree.remove(84);
		assertEquals(2, tree.getSize());
		assertEquals("[27, 99]", tree.toString());
		
		tree.remove(27);
		assertEquals(1, tree.getSize());
		assertEquals("[99]", tree.toString());
		
		tree.remove(99);
		assertEquals(0, tree.getSize());
		assertEquals("[]", tree.toString());
		assertTrue(tree.isEmpty());
	}
}
