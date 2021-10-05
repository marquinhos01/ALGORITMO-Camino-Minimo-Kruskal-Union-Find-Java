package grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.List;

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

	public Arista menorPeso() {
		
		Arista aux = clonar(aristas.get(0));
		double menor = aux.getPeso();
		for (Arista i : aristas) {
			if (i.getPeso() < menor)
				aux = clonar(i);
			menor = aux.getPeso();
		}
		aristas.remove(aux);
		return aux;
	}
	
	
	//Ordena las aristas en una LinkedList por su peso utilizando megersort, 
	//que en promedio, tiene complejidad n log(n)
	public static LinkedList<Arista> listaMenorPeso(Grafo grafo){
		LinkedList <Arista> listaOrdenada = new LinkedList<Arista>();
		for (Arista i : grafo.getAristas()) {
			listaOrdenada.add(i);
		}
		Collections.sort(listaOrdenada);
		return listaOrdenada;
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
			_vecinos.get(i).remove(j); //no debo elimina de acá
			_vecinos.get(j).remove(i);
			aristas.remove(new Arista(i, j, 0));
			cantAristas--;
		}
	}

//	public void modificarCarga(int i, int j, double p) {
//		if (_vecinos.get(i).get(j) == null)
//			throw new IllegalArgumentException("La arista ingresada no existe");
//		if (_vecinos.get(i).containsKey(j) && _vecinos.get(j).containsKey(i) && _vecinos.get(i).get(j) != null) {
//			_vecinos.get(i).replace(j, p);
//			_vecinos.get(j).replace(i, p);
//		}
//	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public boolean existeArista(int i, int j) {
		verificarArista(i, j, "consultar");
		return _vecinos.get(i).containsKey(j);
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public HashMap<Integer, Double> vecinos(int i) {
		verificarVertice(i, " un vertice ");

		return _vecinos.get(i);
	}

	public int grado(int i) {
		return _vecinos.get(i).size();
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public int vertices() {
		return _vertice;
	}

	public double getPesoArista(int vertice1, int vertice2) {
		if (_vecinos.get(vertice1).containsKey(vertice2))
			return _vecinos.get(vertice1).get(vertice2).doubleValue();
		return -1;
	}

	public boolean esArbol() {
		boolean conexo = BFS.esConexo(this);
		boolean sinCircuitos = (this.getCantAristas() < this.vertices());
		return conexo && sinCircuitos;
	}

	public boolean esArbolDeMiGrafo(Grafo g) {
		return g.esArbol() && (_vertice == g._vertice) && (g.cantAristas == _vertice - 1);
	}

	public boolean generaCircuito(int i, int j) {
		Set<Integer> alcanzables = BFS.alcanzables(this, i); // me dice que genera circuito si ya existe la (i,j)
		return alcanzables.contains(j);
	}
	// para acceder desde KruskalBFS al map con vecinos de un vértice determinado

	public HashMap<Integer, Double> susVecinos(int vertice) {
		this.verificarVertice(vertice, " un vértice"); // preguntar para qué está el tipo
		return _vecinos.get(vertice);
	}

	public ArrayList<HashMap<Integer, Double>> getVecinos() {
		return _vecinos;
	}

//	public void set_vecinos(ArrayList<HashMap<Integer, Double>> _vecinos) {
//		this._vecinos = _vecinos;
//	}

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

	private Arista clonar(Arista arista) {
		Arista ret = new Arista(arista.getI(), arista.getJ(), arista.getPeso());
		return ret;
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
	
	public int tamano() {
		return _vecinos.size();
	}
	
	public static void main(String[] args) {

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
		Grafo g = new Grafo(4);
		g.agregarArista(0, 1, 10);
		g.agregarArista(2, 1, 4);
		g.agregarArista(3, 1, 1);
		g.agregarArista(3, 2, 0);
		
		LinkedList <Arista> listaOrdenada = new LinkedList<Arista>();
		listaOrdenada = listaMenorPeso(g);
		
		for (Arista i : listaOrdenada) {
			System.out.println(i);
		}

		System.out.println(g.esArbol());
		KruskalBFS t = new KruskalBFS(g);
		Grafo arbol = t.arbolNuevo;
		System.out.println(g.esArbolDeMiGrafo(arbol));
	
//		GrafoLV g2 = new GrafoLV(5);
//		g2.agregarArista(0, 1, 10);
//		g2.agregarArista(2, 1, 4);
//		g2.agregarArista(3, 4, 1);
//		System.out.println(g.equals(g2));
		
		
		

	}


}
