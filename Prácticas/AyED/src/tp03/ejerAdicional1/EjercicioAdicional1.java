package tp03.ejerAdicional1;

import tp03.ejercicio1.ArbolBinario;

//Construir un algoritmo que dado un ab de integer y un valor devuelva True si
//La suma de todos los caminos desde la raiz hasta una hoja es igual a ese valor
public class EjercicioAdicional1 {
	
	public static boolean caminosValor(ArbolBinario<Integer> ab, int valor) {
		int sumaAct = 0;
		return caminosValor(ab,valor,sumaAct);
	}
	
	private static boolean caminosValor(ArbolBinario<Integer> ab, int valor,int sumaAct) {
		boolean corte = true;
		sumaAct += ab.getDato();
		if(ab.tieneHijoIzquierdo() & corte)
			corte = caminosValor(ab.getHijoIzquierdo(),valor,sumaAct);
		if(ab.tieneHijoDerecho() & corte)
			corte = caminosValor(ab.getHijoDerecho(),valor,sumaAct);
		if(ab.esHoja()) {
			if(sumaAct != valor)
				corte = false;
		}
		return corte;
	}
	
	public static void main(String[] args) {
		ArbolBinario<Integer> n7 = new ArbolBinario<>(7);
		ArbolBinario<Integer> n1 = new ArbolBinario<>(1);
		ArbolBinario<Integer> n3 = new ArbolBinario<>(3);
		ArbolBinario<Integer> n6 = new ArbolBinario<>(6);
		ArbolBinario<Integer> n4 = new ArbolBinario<>(4);
		ArbolBinario<Integer> n22 = new ArbolBinario<>(2);
		ArbolBinario<Integer> n44 = new ArbolBinario<>(4);
		ArbolBinario<Integer> n222 = new ArbolBinario<>(2);
		ArbolBinario<Integer> n2222 = new ArbolBinario<>(2);
		
		
		n7.agregarHijoIzquierdo(n1);
		n7.agregarHijoDerecho(n3);
		
		n1.agregarHijoIzquierdo(n6);
		n1.agregarHijoDerecho(n4);
		
		n4.agregarHijoIzquierdo(n22);
		
		n3.agregarHijoIzquierdo(n222);
		n3.agregarHijoDerecho(n44);
		n222.agregarHijoIzquierdo(n2222);
		
		n7.recorridoPorNiveles();
		System.out.println();
		System.out.println(caminosValor(n7,14));
	}
}
