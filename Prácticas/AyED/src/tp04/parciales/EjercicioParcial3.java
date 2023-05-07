package tp04.parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

//un metodo  que devuelve una lista con la suma de los datos contenidos
//en los hijos del nodo del arbol que tiene un numero impar de hijos realize un recorrido PostOrden
public class EjercicioParcial3 {
	private ArbolGeneral<Integer> ab = new ArbolGeneral<Integer>(2);
	
	public EjercicioParcial3() {
		ArbolGeneral<Integer> n1 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> n12 = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> n14 = new ArbolGeneral<Integer>(14);
		ArbolGeneral<Integer> n5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> n4 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> n8 = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> n44 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> n7 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> n9 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> n10 = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> n55 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> n3 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> n13 = new ArbolGeneral<Integer>(13);
		
		ab.agregarHijo(n1);
		ab.agregarHijo(n12);
		ab.agregarHijo(n14);
		
		n1.agregarHijo(n5);
		n1.agregarHijo(n4);
		n4.agregarHijo(n9);
		n4.agregarHijo(n10);
		n4.agregarHijo(n55);
		
		n12.agregarHijo(n8);
		n12.agregarHijo(n44);
		n12.agregarHijo(n7);
		
		n8.agregarHijo(n3);
		n7.agregarHijo(n13);
	}
	
	
	public ArbolGeneral<Integer> getAb() {
		return ab;
	}


	public ListaGenerica<Integer> resolver(){
		ListaGenerica<Integer> sumas = new ListaEnlazadaGenerica<Integer>();
		if(!ab.esVacio())
			resolver(sumas,this.ab);
		return sumas;
	}
	
	private int resolver(ListaGenerica<Integer> l, ArbolGeneral<Integer> ab) {
		ListaGenerica<ArbolGeneral<Integer>> lHijos = ab.getHijos();
		lHijos.comenzar();
		int suma = 0;
		while(!lHijos.fin())
			suma += resolver(l,lHijos.proximo());
		if(!ab.esHoja())
			if(lHijos.tamanio()%2 == 1)
				l.agregarFinal(suma);
		return ab.getDato();
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
		EjercicioParcial3 p = new EjercicioParcial3();
		
		//ImprimirPorNiveles(p.getAb());
		ListaGenerica<Integer> lista = p.resolver();
		lista.comenzar();
		while(!lista.fin()) {
			System.out.print(lista.proximo()+", ");
		}
	}
}
