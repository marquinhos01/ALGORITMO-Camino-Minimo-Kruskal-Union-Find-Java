package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class KruskalBFS {
	private GrafoLV _grafo;
//	private BFS bfs; NO HACE FALTA PORQUE LOS MÉTODOS SON ESTÁTICOS
	private HashSet conjunto;

	public KruskalBFS(GrafoLV grafo) {
		if (!BFS.esConexo(grafo))
			throw new RuntimeException("El grafo no es conexo");
		else
			_grafo = grafo;
	}

	public GrafoLV iniciarKruskal() {
		// conjunto Et: aristas que fueron agregadas al nuevo arbol
		GrafoLV arbolGeneradorMinimo = new GrafoLV(_grafo.vertices());
		int i = 1;
		while (i <= (_grafo.vertices() - 1)) {
			Arista aristaMinima = _grafo.menorPeso();
			System.out.println(i + "" + aristaMinima);
			if (!arbolGeneradorMinimo.generaCircuito(aristaMinima.getI(), aristaMinima.getJ())) {
				arbolGeneradorMinimo.agregarArista(aristaMinima.getI(), aristaMinima.getJ(), aristaMinima.getPeso());
				i++;
			}
		}
		return arbolGeneradorMinimo;
	}

	// Devuelve la arista con menor peso del grafo
//	private Arista buscarMenorPeso() { //fix
//		Arista aux = new Arista(0,0, _grafo.getVecinos().get(0).get(0));
//		for(int i=0; i<_grafo.vertices(); i++) {
//			if (this.menorPesoVecinos(_grafo.susVecinos(i), i).getPeso() < aux.getPeso())
//				aux= this.menorPesoVecinos(_grafo.susVecinos(i), i);
//		}
//		return aux;
//	}
//	
	// Calcula el mínimo peso de las aristas incidentes a un vértice dado
//	private Arista menorPesoVecinos(HashMap<Integer, Double> v, int numVertice) { //
//		double min= v.get(0);
//		Arista aux = new Arista(0, 0, min);
//		for(int i=1; i<v.size(); i++) {
//			if(v.get(i)<min) {
//				min= v.get(i);
//				aux = new Arista(numVertice, i, min);
//			}
//		}
//		return aux;
//	}
	public static void main(String[] args) {
		GrafoLV g = new GrafoLV(4);
//		g.agregarArista(0, 1, 4);
//		g.agregarArista(0, 2, 8);
//		g.agregarArista(1, 2, 12);
//		g.agregarArista(1, 3, 8);
//		g.agregarArista(2, 5, 1);
//		g.agregarArista(4, 2, 6);
//		g.agregarArista(3, 4, 3);
//		g.agregarArista(3, 7, 4);
//		g.agregarArista(5, 4, 5);
//		g.agregarArista(5, 7, 3);
//		g.agregarArista(3, 6, 6);
//		g.agregarArista(6, 7, 13);
//		g.agregarArista(6, 8, 9);
//		g.agregarArista(8, 7, 10);
		g.agregarArista(0, 2, 0);
		g.agregarArista(0, 1, 1);
		g.agregarArista(1, 2, 3);
		g.agregarArista(3, 1, 4);
		KruskalBFS k = new KruskalBFS(g);

		System.out.println(k.iniciarKruskal());

	}

}
