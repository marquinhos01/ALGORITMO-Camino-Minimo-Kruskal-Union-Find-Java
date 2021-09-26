package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
  Representacin con Lista de vecinos
*/
public class GrafoLV {
	private ArrayList<HashMap <Integer, Double > > _vecinos; //la carga va de 0 a 1 con distribución uniforme
	private int _vertice;

	public GrafoLV(int vertices) {
		_vecinos = new ArrayList<HashMap <Integer, Double> >(vertices);

		for (int i = 0; i < vertices; i++)
			_vecinos.add(new HashMap <Integer, Double>());

		_vertice = vertices;
	}

	public void agregarArista(int i, int j, double p) {
		verificarArista(i, j, "agregar");

		if (!_vecinos.get(i).containsKey(j) && !_vecinos.get(j).containsKey(i)) {
			_vecinos.get(i).put(j, p);
			_vecinos.get(j).put(i, p);
		}
		
	}

	public void eliminarArista(int i, int j) {
		verificarArista(i, j, "eliminar");

		if (_vecinos.get(i).containsKey(j) && _vecinos.get(j).containsKey(i)) {
			_vecinos.get(i).remove(j);
			_vecinos.get(j).remove(i);
		}
	}

	public void modificarCarga(int i, int j, double p) {
		if(_vecinos.get(i).get(j)== null)
			throw new IllegalArgumentException("La arista ingresada no existe");
		if (_vecinos.get(i).containsKey(j) && _vecinos.get(j).containsKey(i) && _vecinos.get(i).get(j)!= null) {
			_vecinos.get(i).replace(j, p);
			_vecinos.get(j).replace(i, p);
		}
	}
	
	public boolean existeArista(int i, int j) {
		verificarArista(i, j, "consultar");
		return _vecinos.get(i).containsKey(j);
	}
	
	public HashMap <Integer, Double> vecinos(int i)
	{
		verificarVertice(i, " un vertice ");
		
		return _vecinos.get(i);
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
	
	public double getPesoArista(int vertice1, int vertice2) {
		if (_vecinos.get(vertice1).containsKey(vertice2))
			return _vecinos.get(vertice1).get(vertice2).doubleValue();
		return -1;
	}
	
	public ArrayList<HashMap<Integer, Double>> getVecinos() {
		return _vecinos;
	}
		
	public void set_vecinos(ArrayList<HashMap<Integer, Double>> _vecinos) {
		this._vecinos = _vecinos;
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
	
	
	
@Override
	public String toString() {
	StringBuilder s= new StringBuilder();
	for(int i=0; i<_vecinos.size();i++) {
		s.append("vértice : ");
		s.append(i);
		s.append(", vecinos: ");
		s.append(_vecinos.get(i).toString());
		s.append("\n");
	}
		return s.toString();
	}

	//	QUITAR
	public static void main(String[] args) {
		GrafoLV g = new GrafoLV(5);
		g.agregarArista(0, 1, 5);
		g.agregarArista(0, 2, 4);
		g.agregarArista(3, 1, 4);
		g.agregarArista(3, 1, 3);
//		g.agregarArista(1, 1, 10);
		System.out.println(g.toString());
//		g.eliminarArista(1, 3);
//		System.out.println(g.toString());
		g.modificarCarga(3, 1, 5);
		System.out.println(g.toString());
//		System.out.println(g.grado(1));

	}

}
