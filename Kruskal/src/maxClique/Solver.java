package maxClique;

import java.util.HashSet;
import java.util.Set;

import grafos.Grafo;

public class Solver {
	// El grafo
	private Grafo _grafo;

	// La mejor clique hallada hasta el momento
	private Set<Integer> _mayor;

	// Auxiliar para la recursión
	private Set<Integer> _actual;

	// Un solver está asociado a un único grafo
	public Solver(Grafo grafo) {
		_grafo = grafo;
	}

	// Obtiene la clique máxima: O(n^2 * 2^n)
	public Set<Integer> resolver() {
		_mayor = new HashSet<Integer>();
		_actual = new HashSet<Integer>();

		generarDesde(0);
		return _mayor;
	}

	// Implementa la recursión
	private void generarDesde(int vertice) {
		if (vertice == _grafo.tamano()) {
			// Caso base 1: llegamos a una hoja
			if (_actual.size() > _mayor.size())
				_mayor = clonar(_actual);
			return;

		}
		// Caso base 2: no tenemos una clique
		if (Auxiliares.esClique(_grafo, _actual) == false)
			return; // nos vamos
		else {
			// Caso recursivo
			_actual.add(vertice);
			generarDesde(vertice + 1);

			_actual.remove(vertice);
			generarDesde(vertice + 1);
		}
	}

	// Clonacion de un conjunto de enteros
	private Set<Integer> clonar(Set<Integer> conjunto) {
		Set<Integer> ret = new HashSet<Integer>();
		for (Integer i : conjunto)
			ret.add(i);

		return ret;
	}
}
