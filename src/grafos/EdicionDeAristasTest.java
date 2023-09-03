package grafos;

import static org.junit.Assert.*;
import org.junit.Test;

public class EdicionDeAristasTest {
	@Test(expected = IllegalArgumentException.class) // le digo que espero una exception de ese tipo para que funcione bien
	public void verticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1,3);
	}
	@Test(expected = IllegalArgumentException.class) // le digo que espero una exception de ese tipo para que funcione bien
	public void segundoVerticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(3,-1);
	}
	@Test(expected = IllegalArgumentException.class) // le digo que espero una exception de ese tipo para que funcione bien
	public void verticeConIndiceExcedidoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(6,3);
	}
	@Test(expected = IllegalArgumentException.class) // le digo que espero una exception de ese tipo para que funcione bien
	public void segundoVerticeConIndiceExcedidoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(3,6);
	}
	@Test(expected = IllegalArgumentException.class) // le digo que espero una exception de ese tipo para que funcione bien
	public void verticeConIndicesIgualesTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(3,3);
	}
	@Test
	public void aristaExistenteTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(2,3));
	}
	@Test
	public void aristaOpuestaTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(3,2));
	}
	@Test
	public void aristaInexistenteTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertFalse(grafo.existeArista(1,4));
	}
	@Test
	public void eliminarAristaExistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4);
		
		grafo.eliminarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}
	
	
}
