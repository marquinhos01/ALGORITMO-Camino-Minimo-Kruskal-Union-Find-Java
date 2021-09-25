package grafos;

import java.util.ArrayList;
import java.util.HashSet;

public class KruskalBFS {
	private GrafoLV _grafo;
	private BFS bfs;
	private HashSet conjunto;
	
	public KruskalBFS(GrafoLV grafo) {
		_grafo = grafo;
		bfs = new BFS();
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
			if(bfs.esConexo(grafoMenor)) {
				grafoMenor.eliminarArista(aux.getI(), aux.getJ());
			}
			//Marcar arista de menor peso
			
			
			i++;
		}
		
		//return GrafoLV menor recorrido;
	}

	private Arista buscarMenorPeso() {
		Arista aux = _grafo.getVecinos().get(0).get(0);
		//Recorrer aristas y elegir la de menor peso
		for (int j = 0; j < _grafo.getVecinos().size(); j++)
			for (int k = 0; k < _grafo.getVecinos().get(j).size(); k++)
				if (aux.getPeso()>_grafo.getVecinos().get(j).get(k).getPeso())
					aux=_grafo.getVecinos().get(j).get(k);
		return aux;
	}

}
