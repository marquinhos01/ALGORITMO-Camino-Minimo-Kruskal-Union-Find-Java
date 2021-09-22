package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {

	private static ArrayList<Integer> L;
	private static boolean[] marcados;

	public static boolean esConexo(GrafoLV g) {
		if (g == null)
			throw new IllegalArgumentException("Se intento consultar un grafo que es null");
		if(g.vertices() == 0)
			return true;
		return alcanzables(g, 0).size() == g.vertices();
	}

	public static Set<Integer> alcanzables(GrafoLV g, int origen) {

		Set<Integer> ret = new HashSet<Integer>();
		inicializar(g, origen);

		while (L.size() != 0) { //no haya para procesar
			int i = L.get(0); //agarro el primero de la lista
			marcados[i] = true; //lo marco en marcados -> pongo true 
			ret.add(i); // agrego el vertice que marqué
			agregarVecinosPendientes(g, i);
			L.remove(0);
		}

		return ret;
	}

	private static void agregarVecinosPendientes(GrafoLV g, int i) {
		for (int vertice : g.vecinos(i))
			if (marcados[vertice] == false && L.contains(vertice) == false)
				L.add(vertice); //lo agrego a L
	}

	private static void inicializar(GrafoLV g, int origen) {

		L = new ArrayList<Integer>();
		L.add(origen);
		marcados = new boolean[g.vertices()];

	}

}
