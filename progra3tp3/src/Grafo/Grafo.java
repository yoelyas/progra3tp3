package Grafo;

import java.util.ArrayList;
import java.util.Iterator;

public class Grafo {
	private boolean[][] matAdyacencia;
	private int numVerts;
	private Vertice[] vertices;

	public Grafo(int tamaño) {
		matAdyacencia = new boolean[tamaño][tamaño];
		vertices = new Vertice[tamaño];
		numVerts = 0;
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				matAdyacencia[i][j] = false;
			}
		}
	}

	public int numVertice(String nombre) {
		Vertice v = new Vertice(nombre);
		boolean encontrado = false;
		int i = 0;
		for (; (i < numVerts) && !encontrado;) {
			encontrado = vertices[i].equals(v);
			if (!encontrado)
				i++;
		}
		return (i < numVerts) ? i : -1;
	}

	public void nuevoVertice(String nom) {

		boolean existe = numVertice(nom) >= 0;
		if (!existe) {
			Vertice v = new Vertice(nom);
			v.asigVert(numVerts);
			vertices[numVerts++] = v;
		}
	}

	public void nuevoArco(String a, String b) {
		int numA = numVertice(a);
		int numB = numVertice(b);
		// numVertice no encuentra el vertice y retorna -1 
		System.out.println(numA);
		vertices[numA].sumarGrado();
		vertices[numB].sumarGrado();
		vertices[numA].agregarVecino(vertices[numB]);
		vertices[numB].agregarVecino(vertices[numA]);
		matAdyacencia[numA][numB] = true;
		matAdyacencia[numB][numA] = true;
	}

	public boolean existeArco(String a, String b) {
		int numA = numVertice(a);
		int numB = numVertice(b);
		return matAdyacencia[numA][numB];
	}
	
	public ArrayList<Vertice> mejorResultado(){
		ArrayList<Vertice> dominante = conjuntoDominante();
		ArrayList<Vertice> eleccion = eleccionVesinal();
		
		return (dominante.size() < eleccion.size())
			   ? dominante
			   : eleccion;
	}

	public ArrayList<Vertice> conjuntoDominante() {
		ArrayList<Vertice> ret = new ArrayList<Vertice>();
		ArrayList<Vertice> alcanzados = new ArrayList<Vertice>();
		while (alcanzados.size() < numVerts - 1) {
			int mayorGrado = -1;
			Vertice verticePorAgregar = new Vertice("v");
			for (Vertice v : vertices) {
				if (!v.enConjunto() && v.getGrado() > mayorGrado) {
					mayorGrado = v.getGrado();
					verticePorAgregar = v;
				}
			}
			ret.add(verticePorAgregar);
			verticePorAgregar.setEnConjunto(true);
			for (Vertice v : verticePorAgregar.getVecinos()) {
				if (!alcanzados.contains(v))
					alcanzados.add(v);
			}
		}
		return ret;
	}
	
	public ArrayList<Vertice> eleccionVesinal() {
		ArrayList<Vertice> ret = new ArrayList<Vertice>();
		ArrayList<Vertice> alcanzados = new ArrayList<Vertice>();
		while (alcanzados.size() < numVerts - 1) {
			int mayorAlcance = -1;
			Vertice verticePorAgregar = new Vertice("v");
			for (Vertice v : vertices) {
				if (!v.enConjunto() && cantNuevosVecinos(v,alcanzados ) > mayorAlcance) {
						mayorAlcance = v.getGrado();
						verticePorAgregar = v;
					}	
			}
			ret.add(verticePorAgregar);
			verticePorAgregar.setEnConjunto(true);
			for (Vertice v : verticePorAgregar.getVecinos()) {
				if (!alcanzados.contains(v))
					alcanzados.add(v);
			}
		}
		return ret;
	}	
	// cuenta cuantos vesinos nuevos se agregarian segun el nodo
	private int cantNuevosVecinos(Vertice vertice, ArrayList<Vertice> alcanzados) {
		int cont = 0;
		for (Vertice v : vertice.getVecinos()) {
			if (!alcanzados.contains(v)){
				cont++;
			}
		}
		return cont;
	}
		

	public int getNumVerts() {
		return numVerts;
	}
	public boolean[][] getMatAdyacencia() {
		return matAdyacencia;
	}
}
