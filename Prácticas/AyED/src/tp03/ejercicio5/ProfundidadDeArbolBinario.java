package tp03.ejercicio5;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp03.ejercicio4.RedBinariaLlena;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> ab;
	
	public ProfundidadDeArbolBinario() {
		this.ab = new ArbolBinario<Integer>(1);
	}
	
	public ArbolBinario<Integer> getAb() {
		return ab;
	}
	
	
	public int sumaElementosProfundidad(int p) {
		int n = 1;
		int suma=0;
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(this.ab);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if(n==p)
					suma+=arbol.getDato();
				if(arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			}else if (!cola.esVacia()) {
				n++;
				cola.encolar(null);
			}
		}
		return suma;
	}
	
	public static void main(String[] args) {
		ProfundidadDeArbolBinario pab = new ProfundidadDeArbolBinario();
		ArbolBinario<Integer> n2 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> n3 = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> n7 = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> n5 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> n4 = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> n9 = new ArbolBinario<Integer>(9);
		
		n2.agregarHijoIzquierdo(n7);
		n2.agregarHijoDerecho(n5);
		n3.agregarHijoIzquierdo(n4);
		n3.agregarHijoDerecho(n9);
		
		pab.getAb().agregarHijoIzquierdo(n2);
		pab.getAb().agregarHijoDerecho(n3);
		
		System.out.println(pab.sumaElementosProfundidad(1)); 
	}
}
