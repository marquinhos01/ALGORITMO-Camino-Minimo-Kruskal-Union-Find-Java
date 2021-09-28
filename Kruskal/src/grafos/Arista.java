package grafos;

import java.util.Objects;

public class Arista {
	private int i, j;
	private double peso;

	public Arista(int i, int j, double p) {
		this.i = i;
		this.j = j;
		this.peso = p;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public double getPeso() {
		return peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(i, j);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		return (i == other.i && j == other.j) || (i == other.j && j == other.i);
	}
	
	
	
	@Override
	public String toString() {
		return "Arista [i=" + i + ", j=" + j + ", peso=" + peso + "]";
	}

	public static void main(String[] args) {
		Arista n = new Arista(1,2,3);
		
		Arista n2 = new Arista(2,1,3);
		
		Arista n3 = new Arista(1,2, 4);
		
		Arista n4 = new Arista(5,2, 4);
		
		System.out.println(n.equals(n4));
		
	}
}
