package grafos;

import static org.junit.Assert.*;

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
	}

	@Test
	public void agregarAristaTest() {
		GrafoLV g = new GrafoLV(3);
		g.agregarArista(1, 2, 0);
		assertTrue(g.existeArista(1, 2));
		assertTrue(g.existeArista(2, 1));
	}
	@Test
	public void grafoVacioTest() {
		GrafoLV g = new GrafoLV(0);
		assertEquals(0, g.vertices());
	}
	@Test
	public void vecinosTest() {
		GrafoLV g = inicializarGrafo();
		Set<Integer> vecinos = new HashSet<Integer>();
		vecinos.add(2);
		vecinos.add(3);
		assertEquals(g.vecinos(1), vecinos);
	}
	@Test
	public void vecinosYeliminarTest() {
		GrafoLV g = inicializarGrafo();
		Set<Integer> vecinos = new HashSet<Integer>();
		vecinos.add(3);
		g.eliminarArista(2, 1);
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
		assertEquals(g.getPesoArista(1, 2), 10);
		assertEquals(g.getPesoArista(2, 1), 10);
		assertEquals(g.getPesoArista(4, 0), 0);
		assertEquals(g.getPesoArista(3, 4), -1); // no son vecinos
	}
	

}
