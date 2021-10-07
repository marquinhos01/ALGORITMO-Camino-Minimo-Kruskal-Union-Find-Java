package algoritmos;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import grafos.Assert;
import grafos.Grafo;

public class BFStest {

	@Test(expected = IllegalArgumentException.class)
	public void testNULL() {
		BFS.esConexo(null);
	}
	
	@Test
	public void vacioTest() {
		Grafo g = new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void alcanzableTest() {
		Grafo g = inicializarGrafo();
		Set<Integer>alcanzables = BFS.alcanzables(g,0);
		int[] esperados = { 0, 1, 2, 3};
		Assert.iguales(esperados, alcanzables);
		
	}
	@Test
	public void conexoTest() {
		Grafo g = inicializarGrafo();
		g.agregarArista(3, 4, 10);
		assertTrue(BFS.esConexo(g));
	}
	@Test
	public void noConexoTest() {
		Grafo g = inicializarGrafo();
		assertFalse(BFS.esConexo(g));
		
	}

	private Grafo inicializarGrafo() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0,1,10);
		grafo.agregarArista(0,2,10);
		grafo.agregarArista(2,3,10);
		return grafo;
	}

}
