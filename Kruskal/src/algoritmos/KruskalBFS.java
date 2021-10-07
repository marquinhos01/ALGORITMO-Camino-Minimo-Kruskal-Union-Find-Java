package algoritmos;

import java.util.LinkedList;
import java.util.Set;

import grafos.Arista;
import grafos.Grafo;

public class KruskalBFS {
	private Grafo _grafo;
	Grafo arbolNuevo;
	private LinkedList<Arista> aristas;

	public KruskalBFS(Grafo grafo) {
		if (!BFS.esConexo(grafo))
			throw new IllegalArgumentException("El grafo no es conexo");
		else {
			_grafo = grafo;
			aristas = new LinkedList<Arista>();
			arbolNuevo = iniciarKruskal();
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

	public static void main(String[] args) {
		Grafo g = new Grafo(5);
		g.agregarArista(0, 1, 1);
		g.agregarArista(0, 2, 3);
		g.agregarArista(0, 4, 0);
		g.agregarArista(1, 3, 2);
		g.agregarArista(1, 4, 12);
		g.agregarArista(2, 3, 4);
		g.agregarArista(3, 4, 10);
		KruskalBFS k = new KruskalBFS(g);
		Grafo kk = k.iniciarKruskal();
		System.out.println(k.iniciarKruskal());
		System.out.println(g.esArbolDeMiGrafo(kk));

	}
}
