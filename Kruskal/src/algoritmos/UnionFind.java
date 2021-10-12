package algoritmos;

public class UnionFind {
	private static int[] arregloVertices;

	public static int root(int i) {
		if(arregloVertices[i] == i)
			return i;
		else 
			return root(arregloVertices[i]);
	}

	public static boolean find(int i, int j) {
		return root(i) == root(j); // false: puedo agregarlo,
									// true: no puedo agregarlo
	}

	public static void union(int i, int j) {
		int ri = root(i);
		int rj = root(j);

		arregloVertices[ri] = rj;
	}

	public static int[] getArregloVertices() {
		return arregloVertices;
	}

	public static void setArregloVertices(int cantVertices) {
		arregloVertices = new int[cantVertices];
		for (int i = 0; i < arregloVertices.length; i++) {
			arregloVertices[i] = i;
		}
	}

}
