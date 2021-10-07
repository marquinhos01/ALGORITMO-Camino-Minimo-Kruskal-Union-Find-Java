package grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

import algoritmos.BFS;

public class Grafo {
	private ArrayList<HashMap<Integer, Double>> _vecinos;
	private ArrayList<Arista> aristas;
	private int _vertice;
	private int cantAristas;
	private int pesoTotal;

	public Grafo(int vertices) {
		_vecinos = new ArrayList<HashMap<Integer, Double>>(vertices);
		aristas = new ArrayList<Arista>();
		for (int i = 0; i < vertices; i++)
			_vecinos.add(new HashMap<Integer, Double>());
		_vertice = vertices;
	}

	public void agregarArista(int i, int j, double p) {
		verificarArista(i, j, "agregar");
		if (!_vecinos.get(i).containsKey(j) && !_vecinos.get(j).containsKey(i)) {
			Arista a = new Arista(i, j, p);
			_vecinos.get(i).put(j, p);
			_vecinos.get(j).put(i, p);
			aristas.add(a);
			cantAristas++;
			pesoTotal += p;
		}
	}

	public void eliminarArista(int i, int j) {
		verificarArista(i, j, "eliminar");
		if (_vecinos.get(i).containsKey(j) || _vecinos.get(j).containsKey(i)) {
			pesoTotal -= _vecinos.get(i).get(j);
			_vecinos.get(i).remove(j); // no debo elimina de acá
			_vecinos.get(j).remove(i);
			aristas.remove(new Arista(i, j, 0));
			cantAristas--;
		}
	}

	public boolean existeArista(int i, int j) {
		verificarArista(i, j, "consultar");
		return _vecinos.get(i).containsKey(j);
	}

	public double getPesoArista(int vertice1, int vertice2) {
		if (_vecinos.get(vertice1).containsKey(vertice2))
			return _vecinos.get(vertice1).get(vertice2).doubleValue();
		return -1;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public HashMap<Integer, Double> vecinos(int i) {
		verificarVertice(i, " un vertice ");
		return _vecinos.get(i);
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	// Ordena las aristas en una LinkedList por su peso utilizando megersort,
	// que en promedio, tiene complejidad n log(n)
	public LinkedList<Arista> listaMenorPeso() {
		LinkedList<Arista> listaOrdenada = new LinkedList<Arista>();
		for (Arista i : aristas) { // O(n)
			listaOrdenada.add(i);
		}
		Collections.sort(listaOrdenada);// O(n.log n)
		return listaOrdenada;
	}

	public int vertices() {
		return _vertice;
	}

	public int tamano() {
		return _vecinos.size();
	}
	
	public int grado(int i) {
		return _vecinos.get(i).size();
	}

	public boolean esArbol() {
		boolean conexo = BFS.esConexo(this);
		boolean sinCircuitos = (this.getCantAristas() < this.vertices());
		return conexo && sinCircuitos;
	}

	public boolean esArbolDeMiGrafo(Grafo g) {
		return g.esArbol() && (_vertice == g._vertice) && (g.cantAristas == _vertice - 1);
	}


	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < _vecinos.size(); i++) {
			s.append("vértice : ");
			s.append(i);
			s.append(", vecinos: ");
			s.append(_vecinos.get(i).toString());
			s.append("\n");
		}
		return s.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(aristas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grafo other = (Grafo) obj;
		return Objects.equals(aristas, other.aristas);
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
}
