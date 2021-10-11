package algoritmos;

import java.util.LinkedList;

import grafos.Arista;
import grafos.Grafo;

public class KruskalUF {
	private Grafo _grafo;
	private UnionFind UF;
	private LinkedList<Arista> aristas;

	public KruskalUF(Grafo grafo) {
		if (!BFS.esConexo(grafo))
			throw new IllegalArgumentException("El grafo no es conexo");
		else {
			aristas = new LinkedList<Arista>();
			_grafo = grafo;
			UF = new UnionFind();
			UF.setArregloVertices(_grafo.vertices());
		}
	}

	public Grafo iniciarKruskal() {
		Grafo arbolMinimo = new Grafo(_grafo.vertices());
		aristas = _grafo.listaMenorPeso(); // O(n)
		int i = 1;
		Arista aMenor;
		while (i <= (_grafo.vertices() - 1)) { // O(n)
			aMenor = aristas.getFirst();
			if (!UF.find(aMenor.getI(), aMenor.getJ())) { // si no esta en la misma comp conexa
				arbolMinimo.agregarArista(aMenor.getI(), aMenor.getJ(),aMenor.getPeso());
				UF.union(aMenor.getI(), aMenor.getJ());
				aristas.removeFirst();
				i++;
			} else
				aristas.removeFirst();
		}
		return arbolMinimo;

	}

	public UnionFind getUF() {
		return UF;
	}

}
