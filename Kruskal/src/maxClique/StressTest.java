package maxClique;

import java.util.Random;

import grafos.Grafo;

public class StressTest {
	// le damos con todo al programa
	// lo llevamos al maximo
	public static void main(String[] args) {
		for (int n = 2; n < 50 ; n++) {
			long inicio = System.currentTimeMillis();
			Solver solver = new Solver(aleatorio(n));
			solver.resolver();
			long fin = System.currentTimeMillis();
			double tiempo = (fin - inicio) / 1000.0;
			System.out.println("n=  " + n + ": " + tiempo + " sg");
		}
	}
	private static Grafo aleatorio(int n) {
		Grafo grafo = new Grafo(n);
		Random random = new Random(0);
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(random.nextDouble() < 0.3) {
					grafo.agregarArista(i, j, 0);
				}
			}
		}
		return grafo;
	}
}
