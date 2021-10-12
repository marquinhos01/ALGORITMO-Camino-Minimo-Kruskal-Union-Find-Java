package algoritmos;

import java.util.LinkedList;

import grafos.Arista;
import grafos.Grafo;

public class KruskalUF {
	private Grafo _grafo;
	private LinkedList<Arista> aristas;

	public KruskalUF(Grafo grafo) {
		aristas = new LinkedList<Arista>();
		_grafo = grafo;
		UnionFind.setArregloVertices(_grafo.vertices());
	}

	public Grafo iniciarKruskal() {
		Grafo arbolMinimo = new Grafo(_grafo.vertices());
		aristas = _grafo.listaMenorPeso(); // O(n)
		int i = 1;
		Arista aMenor;
		try {
			while (i <= (_grafo.vertices() - 1)) { // O(n)
				aMenor = aristas.getFirst();
				if (!UnionFind.find(aMenor.getI(), aMenor.getJ())) { // si no esta en la misma comp conexa
					arbolMinimo.agregarArista(aMenor.getI(), aMenor.getJ(), aMenor.getPeso());
					UnionFind.union(aMenor.getI(), aMenor.getJ());
					aristas.removeFirst();
					i++;
				} else
					aristas.removeFirst();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("El grafo no era conexo, no pudo devolver un arbol generador minimo");
		}

		return arbolMinimo;

	}

}
