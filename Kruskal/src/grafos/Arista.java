package grafos;

import java.util.Objects;

public class Arista implements Comparable<Arista> {
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
		return "Arista [i=" + i + ", j=" + j + ", peso=" + peso + "]\n";
	}

	@Override
	public int compareTo(Arista a) {
		int valor = 0;
		if (a.getPeso()>this.peso)
			valor = -1;
		else if (a.getPeso()==this.peso)
			valor = 0;
		else if (a.getPeso()<this.peso)
			valor = 1;
		return valor;
	}

}
