package grafos;

public class KruskalBFS {
	private Grafo _grafo;
	Grafo arbolNuevo;

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
			Arista aristaMinima = _grafo.menorPeso(); // acá estan las aristas del grafo original las voy borrando cada
														// vez que pido un menor
			// System.out.println(i + "" + aristaMinima);
			if (!arbolGeneradorMinimo.generaCircuito(aristaMinima.getI(), aristaMinima.getJ())) {
				// acá hay un bug que funciona, a la vez pregunta si esta o no la arista en
				// arbolGenerador
				arbolGeneradorMinimo.agregarArista(aristaMinima.getI(), aristaMinima.getJ(), aristaMinima.getPeso());
				i++;
			}
		}
		return arbolGeneradorMinimo;
	}

}
