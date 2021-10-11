package generador;

import java.util.Random;

import grafos.Grafo;

public abstract class Generador {

	private static Integer cantMaxAristas;
	private static int cantidadAristas;
	private static int pVertice;
	private static int sVertice;
	private static double peso;

	public static Grafo grafoGenerico(int vertices, int aristas) {
		Grafo grafo = new Grafo(vertices);
		verificarCantArista(vertices, aristas);
		cantidadAristas = aristas;
		Random distribucionUniforme = new Random();
		for (int i = 0; i < cantidadAristas; i++) {
			do {
				pVertice = (int) (Math.random() * vertices); // I
				sVertice = (int) (Math.random() * vertices); // J
				peso = distribucionUniforme.nextDouble(); // peso
			} while (pVertice == sVertice || grafo.existeArista(pVertice, sVertice));
			grafo.agregarArista(pVertice, sVertice, peso);
		}
		return grafo;
	}
	
	public static Grafo grafoConexo(int vertices) {
		Grafo grafo = new Grafo(vertices);
		cantidadAristas = vertices * (vertices - 1) / 2;
		Random distribucionUniforme = new Random();
		for (int i = 0; i < cantidadAristas; i++) {
			do {
				pVertice = (int) (Math.random() * vertices); // I
				sVertice = (int) (Math.random() * vertices); // J
				peso = distribucionUniforme.nextDouble(); // peso
			} while (pVertice == sVertice || grafo.existeArista(pVertice, sVertice));
			grafo.agregarArista(pVertice, sVertice, peso);
		}
		return grafo;
	}

	static void verificarCantArista(int vertices, int aristas) {
		cantMaxAristas = vertices * (vertices - 1) / 2;
		if (aristas < vertices-1)
			throw new IllegalArgumentException("Cantidad de aristas < Cantidad de vertices - 1, no puede ser conexo");
		if (aristas > cantMaxAristas)
			throw new IllegalArgumentException("La cantidad de aristas debe ser menor o igual a:" + cantMaxAristas);
	}

}
