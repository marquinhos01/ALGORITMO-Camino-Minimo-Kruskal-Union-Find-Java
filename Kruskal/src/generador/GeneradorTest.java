package generador;

import org.junit.Test;

import grafos.Grafo;

public class GeneradorTest {

	@Test(expected = IllegalArgumentException.class)
	public void ceroVertices() {
		Grafo g = Generador.grafoGenerico(0, 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantAristasNegativas() {
		Grafo g = Generador.grafoGenerico(3, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void masAristasDeLasPosibles() {
		Grafo g = Generador.grafoGenerico(3, 4);
	}

}
