package maxClique;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import grafos.Assert;
import grafos.Grafo;

public class SolverTest {

	@Test
	public void cliqueTresTest() {
		Solver solver = new Solver(trianguloConAntena());
		Set<Integer> obtenido = solver.resolver(); // conjunto de enteros
		int[] esperado = { 0, 1, 2 };
		
		Assert.iguales(esperado, obtenido);
	}

	@Test
	public void AisladoTest() {
		Grafo aislado = new Grafo(5);
		Solver solver = new Solver(aislado);
		Set<Integer> obtenido = solver.resolver(); // conjunto de enteros
		assertEquals(1, obtenido.size());
	}
	@Test
	public void CompletoTest() {
		Solver solver = new Solver(completo());
		int[] esperado = { 0, 1, 2, 3 };
		Set<Integer> obtenido = solver.resolver(); // conjunto de enteros
		Assert.iguales(esperado, obtenido);
	}

	private Grafo trianguloConAntena() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1, 0);
		grafo.agregarArista(0, 2, 0);
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(3, 1, 0);
		return grafo;

	}
	private Grafo completo() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1, 0);
		grafo.agregarArista(0, 2, 0);
		grafo.agregarArista(0, 3, 0);
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(1, 3, 0);
		grafo.agregarArista(2, 3, 0);
		return grafo;

	}
}
