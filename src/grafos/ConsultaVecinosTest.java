package grafos;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConsultaVecinosTest {

	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(5);
	}
	@Test
	public void todosAisladosTest() {
		Grafo grafo = new Grafo(5);
		assertEquals(0, grafo.vecinos(2).size());
	}
	@Test()
	public void verticeUniversalTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 0);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		
//		Set<Integer> set = grafo.vecinos(1);
//		
//		assertEquals(3, set.size());
//		assertTrue(set.contains(0));
//		assertTrue(set.contains(2));
//		assertTrue(set.contains(3));
		
		int[] esperado = {0, 2, 3};
		Assert.iguales(esperado, grafo.vecinos(1));
	}
	@Test()
	public void verticeNormalTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);
		
//		Set<Integer> set = grafo.vecinos(3);
//		
//		assertEquals(2, set.size());
//		assertTrue(set.contains(1));
//		assertTrue(set.contains(2));
		
		int[] esperado = {1,2};
		Assert.iguales(esperado, grafo.vecinos(3));
	}
}
