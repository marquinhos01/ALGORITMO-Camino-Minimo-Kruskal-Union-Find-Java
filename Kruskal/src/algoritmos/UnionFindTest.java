package algoritmos;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.Grafo;

public class UnionFindTest {

	@Test
	public void rootTest() {
		Grafo g = iniciarGrafo();
		UnionFind UF = new UnionFind();
		UF.setArregloVertices(g.vertices());
		UF.union(2, 1);

		assertTrue(UF.find(2, 1));
	}
	
	@Test
	public void verticesAisladosTest() {
		Grafo g = iniciarGrafo();
		UnionFind UF = new UnionFind();
		UF.setArregloVertices(g.vertices());

		assertFalse(UF.find(2, 0));
		assertFalse(UF.find(2, 1));
		assertFalse(UF.find(2, 3));
	}
	
	public Grafo iniciarGrafo() {
		// El de la presentación
		Grafo g = new Grafo(4);
		g.agregarArista(0, 2, 0.1);
		g.agregarArista(1, 2, 0.2);
		g.agregarArista(2, 3, 0.1);
		
		return g;
	}

}
