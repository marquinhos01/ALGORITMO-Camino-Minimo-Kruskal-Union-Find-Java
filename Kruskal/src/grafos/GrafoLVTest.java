package grafos;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class GrafoLVTest {

	public GrafoLV inicializarGrafo() {
		GrafoLV grafo = new GrafoLV(5);
		grafo.agregarArista(1, 2, 10);
		grafo.agregarArista(1, 3, 1);
		grafo.agregarArista(0, 4, 0);
		return grafo;
	}	@Test
	public void vecinosYeliminarTest() {
		GrafoLV g = inicializarGrafo();
		HashMap<Integer, Double> vecinos = new HashMap<Integer, Double>();
		vecinos.put(2,10.0);
		//1 -> 2, 3 (vecinos de 1)
		g.eliminarArista(3, 1);
		//1 -> 2 (vecinos de 1)
		//hashmap vecinos solo tiene el 2
		assertEquals(g.vecinos(1), vecinos);
	}

	@Test
	public void agregarAristaTest() {
		GrafoLV g = new GrafoLV(3);
		g.agregarArista(1, 2, 0);
		assertTrue(g.existeArista(1, 2));
		assertTrue(g.existeArista(2, 1));
		assertFalse(g.existeArista(2, 0));
	}
	@Test
	public void grafoVacioSinVerticeTest() {
		GrafoLV g = new GrafoLV(0);
		assertEquals(0, g.vertices());
	}
	@Test
	public void VerticesTest() {
		GrafoLV g = inicializarGrafo();
		assertEquals(5, g.vertices());
	}
	public void vecinosTest() { 
		  GrafoLV g = inicializarGrafo(); 
		  HashMap<Integer, Double> vecinos = new HashMap<Integer, Double>(); 
		  vecinos.put(2,10.0); 
		  vecinos.put(3,1.0); 
		  assertEquals(g.vecinos(1), vecinos); 
		 }

	@Test
	public void gradoTest() {
		GrafoLV g = inicializarGrafo();
		assertEquals(g.grado(4), 1); // 0
		assertEquals(g.grado(0), 1); // 4
		assertNotEquals(g.grado(1), 3); // 2,3
	}
	@Test
	public void pesoArista() {
		GrafoLV g = inicializarGrafo();
		assertEquals((int)g.getPesoArista(1, 2), 10);
		assertEquals((int)g.getPesoArista(2, 1), 10);
		assertEquals((int)g.getPesoArista(4, 0), 0);
		assertEquals((int)g.getPesoArista(3, 4), -1); // no son vecinos
	}
	

}
