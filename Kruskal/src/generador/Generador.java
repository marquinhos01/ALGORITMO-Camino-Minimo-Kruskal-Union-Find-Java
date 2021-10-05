package generador;

import java.util.Random;

import grafos.Grafo;

public abstract class Generador {
	// yo no quiero que creen un Generador, cada vez que lo llamo me crea un grafo
	// diferente
	// Generador.grafoGenerico(n,m) != Generador.grafoGenerico(m,n)

	private static Integer cantMaxAristas;
	private static int cantidadAristas;
	private static int pVertice;
	private static int sVertice;
	private static double peso;

	public static Grafo grafoGenerico(int n, int m) {
		Grafo grafo = new Grafo(n);
		verificarCantArista(n, m);
		cantidadAristas = m;
		Random distribucionUniforme = new Random();
		for (int i = 0; i < cantidadAristas; i++) {
			do {
				pVertice = (int) (Math.random() * n); // I
				sVertice = (int) (Math.random() * n); // J
				peso = distribucionUniforme.nextDouble(); // peso
				System.out.println("(" + pVertice + ", " + sVertice + ")");
			} while (pVertice == sVertice || grafo.existeArista(pVertice, sVertice));
			grafo.agregarArista(pVertice, sVertice, peso);
		}
		return grafo;
	}

	static void verificarCantArista(int n, int m) {
		cantMaxAristas = n * (n - 1) / 2;
		if (m <= 0)
			throw new IllegalArgumentException(
					"La cantidad de aristas del grafo a crear debe ser mayor a 0, ingresó:" + m);
		if (m > cantMaxAristas)
			throw new IllegalArgumentException("La cantidad de aristas debe ser menor o igual a:" + cantMaxAristas);
	}

}
