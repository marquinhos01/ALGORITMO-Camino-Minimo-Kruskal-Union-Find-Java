package grafos;

import java.util.HashSet;
import java.util.Set;

public class GrafoAdy {
	// representamos el grafo por su matriz de adyacencia
	private boolean[][] A;

	// la cantidad de vertices esta predeterminada dede el cons

	public GrafoAdy(int vertices) {
		A = new boolean[vertices][vertices];
	}

	public void agregarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		/*
		 * Lanzar excepción IllegalArgumentException: valor ilegal RuntimeException:
		 * comun pero en rojo [mensaje corto] [mostrar el valor que causo el problema]
		 * 
		 */

		A[i][j] = true;
		A[j][i] = true;

	}

	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return A[i][j];
	}

	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		A[i][j] = false;
		A[j][i] = false;
	}

	public int tamano() {
		return A.length;
	}

	// vecinos de un vertice
	public Set<Integer> vecinos(int i) {
		verificarVertice(i);
		Set<Integer> ret = new HashSet<Integer>();
		for (int j = 0; j < tamano(); j++)
			if (i != j) {
				if (existeArista(i, j))
					ret.add(j);
			}
		return ret;
	}

	private void verificarDistintos(int i, int j) {
		if (i == j)
			throw new IllegalArgumentException("No se permiten loops: (" + i + " " + j + ")");
	}

	private void verificarVertice(int i) {
		if (i < 0)
			throw new IllegalArgumentException("El vertice i no puede ser negativo: " + i);
		if (i >= A.length)
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |v|-1!");
	}
	
//	QUITAR
//	public static void main(String[] args) {
//		GrafoAdy grafo = new GrafoAdy(5);
//		grafo.agregarArista(2, 3);
//		grafo.agregarArista(2, 4);
//		System.out.println(grafo.existeArista(2, 3));
//		System.out.println(grafo.existeArista(3, 2));
//		System.out.println(grafo.existeArista(1, 3));
//	}
}
