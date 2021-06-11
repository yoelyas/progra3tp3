package Grafo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class GrafoTest {

	@Test(expected = NegativeArraySizeException.class)
	public void verticeNegativoFailTest() {
		@SuppressWarnings("unused")
		Grafo grafo = new Grafo(-1);

	}

	@Test
	public void testNuevoVertice() {
		Grafo grafo = new Grafo(5);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		assertEquals(2, grafo.getNumVerts());
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void nuevoVerticeExcedidoTest() {
		Grafo grafo = new Grafo(3);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Perú");
		grafo.nuevoVertice("colombia");
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void nuevoArcoInexistenteTest() {
		Grafo grafo = new Grafo(3);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoArco("Argentina", "Perú");
	}

	@Test
	public void nuevoArcoTest() {
		Grafo grafo = new Grafo(3);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Peru");
		grafo.nuevoVertice("Uruguay");
		grafo.nuevoArco("Argentina", "Peru");
		assertTrue(grafo.existeArco("Argentina", "Peru"));
	}

	@Test
	public void existeArcoTest() {
		Grafo grafo = new Grafo(5);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Uruguay");
		grafo.nuevoArco("Argentina", "Chile");
		assertTrue(grafo.existeArco("Argentina", "Chile"));
		assertFalse(grafo.existeArco("Argentina", "Uruguay"));
	}

	@Test
	public void numVerticeTest() {
		Grafo grafo = new Grafo(5);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Uruguay");
		assertEquals(2, grafo.numVertice("Uruguay"));
	}

	@Test
	public void conjuntoDominanteTest() {
		ArrayList<Vertice> esperado = new ArrayList<Vertice>();
		esperado.add(new Vertice("d"));
		ArrayList<Vertice> noEsperado = new ArrayList<Vertice>();
		noEsperado.add(new Vertice("a"));
		Grafo grafo = new Grafo(5);
		grafo.nuevoVertice("a");
		grafo.nuevoVertice("b");
		grafo.nuevoVertice("c");
		grafo.nuevoVertice("d");
		grafo.nuevoVertice("e");
		grafo.nuevoArco("a", "e");
		grafo.nuevoArco("a", "b");
		grafo.nuevoArco("a", "d");
		grafo.nuevoArco("e", "d");
		grafo.nuevoArco("b", "d");
		grafo.nuevoArco("b", "c");
		grafo.nuevoArco("c", "d");
		ArrayList<Vertice> resultado = grafo.conjuntoDominante();
		assertEquals(esperado, resultado);
		assertNotEquals(noEsperado, resultado);

	}

}
