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
		
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a11 = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> a13 = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> a17 = new ArbolGeneral<Integer>(17);
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(9);
		
		a5.agregarHijo(a11);
		a5.agregarHijo(a13);
		a5.agregarHijo(a7);
		a11.agregarHijo(a9);
		a11.agregarHijo(a17);
		
		ListaGenerica<Integer> l = numerosImparesMayoresQuePorNiveles(a5,3);
		l.comenzar();
		while(!l.fin()) {
			System.out.println(l.proximo());
		}

		
	}
}
