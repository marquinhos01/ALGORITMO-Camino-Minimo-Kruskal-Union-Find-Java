package algoritmos;

public class UnionFind {

	private int[] arregloVertices;

	private int root(int i) {
		while (arregloVertices[i] != i)
			i = arregloVertices[i];
		return i;
	}

	public boolean find(int i, int j) {
		return root(i) == root(j); //falso: puedo agregarlo, 
								   //true: no puedo agregarlo
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
