package grafos;

public class KruskalBFS {
	private Grafo _grafo;
	public Grafo arbolNuevo;
	public KruskalBFS(Grafo grafo) {
		if (!BFS.esConexo(grafo))
			throw new IllegalArgumentException("El grafo no es conexo");
		else {
			_grafo = grafo;
			arbolNuevo = iniciarKruskal();
		}
	}

	public Grafo iniciarKruskal() {
		
		Grafo arbolGeneradorMinimo = new Grafo(_grafo.vertices());
		int i = 1;
		while (i <= (_grafo.vertices() - 1)) {
			Arista aristaMinima = _grafo.menorPeso(); //acá estan las aristas del grafo original las voy borrando cada vez que pido un menor
			//System.out.println(i + "" + aristaMinima);
			if (!arbolGeneradorMinimo.generaCircuito(aristaMinima.getI(), aristaMinima.getJ())) {
				//acá hay un bug que funciona, a la vez pregunta si esta o no la arista en arbolGenerador
				arbolGeneradorMinimo.agregarArista(aristaMinima.getI(), aristaMinima.getJ(), aristaMinima.getPeso());
				i++;
			}
		}
		return arbolGeneradorMinimo;
	}

	public static void main(String[] args) {
		Grafo g = new Grafo(9);
		
		g.agregarArista(0, 1, 4);
		g.agregarArista(0, 7, 8);
		g.agregarArista(1, 7, 12);
		g.agregarArista(1, 2, 8);
		g.agregarArista(2, 8, 3);
		g.agregarArista(2, 5, 4);
		g.agregarArista(3, 2, 6);
		g.agregarArista(3, 5, 13);
		g.agregarArista(3, 4, 9);
		g.agregarArista(4, 5, 10);
		g.agregarArista(5, 6, 3);
		g.agregarArista(6, 8, 5);
		g.agregarArista(6, 7, 1);
		g.agregarArista(7, 8, 6);
		KruskalBFS k = new KruskalBFS(g);
		System.out.println(g.getCantAristas());
		System.out.println(k.arbolNuevo.getCantAristas());

	}

}
