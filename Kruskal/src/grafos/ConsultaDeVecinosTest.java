package grafos;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class ConsultaDeVecinosTest {

	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest() {

		GrafoAdy g = new GrafoAdy(5);
		g.vecinos(-1);
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest() {

		GrafoAdy g = new GrafoAdy(5);
		g.vecinos(5);
	}

	@Test
	public void TodosAislados() {
		GrafoAdy g = new GrafoAdy(5);
		assertEquals(0, g.vecinos(2).size());
	}

	@Test // vecinos de todos

	public void verticeUniversalTest() {
		GrafoAdy g = new GrafoAdy(4);
		g.agregarArista(1, 0);
		g.agregarArista(1, 2);
		g.agregarArista(1, 3);

		int[] esperado = { 0, 2, 3 };
		Asserts.iguales(esperado, g.vecinos(1));

	}


	@Test
	public void verticeNormalTest() {
		GrafoAdy g = new GrafoAdy(5);
		g.agregarArista(1, 3);
		g.agregarArista(2, 3);
		g.agregarArista(2, 4);
		int[] esperado = { 1, 2 };
		Asserts.iguales(esperado, g.vecinos(3));

	}

	
}
