package main;

import java.util.Arrays;

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
	
	private static double calcularMediana(double[] datos){
        double mediana;
        Arrays.sort(datos);
        if(datos.length % 2 == 0){
            double sumaMedios = datos[datos.length/2] + datos[datos.length/2 - 1]; 
            mediana = (double)sumaMedios / 2; 
        } else {
            mediana = datos[datos.length/2];
        }
        return mediana;
    }
	
	public static void main(String[] args) {
		Grafo g = Generador.grafoConexo(200);
		float promedioBFS=0;
		float promedioUF=0;
		double[] datosBFS = new double[10];
		double[] datosUF = new double[10];
		
		for (int i=0 ; i<10 ; i++) {
			TiempoEjecucion t = new TiempoEjecucion(g);
			System.out.println("Ejecucion numero:" +(i+1));
			
			long tiempoBFS= t.getTiempoEjecucionKruskalBFS();
			long tiempoUF= t.getTiempoEjecucionKruskal();
			
			System.out.println("Kruskal con BFS tardo : " + tiempoBFS);
			System.out.println("Kruskal sin UF tardo : " + tiempoUF + "\n");
			promedioBFS+=tiempoBFS;
			promedioUF+=tiempoUF;
			
			datosBFS[i]= tiempoBFS;
			datosUF[i]= tiempoUF;
		}
		System.out.println("El promedio del tiempo de BFS fue:" + promedioBFS/10.0);
		System.out.println("El promedio del tiempo de UF fue:" + promedioUF/10.0);
		
		System.out.println("La tendencia central (usando la mediana) del tiempo de BFS fue:" + calcularMediana(datosBFS));
		System.out.println("La tendencia central (usando la mediana) del tiempo de UF fue:" + calcularMediana(datosUF));
		
	}
	
}
