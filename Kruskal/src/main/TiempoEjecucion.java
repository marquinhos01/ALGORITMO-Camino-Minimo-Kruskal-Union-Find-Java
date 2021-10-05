package main;

import algoritmos.KruskalBFS;
import algoritmos.KruskalUF;
import generador.Generador;
import grafos.Grafo;

public class TiempoEjecucion {
	private long inicio, fin, tiempo;
	private Grafo g;
	private KruskalBFS kbfs;
	private KruskalUF kbuf;
	public TiempoEjecucion(Grafo g) {
		this.g = g;
	}

	public long getTiempoEjecucionKruskalBFS() {
		this.kbfs = new KruskalBFS(g);
		inicio = System.currentTimeMillis();
		kbfs.iniciarKruskal();
		fin = System.currentTimeMillis();
		tiempo = fin - inicio;
		return tiempo;
	}
	public long getTiempoEjecucionKruskal() {
		this.kbuf = new KruskalUF(g);
		inicio = System.currentTimeMillis();
		kbuf.iniciarKruskal();
		fin = System.currentTimeMillis();
		tiempo = fin - inicio;
		return tiempo;
	}
	public static void main(String[] args) {
		Grafo g = Generador.grafoGenerico(50, 1225); //Grafo para probar en 2 algoritmos
		TiempoEjecucion t = new TiempoEjecucion(g);
		System.out.println("Kruskal con BFS tardo : " + t.getTiempoEjecucionKruskalBFS());
		System.out.println("Kruskal sin UF tardo : " + t.getTiempoEjecucionKruskal());
		
	}

	
}
