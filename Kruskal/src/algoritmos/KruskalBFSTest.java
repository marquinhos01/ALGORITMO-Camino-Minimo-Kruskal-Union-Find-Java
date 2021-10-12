package algoritmos;

import static org.junit.Assert.*;
import org.junit.Test;
import grafos.Grafo;

public class KruskalBFSTest {

	@Test(expected = IllegalArgumentException.class)
	public void grafoNoConexoKruskal() {
		Grafo g = new Grafo(9);
		g.agregarArista(0, 1, 4);
		g.agregarArista(0, 2, 8);
		@SuppressWarnings("unused")
		KruskalBFS k = new KruskalBFS(g);
	}
	@Test
	public void casoFeliz() {
		Grafo g = new Grafo(4);
		g.agregarArista(0, 1, 10);
		g.agregarArista(0, 2, 3);
		g.agregarArista(0, 3, 1);
		g.agregarArista(1, 2, 7);
		g.agregarArista(2, 3, 2);
		KruskalBFS k = new KruskalBFS(g);
		Grafo arbol = k.iniciarKruskal();
		assertFalse(arbol.existeArista(2, 0)); //la mas barata pero genera ciclo
		assertFalse(arbol.existeArista(1, 3)); //la mas pesada
		assertTrue(arbol.esArbol());
	}
	@Test
	public void esArbolGeneradorMinimo() {
		Grafo G = iniciarGrafo(); //no es un arbol generador
		KruskalBFS T = new KruskalBFS(G); 
		Grafo arbolKruskal = T.getArbolMinimo(); //arbol generador minimo por Kruskal
		assertTrue(G.esArbolDeMiGrafo(arbolKruskal));
	}

	public Grafo iniciarGrafo() {
		// El de la presentación
		Grafo g = new Grafo(9);
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

	public Grafo arbolDeGrafoInicial() {
		Grafo g = new Grafo(9);
		KruskalBFS k = new KruskalBFS(g);
		return k.getArbolMinimo();
	}

}
