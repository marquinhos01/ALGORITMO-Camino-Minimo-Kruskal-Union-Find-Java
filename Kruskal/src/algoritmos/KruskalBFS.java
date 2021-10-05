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
			aristas=new LinkedList<Arista>();
			arbolNuevo = iniciarKruskal();
		}
	}

	public Grafo iniciarKruskal() {

		Grafo arbolGeneradorMinimo = new Grafo(_grafo.vertices());
		aristas=_grafo.listaMenorPeso();
		int i = 1;
		while (i <= (_grafo.vertices() - 1)) {
			Arista aux=aristas.getFirst();
//			Arista aristaMinima = _grafo.menorPeso(); // acá estan las aristas del grafo original las voy borrando cada
														// vez que pido un menor
			// System.out.println(i + "" + aristaMinima);
			if (!arbolGeneradorMinimo.generaCircuito(aux.getI(),aux.getJ())) {
				// acá hay un bug que funciona, a la vez pregunta si esta o no la arista en
				// arbolGenerador
				arbolGeneradorMinimo.agregarArista(aux.getI(), aux.getJ(), aux.getPeso());
				aristas.removeFirst();
				i++;
			}
		}
		return arbolGeneradorMinimo;
	}

}
