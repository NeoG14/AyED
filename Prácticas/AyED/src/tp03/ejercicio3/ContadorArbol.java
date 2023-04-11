package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {
	
	//Forma 1 Utilizando una lista como parametro
	/* 
	public static ListaEnlazadaGenerica<Integer> numerosParesInOrden(ArbolBinario<Integer> ab,ListaEnlazadaGenerica<Integer> listaPares) {
		if(ab.tieneHijoIzquierdo())
			numerosParesInOrden(ab.getHijoIzquierdo(),listaPares);
		if(ab.getDato()%2==0)
			listaPares.agregarFinal(ab.getDato());
		if(ab.tieneHijoDerecho())
			numerosParesInOrden(ab.getHijoDerecho(),listaPares);
		return listaPares;
	}
	*/
	
	//Forma 2 metodos privados
	/*
	private static ListaEnlazadaGenerica<Integer> numerosPares(ArbolBinario<Integer> ab,ListaEnlazadaGenerica<Integer> listaPares) {
		if(ab.tieneHijoIzquierdo())
			numerosPares(ab.getHijoIzquierdo(),listaPares);
		if(ab.getDato()%2==0)
			listaPares.agregarFinal(ab.getDato());
		if(ab.tieneHijoDerecho())
			numerosPares(ab.getHijoDerecho(),listaPares);
		return listaPares;
	}
	public static ListaEnlazadaGenerica<Integer> numerosParesInOrden(ArbolBinario<Integer> ab) {
		ListaEnlazadaGenerica<Integer> listaPares =new ListaEnlazadaGenerica<Integer>();
		numerosPares(ab,listaPares);
		return listaPares;
	}
	*/
	
	// Forma 3??
	/*
	private static ListaEnlazadaGenerica<Integer> numerosParesInOrden(ArbolBinario<Integer> ab) {
		ListaEnlazadaGenerica<Integer> listaPares = new ListaEnlazadaGenerica<Integer>();
		if(ab.tieneHijoIzquierdo())
			numerosParesInOrden(ab.getHijoIzquierdo());
		if(ab.getDato()%2==0)
			listaPares.agregarFinal(ab.getDato());
		if(ab.tieneHijoDerecho())
			numerosParesInOrden(ab.getHijoDerecho());
		return listaPares;
	}
	*/

	public static void main(String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(40);
		ArbolBinario<Integer> n25 = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> n78 = new ArbolBinario<Integer>(78);
		ArbolBinario<Integer> n10 = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> n32 = new ArbolBinario<Integer>(32);
		
		n25.agregarHijoIzquierdo(n10);
		n25.agregarHijoDerecho(n32);
		arbol.agregarHijoIzquierdo(n25);
		arbol.agregarHijoDerecho(n78);
		
		//Forma 1
		//ListaEnlazadaGenerica<Integer> l =new ListaEnlazadaGenerica<Integer>();
		//numerosParesInOrden(arbol,l);
		
		//Forma 2
		//ListaEnlazadaGenerica<Integer> l = numerosParesInOrden(arbol);
		
		
		/*
		l.comenzar();
		while(!l.fin())
			System.out.println(l.proximo());
		*/
		
		
		
		/*
		System.out.println("PreOrden");
		arbol.printPreOrden();
		System.out.println("InOrden");
		arbol.printInOrden();
		System.out.println("PostOrden");
		arbol.printPostOrden();
		*/
		
		
	}

}
