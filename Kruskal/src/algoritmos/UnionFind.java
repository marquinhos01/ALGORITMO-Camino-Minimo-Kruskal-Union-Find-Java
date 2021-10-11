package algoritmos;

public class UnionFind {
	private int[] arregloVertices;

	public int root(int i) {
		if(arregloVertices[i] == i)
			return i;
		else
			return arregloVertices[i] = root(arregloVertices[i]);
	}

	public boolean find(int i, int j) {
		return root(i) == root(j); // false: puedo agregarlo,
									// true: no puedo agregarlo
	}
	
	private int[] rootUnion(int i) {
		int [] cantVertices = {0,0};
		if(arregloVertices[i] == i) {
			cantVertices[0]=i;
			cantVertices[1]=cantVertices[1]+1;
			return cantVertices;
		}
		else {
			 cantVertices[1]=cantVertices[1]+1;
			 return rootUnion(arregloVertices[i]);
		}
	}

	 public void union(int i, int j) {
		 int [] ri = rootUnion(i);
		 int [] rj = rootUnion(j);
		 if (ri[1]<rj[1])
			 arregloVertices[ri[0]] = rj[0];
		 else
			 arregloVertices[rj[0]] = ri[0];
	 }

//	public void union(int i, int j) {
//		int ri = root(i);
//		int rj = root(j);
//
//		arregloVertices[ri] = rj;
//	}

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
