package Grafo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class VerticeTest {

	@Test
	public void testVertice() {
		Vertice vertice = new Vertice("Catamarca");
		assertEquals("Catamarca", vertice.nomVertice());
	}

	@Test
	public void testNomVertice() {
		Vertice vertice = new Vertice("Catamarca");
		assertEquals("Catamarca", vertice.nomVertice());
	}

	@Test
	public void testEqualsVertice() {
		Vertice vertice1 = new Vertice("Catamarca");
		Vertice vertice2 = new Vertice("Salta");
		assertFalse(vertice1.equals(vertice2));
	}

	@Test
	public void testAsigVert() {
		Vertice vertice = new Vertice("Catamarca");
		vertice.asigVert(3);
		assertEquals(3, vertice.getNum());
	}
	@Test
	public void agregarVecinoTest() {
		Vertice vertice1 = new Vertice("Catamarca");
		Vertice vertice2 = new Vertice("Salta");
		ArrayList<Vertice> esperado = new ArrayList<Vertice>();
		esperado.add(vertice2);
		vertice1.agregarVecino(vertice2);
		assertEquals(esperado,vertice1.getVecinos());
	}

}
