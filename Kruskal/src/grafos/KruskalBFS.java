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
	
	
	public void iniciarKruskal() {
		GrafoLV grafoMenor=new GrafoLV(0);
		//ArrayList _vecinos = new ArrayList<ArrayList<Arista>>();
		int i = 1;
		while (i<=(_grafo.vertices()-1)){
			//buscarMenorPeso
			Arista aux = buscarMenorPeso();
			grafoMenor.agregarArista(aux.getI(), aux.getJ(), aux.getPeso());
			//Comprobar que no haya circuito. Llamamos BFS
			if(BFS.esConexo(grafoMenor)) {
				grafoMenor.eliminarArista(aux.getI(), aux.getJ());
			}
			//Marcar arista de menor peso
			
			
			i++;
		}
		
		//return GrafoLV menor recorrido;
	}

//	private Arista buscarMenorPeso() {
//		Arista aux = _grafo.getVecinos().get(0).get(0);
//		//Recorrer aristas y elegir la de menor peso
//		for (int j = 0; j < _grafo.getVecinos().size(); j++)
//			for (int k = 0; k < _grafo.getVecinos().get(j).size(); k++)
//				if (aux.getPeso()>_grafo.getVecinos().get(j).get(k).getPeso())
//					aux=_grafo.getVecinos().get(j).get(k);
//		return aux;
//	}
	
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
