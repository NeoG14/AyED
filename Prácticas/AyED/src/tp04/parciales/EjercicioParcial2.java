package tp04.parciales;

import tp03.ejercicio1.ArbolBinario;

//Implemente un metodo sumaImparesPosOrderMayorA que recibe un arbol binario
//de enteros positivos y un numero entero. Este metodo suma todos los numeros impares del arbol 
//que son mayores al parametro recibido realizandolo en un recorrido posOrder

public class EjercicioParcial2 {

	public static int sumaImparesPosOrderMayorA(ArbolBinario<Integer> ab, int limite) {
		return sumar(ab,limite);
	}
	
	private static int sumar(ArbolBinario<Integer> ab, int limite) {
		int suma = 0;
		if(ab.tieneHijoIzquierdo())
			suma+=sumar(ab.getHijoIzquierdo(),limite);
		if(ab.tieneHijoDerecho())
			suma+=sumar(ab.getHijoDerecho(),limite);
		if(ab.getDato()%2==1 && ab.getDato()>limite) {
			suma+=ab.getDato();
			System.out.println(ab.getDato());
		}
		return suma;
	}
	
	public static void main(String[] args) {
		ArbolBinario<Integer> a7 = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> a56 = new ArbolBinario<Integer>(56);
		ArbolBinario<Integer> a25 = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> a38 = new ArbolBinario<Integer>(38);
		ArbolBinario<Integer> a31 = new ArbolBinario<Integer>(31);
		ArbolBinario<Integer> a5 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> a6 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> a87 = new ArbolBinario<Integer>(87);
		ArbolBinario<Integer> a77 = new ArbolBinario<Integer>(77);
		ArbolBinario<Integer> a94 = new ArbolBinario<Integer>(94);
		ArbolBinario<Integer> a16 = new ArbolBinario<Integer>(16);
		ArbolBinario<Integer> a2 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> a43 = new ArbolBinario<Integer>(43);
		ArbolBinario<Integer> a1 = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> a9 = new ArbolBinario<Integer>(9);
		ArbolBinario<Integer> a10 = new ArbolBinario<Integer>(10);
		
		a7.agregarHijoIzquierdo(a56);
		a7.agregarHijoDerecho(a25);
		
		a56.agregarHijoIzquierdo(a38);
		a56.agregarHijoDerecho(a31);
		a25.agregarHijoIzquierdo(a5);
		a25.agregarHijoDerecho(a6);
		
		a38.agregarHijoIzquierdo(a87);
		a38.agregarHijoDerecho(a77);
		a31.agregarHijoDerecho(a94);
		
		a94.agregarHijoDerecho(a2);
		a2.agregarHijoIzquierdo(a1);
		
		a77.agregarHijoIzquierdo(a16);
		a16.agregarHijoDerecho(a43);
		
		a43.agregarHijoIzquierdo(a9);
		a43.agregarHijoDerecho(a10);
		
		//a7.recorridoPorNiveles();
		
		System.out.println(sumaImparesPosOrderMayorA(a7, 30));
	}
}
