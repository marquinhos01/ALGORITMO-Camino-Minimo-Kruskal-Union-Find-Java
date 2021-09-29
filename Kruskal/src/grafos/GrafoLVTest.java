package grafos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

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
	public void NoEsArbol() {
		GrafoLV g = inicializarGrafo();// no tiene ciclos, pero no es conexo
		assertFalse(g.esArbol());
	}

	@Test
	public void esArbol() {
		GrafoLV g = inicializarGrafo();// no tiene ciclos, pero no es conexo
		g.agregarArista(0, 1, 0); // lo hago conexo y no tiene ciclo
		assertTrue(g.esArbol());
	}

	@Test
	public void generaCircuito() {
		GrafoLV g = inicializarGrafo();// no tiene ciclos, pero no es conexo
		// la arista (3, 2)generaria un ciclo
		assertTrue(g.generaCircuito(3, 2));
		assertTrue(g.generaCircuito(1, 2)); // ERROR!!!!! LA MISMA ARISTA DICE QUE GENERA CIRCUITO
	}

	@Test
	public void esArbol2() {
		GrafoLV arbol = new GrafoLV(4);
		arbol.agregarArista(0, 1, 10);
		arbol.agregarArista(1, 3, 1);
		arbol.agregarArista(2, 3, 0);
		assertTrue(arbol.esArbol());
		arbol.agregarArista(2, 1, 0); // Deja de ser arbol (se genera ciclo)
		assertFalse(arbol.esArbol());
	}

	@Test
	public void unGrafoEsMiArbol() {
		GrafoLV g = inicializarGrafo(); // no es un arbol
		g.agregarArista(0, 1, 0); // lo hago conexo
		g.agregarArista(2, 3, 0); // 1erciclo
		g.agregarArista(4, 2, 0); // 2do ciclo
		assertFalse(g.esArbol());
		GrafoLV arbol = inicializarGrafo();
		arbol.agregarArista(0, 1, 0);// lo hago conexo
		arbol.eliminarArista(2, 3); // elimino 1er ciclo
		arbol.eliminarArista(4, 2); // elimino 2do ciclo
		assertTrue(g.esArbolDeMiGrafo(arbol));
	}

	@Test
	public void aristaMenorPeso() {
		GrafoLV g = inicializarGrafo(); // no es un arbol
		Arista n = new Arista(0, 4, 3);
		assertEquals(g.menorPeso(), n);
	}
//	@Test
//	public void vecinosYeliminarTest() {
//		GrafoLV g = inicializarGrafo();
//		HashMap<Integer, Double> vecinos = new HashMap<Integer, Double>();
//		vecinos.put(2, 10.0);
//		// 1 -> 2, 3 (vecinos de 1)
//		g.eliminarArista(3, 1);
//		// 1 -> 2 (vecinos de 1)
//		// hashmap vecinos solo tiene el 2
//		assertEquals(g.vecinos(1), vecinos);
//	}

	@Test
	public void agregarAristaTest() {
		GrafoLV g = new GrafoLV(3);
		g.agregarArista(1, 2, 0);
		assertTrue(g.existeArista(1, 2));
		assertTrue(g.existeArista(2, 1));
		assertFalse(g.existeArista(2, 0));
	}

	@Test
	public void getAristas() {
		GrafoLV g = new GrafoLV(3);
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		assertEquals(g.getAristas(), aristas);
		g.agregarArista(1, 2, 10.0);
		g.agregarArista(2, 1, 2.0);
		g.agregarArista(0, 2, 0);
		aristas.add(new Arista(1, 2, 0));
		aristas.add(new Arista(0, 2, 0));
		assertEquals(g.getAristas(), aristas);
	}

	@Test
	public void getCantAristas() {
		GrafoLV g = inicializarGrafo();
		int cant = g.getCantAristas();
		assertEquals(3, cant);
		g.eliminarArista(0, 4);
		cant = g.getCantAristas();
		assertEquals(2, cant);
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
		vecinos.put(2, 10.0);
		vecinos.put(3, 1.0);
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
	public void pesoTotalGrafo() {
		GrafoLV g = inicializarGrafo();
		assertEquals((int) g.getPesoTotal(), 11);
		g.agregarArista(1, 4, 20);
		assertEquals((int) g.getPesoTotal(), 31);
		g.eliminarArista(1, 4);
		assertEquals((int) g.getPesoTotal(), 11);
	}

	@Test
	public void pesoArista() {
		GrafoLV g = inicializarGrafo();
		assertEquals((int) g.getPesoArista(1, 2), 10);
		assertEquals((int) g.getPesoArista(2, 1), 10);
		assertEquals((int) g.getPesoArista(4, 0), 0);
		assertEquals((int) g.getPesoArista(3, 4), -1); // no son vecinos
	}

}
