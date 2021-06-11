package Grafo;

import java.util.ArrayList;

public class Vertice {
	private String nombre;
	private int numVertice;
	private int grado;
	private boolean enConjunto;
	private ArrayList<Vertice> vecinos;

	public Vertice(String s) {
		vecinos = new ArrayList<Vertice>();
		nombre = s;
		numVertice = -1;
		grado = 0;
		enConjunto = false;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public String nomVertice() {
		return getNombre();
	}

	public void asigVert(int n) {
		numVertice = n;
	}

	public int getNum() {
		return numVertice;
	}

	public String getNombre() {
		return nombre;
	}

	public int getGrado() {
		return grado;
	}

	public void sumarGrado() {
		grado++;
	}

	public boolean enConjunto() {
		return enConjunto;
	}

	public void setEnConjunto(boolean b) {
		enConjunto = b;
	}

	public void agregarVecino(Vertice v) {
		vecinos.add(v);
	}

	public ArrayList<Vertice> getVecinos() {
		return vecinos;
	}

	@Override
	public boolean equals(Object v) {
		Vertice v1 = (Vertice) v;
		return v1.getNombre() == this.nombre;
	}

}
