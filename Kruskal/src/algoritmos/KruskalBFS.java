package algoritmos;

import java.util.LinkedList;

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
		int i = 1;
		Arista aux;
		while (i <= (_grafo.vertices() - 1)) {
			aux = aristas.getFirst();
			if (!arbolGeneradorMinimo.generaCircuito(aux.getI(), aux.getJ())) {
				arbolGeneradorMinimo.agregarArista(aux.getI(), aux.getJ(), aux.getPeso());
				aristas.removeFirst();
				System.out.println(aux);
				i++;
			} 
			else
				aristas.removeFirst();
		}
		return arbolGeneradorMinimo;
	}

}
