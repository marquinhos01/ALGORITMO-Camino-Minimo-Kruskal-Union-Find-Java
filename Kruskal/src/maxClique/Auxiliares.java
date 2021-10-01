package maxClique;

import java.util.Set;

import grafos.Grafo;

public class Auxiliares {
	//Determina si un conjunto de vertices forma una clique
		public static boolean esClique(Grafo g, Set<Integer> conjunto) {
			for (Integer i : conjunto) 
				for (Integer j : conjunto) 
				{
					if(i != j && g.existeArista(i, j) == false)
						return false;
				}
			return true;
		}
}
