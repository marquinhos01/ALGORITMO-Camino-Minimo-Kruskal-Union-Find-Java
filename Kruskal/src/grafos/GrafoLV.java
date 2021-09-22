package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
  Representacin con Lista de vecinos
*/
public class GrafoLV {
	private ArrayList<ArrayList<Arista>> _vecinos;
	private int _vertice;

	public GrafoLV(int vertices) {
		_vecinos = new ArrayList<ArrayList<Arista>>(vertices);

		for (int i = 0; i < vertices; i++)
			_vecinos.add(new ArrayList<Arista>());

		_vertice = vertices;
	}

	public void agregarArista(int i, int j, int p) {
		verificarArista(i, j, "agregar");

		_vecinos.get(i).add(new Arista(i, j, p));
		_vecinos.get(j).add(new Arista(j, i, p));
	}

	public void eliminarArista(int i, int j) {
		verificarArista(i, j, "eliminar");

		_vecinos.get(i).remove(new Arista(i, j, 0));
		_vecinos.get(j).remove(new Arista(j, i, 0));

	}

	public boolean existeArista(int i, int j) {
		verificarArista(i, j, "consultar");

		return _vecinos.get(i).contains(new Arista(i, j, 0));
	}

	public Set<Integer> vecinos(int i) {
		Set<Integer> vecinos = new HashSet<Integer>();
		verificarVertice(i, " un vertice ");
		for (int j = 0; j < _vecinos.get(i).size(); j++) {
			vecinos.add(_vecinos.get(i).get(j).getJ());
		}

		return vecinos;
	}

	public int grado(int i) {
		return _vecinos.get(i).size();
	}

	private void verificarArista(int i, int j, String tipo) {
		if (i == j)
			throw new IllegalArgumentException("Se intento " + tipo + " una arista con i=j : " + i + "/" + j);

		verificarVertice(i, tipo);

		verificarVertice(j, tipo);

	}

	private void verificarVertice(int i, String tipo) {
		if (i < 0 || i >= _vertice)
			throw new IllegalArgumentException("Se intento usar " + tipo + " con valores, fuera de rango: " + i);
	}

	public int vertices() {
		return _vertice;
	}

	public int getPesoArista(int i, int j) {
		// arraylist no obtiene por objeto, si no por indice
		for (int k = 0; k < _vecinos.get(i).size(); k++) { // obtengo el vertice i
			if (_vecinos.get(i).get(k).equals(new Arista(i, j, 0)))
				return _vecinos.get(i).get(k).getPeso();
		}
		return -1;
	}

	public boolean esClique(Set<Integer> conjunto) {
		if (conjunto == null)
			throw new IllegalArgumentException("El conjunto no puede ser null");

		for (int v : conjunto)
			verificarVertice(v, " Clique");

		if (conjunto.isEmpty())
			return true;

		for (int v : conjunto)
			for (int otro : conjunto)
				if (v != otro)
					if (existeArista(v, otro) == false)
						return false;

		return true;
	}

	public static void main(String[] args) {
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(0, 1, 5);
		g.agregarArista(0, 2, 4);
		g.agregarArista(3, 1, 4);
		g.agregarArista(3, 2, 4);
		g.eliminarArista(1, 3);
		System.out.println(g.grado(1));

	}

}
