package tp04.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
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
			if(a.getDato()>n) {
				if(a.getDato()%2!=0)
					l.agregarFinal(a.getDato());
			}
		}else
			if(a.esHoja()) {
				if(a.getDato()>n) {
					if(a.getDato()%2!=0)
						l.agregarFinal(a.getDato());
				}
			}
	}
	
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
			
		}else {
			l.agregarFinal(a.getDato());
		}
		 
		 
		 
	}


	
	
	
	public static void main(String[] args) {
		/*
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
		
		ListaGenerica<Integer> l = numerosImparesMayoresQuePostOrden(a5,3);
		l.comenzar();
		while(!l.fin()) {
			System.out.println(l.proximo());
		}
		*/
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(6);
		
		a1.agregarHijo(a3);
		a1.agregarHijo(a4);
		a1.agregarHijo(a5);
		a3.agregarHijo(a6);
		a3.agregarHijo(a6);
		
		ListaGenerica<Integer> l = inOrden(a1);
		while(!l.fin()) {
			System.out.println(l.proximo());
		}
		
	}
}
