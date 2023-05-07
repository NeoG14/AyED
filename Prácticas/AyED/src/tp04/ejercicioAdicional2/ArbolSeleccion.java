package tp04.ejercicioAdicional2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ArbolSeleccion {

	public static boolean esDeSeleccion(ArbolGeneral<Integer> ab) {
		return  seleccion(ab) != -1;
	}
	/*
	private static int seleccion(ArbolGeneral<Integer> ab) {
		int min = 9999;
		if(ab.esHoja())
			return ab.getDato();
		if(ab.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = ab.getHijos();
			while (min>=ab.getDato()&& !lHijos.fin()) {
				min = Math.min(min, seleccion(lHijos.proximo()));
			}
		}
		if(min == ab.getDato())
			min = ab.getDato();
		else
			min = -1;
		
		return min;
	}
	*/
	private static int seleccion(ArbolGeneral<Integer> ab) {
		int min = 9999;
		if(ab.esHoja())
			return ab.getDato();
		if(ab.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = ab.getHijos();
			while (min>=ab.getDato()&& !lHijos.fin()) {
				min = Math.min(min, seleccion(lHijos.proximo()));
			}
		}
		if(min != ab.getDato())
			min = -1;
		return min;
	}
	
	public static void ImprimirPorNiveles(ArbolGeneral<Integer> a) {
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
		ArbolGeneral<Integer> n12 = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> n14 = new ArbolGeneral<Integer>(14);
		ArbolGeneral<Integer> n13 = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> n12_h = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> n33 = new ArbolGeneral<Integer>(33);
		ArbolGeneral<Integer> n14_h = new ArbolGeneral<Integer>(14);
		ArbolGeneral<Integer> n29 = new ArbolGeneral<Integer>(29);
		ArbolGeneral<Integer> n13_h = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> n15 = new ArbolGeneral<Integer>(15);
		ArbolGeneral<Integer> n40 = new ArbolGeneral<Integer>(40);
		ArbolGeneral<Integer> n12_hh = new ArbolGeneral<Integer>(12);
		
		n12.agregarHijo(n14);
		n12.agregarHijo(n13);
		n12.agregarHijo(n12_h);
		n14.agregarHijo(n33);
		n14.agregarHijo(n14_h);
		n13.agregarHijo(n29);
		n13.agregarHijo(n13_h);
		n13.agregarHijo(n15);
		n12_h.agregarHijo(n40);
		n12_h.agregarHijo(n12_hh);
		
		//ImprimirPorNiveles(n12);
		
		System.out.println(esDeSeleccion(n12));
		
	}
	
	
}
