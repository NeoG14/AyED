package tp03.ejercicio1;

public class Ejercicio2 {

	public static void main(String[] args) {
		//Raíz
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(1);
		//nivel 1
		ArbolBinario<Integer> n1 = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> n2 = new ArbolBinario<Integer>(2);
		//nivel 2
		ArbolBinario<Integer> n3 = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> n4 = new ArbolBinario<Integer>(4);
		//nivel 3
		ArbolBinario<Integer> n5 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> n6 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> n7 = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> n8 = new ArbolBinario<Integer>(8);
		
		
		n2.agregarHijoIzquierdo(n4);
		n2.agregarHijoDerecho(n5);
		
		n3.agregarHijoIzquierdo(n6);
		
		//n4.agregarHijoIzquierdo(n7);
		
		//n7.agregarHijoIzquierdo(n8);
		
		arbol.agregarHijoIzquierdo(n2);
		arbol.agregarHijoDerecho(n3);
		
		
		//arbol.printPreOrden();
		//arbol.printPostOrden();
		//arbol.printInOrden();
		//System.out.println(arbol.contarHojas());
		//arbol.printPreOrden();
		//arbol.recorridoPorNiveles();
		//arbol.entreNiveles(4, 5);
	}

}
