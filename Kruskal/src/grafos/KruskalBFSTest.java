package grafos;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KruskalBFSTest {

	@Test(expected = IllegalArgumentException.class)
	public void grafoNoConexoKruskal() {
		GrafoLV g = new GrafoLV(9);
		g.agregarArista(0, 1, 4);
		g.agregarArista(0, 2, 8);
		@SuppressWarnings("unused")
		KruskalBFS k = new KruskalBFS(g);
	}

	@Test
	public void esArbolGeneradorMinimo() {
		GrafoLV G = iniciarGrafo(); //no es un arbol generador
		KruskalBFS T = new KruskalBFS(G); 
		GrafoLV arbolKruskal = T.arbolNuevo; //arbol generador minimo por Kruskal
		assertTrue(G.esArbolDeMiGrafo(arbolKruskal));
	}

	public GrafoLV iniciarGrafo() {
		// El de la presentaci�n
		GrafoLV g = new GrafoLV(9);
		g.agregarArista(0, 1, 4);
		g.agregarArista(0, 2, 8);
		g.agregarArista(1, 2, 12);
		g.agregarArista(1, 3, 8);
		g.agregarArista(2, 5, 1);
		g.agregarArista(4, 2, 6);
		g.agregarArista(3, 4, 3);
		g.agregarArista(3, 7, 4);
		g.agregarArista(5, 4, 5);
		g.agregarArista(5, 7, 3);
		g.agregarArista(3, 6, 6);
		g.agregarArista(6, 7, 13);
		g.agregarArista(6, 8, 9);
		g.agregarArista(8, 7, 10);
		return g;
	}

	public GrafoLV arbolDeGrafoInicial() {
		GrafoLV g = new GrafoLV(9);
		KruskalBFS k = new KruskalBFS(g);
		return k.arbolNuevo;
	}

}
