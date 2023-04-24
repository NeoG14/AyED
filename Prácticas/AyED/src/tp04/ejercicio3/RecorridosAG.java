package tp04.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG {

	public static ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePreOrden(a,n,lista);
		return lista;
	}
	
	private static void numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l) {
		if(a.getDato()>n) {
			if(a.getDato()%2!=0)
				l.agregarFinal(a.getDato());
		}
		if(a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				numerosImparesMayoresQuePreOrden(lHijos.proximo(),n,l);
			}
		}	
	}
	
	public static ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQueInOrden(a,n,lista);
		return lista;
	}
		
	private static void numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l) {
		if(a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
			lHijos.comenzar();
			if(!lHijos.fin()) {
				numerosImparesMayoresQueInOrden(lHijos.proximo(),n,l);
				if ( (a.getDato()>n) && (a.getDato()%2!=0) )
					l.agregarFinal(a.getDato());
			}
			while(!lHijos.fin()) 
				numerosImparesMayoresQueInOrden(lHijos.proximo(),n,l);
		}else
			if ( (a.getDato()>n) && (a.getDato()%2!=0) )
				l.agregarFinal(a.getDato());
			
			
	}
		
	public static ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePostOrden(a,n,lista);
		return lista;
	}
		
	private static void numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l) {
		if(a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				numerosImparesMayoresQuePostOrden(lHijos.proximo(),n,l);
			}
			if ( (a.getDato()>n) && (a.getDato()%2!=0) )
				l.agregarFinal(a.getDato());
		}else
			if ( (a.getDato()>n) && (a.getDato()%2!=0) )
				l.agregarFinal(a.getDato());		
	}
	
	public static ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> result = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> arbol_aux;
		cola.encolar(a);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			if(arbol_aux != null) {
				if(arbol_aux.getDato()>n && arbol_aux.getDato()%2!=0)
					result.agregarFinal(arbol_aux.getDato());
				if(arbol_aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Integer>> hijos = arbol_aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) 
						cola.encolar(hijos.proximo());
				}
			}else
				if(!cola.esVacia())
					cola.encolar(null);
		}
		return result;
	}

	
	/*
	public static ListaGenerica<Integer> preOrden(ArbolGeneral<Integer> a) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		preOrden(a,lista);
		return lista;
	}
	
	private static void preOrden(ArbolGeneral<Integer> a,ListaGenerica<Integer> l) {
		 l.agregarFinal(a.getDato());
		 ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
		 lHijos.comenzar();
		 while (!lHijos.fin()) {
			 preOrden(lHijos.proximo(),l);
		 }
	}
	
	public static ListaGenerica<Integer> inOrden(ArbolGeneral<Integer> a) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		inOrden(a,lista);
		return lista;
	}
	
	private static void inOrden(ArbolGeneral<Integer> a,ListaGenerica<Integer> l) {
		if(a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
			lHijos.comenzar();
			if(!lHijos.fin()) {
				inOrden(lHijos.proximo(),l);
				l.agregarFinal(a.getDato());
			}
			while (!lHijos.fin()) {
				 inOrden(lHijos.proximo(),l);
			 }
			
		}else 
			l.agregarFinal(a.getDato());	 
	}
	 */

	
	
	
	public static void main(String[] args) {
		
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> a8 = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a10 = new ArbolGeneral<Integer>(10);
		
		a1.agregarHijo(a2);
		a1.agregarHijo(a3);
		a1.agregarHijo(a4);
		a1.agregarHijo(a5);
		
		a2.agregarHijo(a6);
		a3.agregarHijo(a7);
		a4.agregarHijo(a8);
		a4.agregarHijo(a9);
		a4.agregarHijo(a10);

		
		System.out.println(a1.ancho());

		
	}
}
