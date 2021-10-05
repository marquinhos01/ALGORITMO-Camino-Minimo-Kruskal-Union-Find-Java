package algoritmos;

import java.util.ArrayList;

public class UnionFind {

	private int[] arregloVertices;

	private int root(int i) {
//		while (arregloVertices[i] != i) {	//vertices recorridos		
//			i = arregloVertices[i];
//		}
		if(arregloVertices[i] != i)
			arregloVertices[i] = root(arregloVertices[i]);
		return i;
	}

	public boolean find(int i, int j) {
		return root(i) == root(j); // false: puedo agregarlo,
									// true: no puedo agregarlo
	}

	public void union(int i, int j) {
		int ri = root(i);
		int rj = root(j);

		arregloVertices[ri] = rj;
	}

	public int[] getArregloVertices() {
		return arregloVertices;
	}

	public void setArregloVertices(int cantVertices) {
		arregloVertices = new int[cantVertices];
		for (int i = 0; i < arregloVertices.length; i++) {
			arregloVertices[i] = i;
		}
	}

}
