package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class KruskalBFS {
	private GrafoLV _grafo;
//	private BFS bfs; NO HACE FALTA PORQUE LOS MÉTODOS SON ESTÁTICOS
	private HashSet conjunto;
	
	public KruskalBFS(GrafoLV grafo) {
		_grafo = grafo;
//		bfs = new BFS();
	}
	
	
	public GrafoLV iniciarKruskal() {
		GrafoLV arbolGeneradorMinimo=new GrafoLV(0);
		HashSet<Arista> aristasVisitadas=new HashSet<Arista>();
		int i = 1;
		while (i<=(_grafo.vertices()-1)){
			//buscarMenorPeso
			Arista aristaMinima = buscarMenorPeso();
			//IF agregar a la coleccion aux MAP
			if (aristasVisitadas.contains(aristaMinima)) {
				//IF Comprobar que no haya circuito. Llamamos BFS
				
				//Agregar al Arbol Generador Minimo
				arbolGeneradorMinimo.agregarArista(aristaMinima.getI(), aristaMinima.getJ(), aristaMinima.getPeso());
				//Marcar arista de menor peso
				aristasVisitadas.add(aristaMinima);
			}
			i++;
		}
		return arbolGeneradorMinimo;
	}
	
	//Devuelve la arista con menor peso del grafo
	private Arista buscarMenorPeso() {
		Arista aux = new Arista(0,0, _grafo.getVecinos().get(0).get(0));
		for(int i=0; i<_grafo.vertices(); i++) {
			if (this.menorPesoVecinos(_grafo.susVecinos(i), i).getPeso() < aux.getPeso())
				aux= this.menorPesoVecinos(_grafo.susVecinos(i), i);
		}
		return aux;
	}
	
	//Calcula el mínimo peso de las aristas incidentes a un vértice dado
	private Arista menorPesoVecinos(HashMap<Integer, Double> v, int numVertice) {
		double min= v.get(0);
		Arista aux = new Arista(0, 0, min);
		for(int i=1; i<v.size(); i++) {
			if(v.get(i)<min) {
				min= v.get(i);
				aux = new Arista(numVertice, i, min);
			}
		}
		return aux;
	}

}
