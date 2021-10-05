package grafos;

import java.util.LinkedList;

public abstract class Kruskal {

	protected Grafo _grafo;
	protected Grafo arbolNuevo;
	protected LinkedList<Arista> aristas;
	public Kruskal(Grafo grafo) {
		this._grafo = grafo;
	}
	
	public abstract Grafo iniciarKruskal();
	
	
}
