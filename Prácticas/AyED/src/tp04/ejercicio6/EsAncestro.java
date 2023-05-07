package tp04.ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class EsAncestro {
	
	public static Boolean esAncestro(Integer a,Integer b,ArbolGeneral<Integer> ab) {
		ArbolGeneral<Integer> arbola = new ArbolGeneral<Integer>(null);
		ArbolGeneral<Integer> arbolb = new ArbolGeneral<Integer>(null);
		arbola = devolverSubArbol(a,ab);
		System.out.println(arbola.esVacio());
		if(devolverSubArbol(a,ab) != null)
			return (!devolverSubArbol(b,arbola).esVacio());
		return false;
	}
	
	private static ArbolGeneral<Integer> devolverSubArbol(Integer dato,ArbolGeneral<Integer> ab) {
		ArbolGeneral<Integer> arbol = new ArbolGeneral<Integer>(null);
		if(ab.getDato() == dato) {
			return ab;
		}else
			if(ab.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> lHijos = ab.getHijos();
				lHijos.comenzar();
				while(!lHijos.fin() && arbol.esVacio()) {
					arbol = devolverSubArbol(dato,lHijos.proximo());
				}	
			}
		return arbol;
	}
	/*
	private static ArbolGeneral<Integer> devolverSubArbol(Integer dato,ArbolGeneral<Integer> ab) {
		if(ab.getDato() == dato) {
			ab = devolverArbol2(ab);
		}else
			if(ab.tieneHijos() & ab.esVacio()) {
				ListaGenerica<ArbolGeneral<Integer>> lHijos = ab.getHijos();
				lHijos.comenzar();
				while(!lHijos.fin() & ab.esVacio()) {
					ab = devolverSubArbol(dato,lHijos.proximo());
				}	
			}
		return ab;
	}*/
	/*
	private static ArbolGeneral<Integer> devolverArbol2(ArbolGeneral<Integer> ab) {
		ArbolGeneral<Integer> arbol = new ArbolGeneral<Integer>(null);
		if(ab.esHoja()) {
			arbol.setDato(ab.getDato());
			return arbol;
		}
		if(ab.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = ab.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				ArbolGeneral<Integer> arbol_aux = lHijos.proximo();
				arbol.agregarHijo(devolverArbol2(arbol_aux));
			}
		}
		arbol.setDato(ab.getDato());
		return arbol;	
	}
	*/
	
	
	public static void ImprimirPorNiveles(ArbolGeneral<Integer> a) {
		ListaGenerica<Integer> result = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> arbol_aux;
		cola.encolar(a);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			if(arbol_aux != null) {
				System.out.print(arbol_aux.getDato()+", ");
				if(arbol_aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Integer>> hijos = arbol_aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) 
						cola.encolar(hijos.proximo());
				}
			}else
				if(!cola.esVacia()) {
					System.out.println();
					cola.encolar(null);
				}
					
		}
	}
	
	
	public static void main(String[] args) {
		ArbolGeneral<Integer> n25 = new ArbolGeneral<Integer>(25);
		ArbolGeneral<Integer> n30 = new ArbolGeneral<Integer>(30);
		ArbolGeneral<Integer> n12 = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> n11 = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> n15 = new ArbolGeneral<Integer>(15);
		ArbolGeneral<Integer> n13 = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> n40 = new ArbolGeneral<Integer>(40);
	
		n25.agregarHijo(n30);
		n25.agregarHijo(n12);
		
		n30.agregarHijo(n11);
		n30.agregarHijo(n15);
		n12.agregarHijo(n13);
		
		n15.agregarHijo(n40);
		//ImprimirPorNiveles(n25);
		//System.out.println();
		//ArbolGeneral<Integer> arbol = devolverSubArbol(25,n25);
		//ImprimirPorNiveles(arbol);
		//ArbolGeneral<Integer> arbol2 = devolverSubArbol(11,arbol);
		
		System.out.println(n25.esAncestro(30, 40));
		//ImprimirPorNiveles(arbol2);
		
		/*
		ListaGenerica<Integer> lista = arbol.preOrden(arbol);
		lista.comenzar();
		while(!lista.fin())
			System.out.println(lista.proximo());
		
		/*
		if(arbol.esVacio())
			System.out.println("ARBOL VACIO");
		else {
			ImprimirPorNiveles(arbol);
		}
		*/
			 
		
		
		
		
	}
}
