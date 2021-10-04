package grafos;

import algoritmos.UnionFind;

public class KruskalUF {
	private Grafo _grafo;
	private UnionFind UF;

	public KruskalUF(Grafo grafo) {
			_grafo = grafo;
			UF = new UnionFind();
			UF.setArregloVertices(_grafo.vertices());
		}
	

	public Grafo iniciarKruskal() {
		Grafo arbolMinimo = new Grafo(_grafo.vertices());
		int i = 1;
		while (i <= (_grafo.vertices() - 1)) {
			Arista minima = _grafo.menorPeso(); // arista minima O(n)
			if (!UF.find(minima.getI(), minima.getJ())) { // si no esta en la misma comp conexa
				arbolMinimo.agregarArista(minima.getI(), minima.getJ(), minima.getPeso());
				UF.union(minima.getI(), minima.getJ());
				i++;
			}
		}
		return arbolMinimo;
	}

	public static void main(String[] args) {
		Grafo n = new Grafo(5);
		n.agregarArista(0, 1, 2);
		n.agregarArista(0, 2, 4);
		n.agregarArista(0, 4, 10);
		n.agregarArista(1, 2, 3);
		n.agregarArista(2, 3, 5);
		n.agregarArista(3, 4, 1);
		KruskalUF kUF = new KruskalUF(n);
//		KruskalBFS kBFS = new KruskalBFS(n);
		
		System.out.println("---con Union Find----");
		System.out.println(kUF.iniciarKruskal());
//		System.out.println("---con BFS----");
//		System.out.println(kBFS.iniciarKruskal().getAristas());
	}
}
