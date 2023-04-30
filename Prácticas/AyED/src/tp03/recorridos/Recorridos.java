package tp03.recorridos;

import tp03.ejercicio1.ArbolBinario;

public class Recorridos {
	
	
	
	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> ab1 = new ArbolBinario<Integer>(9);
		ArbolBinario<Integer> ab2 = new ArbolBinario<Integer>(8);
		ArbolBinario<Integer> ab3 = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> ab4 = new ArbolBinario<Integer>(11);

		ab.agregarHijoIzquierdo(ab1);
		ab.agregarHijoDerecho(ab2);
		ab1.agregarHijoIzquierdo(ab3);
		ab1.agregarHijoDerecho(ab4);
		
		ab.printPreOrden();
		System.out.println();
		ab.printPostOrden();
		System.out.println();
		ab.printInOrden();
		System.out.println();
		ab.recorridoPorNiveles();
	}
}
