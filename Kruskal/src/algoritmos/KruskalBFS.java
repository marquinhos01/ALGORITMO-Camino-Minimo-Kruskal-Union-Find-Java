package algoritmos;

import java.util.LinkedList;
import java.util.Set;

import grafos.Arista;
import grafos.Grafo;

public class KruskalBFS {
	private Grafo _grafo;
	protected Grafo arbolMinimo;
	private LinkedList<Arista> aristas;

	public KruskalBFS(Grafo grafo) {
		if (!BFS.esConexo(grafo))
			throw new IllegalArgumentException("El grafo no es conexo");
		else {
			_grafo = grafo;
			aristas = new LinkedList<Arista>();
			arbolMinimo = iniciarKruskal();
		}
	}

	public Grafo iniciarKruskal() {
		Grafo arbolGeneradorMinimo = new Grafo(_grafo.vertices());
		aristas = _grafo.listaMenorPeso();
		Set<Integer> alcanzables = BFS.alcanzables(arbolGeneradorMinimo, 0);
		int i = 1;
		Arista aMenor;
		while (i <= (_grafo.vertices() - 1)) {
			aMenor = aristas.getFirst();
			alcanzables = BFS.alcanzables(arbolGeneradorMinimo, aMenor.getI());
			if (!alcanzables.contains(aMenor.getJ())) {
				arbolGeneradorMinimo.agregarArista(aMenor.getI(), aMenor.getJ(), aMenor.getPeso());
				aristas.removeFirst();
				i++;
			} else
				aristas.removeFirst();
		}
		return arbolGeneradorMinimo;
	}

}
