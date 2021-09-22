package grafos;

import java.util.Set;
import static org.junit.Assert.*;

public class Assert {

	public static void iguales(int[] esperados, Set<Integer> alcanzables) {
		assertEquals(esperados.length, alcanzables.size());
		for (Integer elemento : esperados)
			assertTrue(alcanzables.contains(elemento));
	}

}
