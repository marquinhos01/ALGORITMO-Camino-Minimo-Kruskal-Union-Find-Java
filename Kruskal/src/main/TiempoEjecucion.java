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
		Grafo g = Generador.grafoConexo(1000);
		float promedioBFS=0;
		float promedioUF=0;
		
		for (int i=0 ; i<10 ; i++) {
			TiempoEjecucion t = new TiempoEjecucion(g);
			System.out.println("Ejecucion numero:" +(i+1));
			System.out.println("Kruskal con BFS tardo : " + t.getTiempoEjecucionKruskalBFS());
			System.out.println("Kruskal sin UF tardo : " + t.getTiempoEjecucionKruskal() + "\n");
			promedioBFS+=t.getTiempoEjecucionKruskalBFS();
			promedioUF+=t.getTiempoEjecucionKruskal();
		}
		System.out.println("El promedio del tiempo de BFS fue:" + promedioBFS/10.0);
		System.out.println("El promedio del tiempo de UF fue:" + promedioUF/10.0);
	}
	
}
