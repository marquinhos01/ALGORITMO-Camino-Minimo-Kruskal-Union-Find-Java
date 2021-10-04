package generador;

import java.util.Random;

import grafos.Grafo;
import maxClique.Solver;

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

	public static void main(String[] args) {
		Grafo g = Generador.grafoGenerico(4, 4);
		/*
		 * Este metodo me puede crear tanto un grafo arbol como un no arbol, si le
		 * agrego (4,4) ya no seria un arbol, pero si le agrego (4,3) siendo 4 la cant
		 * de vertices y 3 la cantidad de aristas hay mucha probabilidad de que me
		 * genere un arbol.
		 */
		System.out.println(g.getAristas());
		System.out.println("es arbol?:-----" + g.esArbol());

		System.out.println("------------------");

		Solver s = new Solver(g); // me sirve para ver la maxima clique
		System.out.println(s.resolver()); // me sirve para ver la maxima clique
	}
}
