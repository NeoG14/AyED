package tp04.parciales;
//Devolver el camino a la hoja mas lejana.
//Si hubiese más de un camino de igual longitud máxima devolver el primero que encuentre

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class EjercicioParcial4 {
	
	public static ListaGenerica<Integer> caminoMasLejano(ArbolGeneral<Integer> arbol){
		ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<Integer>();
		if(!arbol.esVacio())
			caminoMasLejano(arbol,camAct,camino);
		return camino;
	}
	
	private static void caminoMasLejano(ArbolGeneral<Integer> ab, ListaGenerica<Integer> camAct,ListaGenerica<Integer> camino){
		camAct.agregarFinal(ab.getDato());
		if(!ab.esHoja()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = ab.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				caminoMasLejano(lHijos.proximo(),camAct,camino);
				camAct.eliminarEn(camAct.tamanio());
			}		
		}else
			if(camAct.tamanio()>camino.tamanio())
				clonar(camAct,camino);
	}

	
	
	private static void clonar(ListaGenerica<Integer> l1, ListaGenerica<Integer> l2) {
		while(l2.tamanio()>0)
			l2.eliminarEn(l2.tamanio());
		l1.comenzar();
		while(!l1.fin())
			l2.agregarFinal(l1.proximo());	
	}
	
	public static void main(String[] args) {
		ArbolGeneral<Integer> n8 = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> n3 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> n5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> n4 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> n7 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> n6 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> n2 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> n1 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> n9 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> n10 = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> n11 = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> n12 = new ArbolGeneral<Integer>(12);
		
		n8.agregarHijo(n3);
		n8.agregarHijo(n5);
		
		n3.agregarHijo(n4);
		n3.agregarHijo(n7);
		n3.agregarHijo(n6);
		
		n5.agregarHijo(n1);
		n5.agregarHijo(n9);
		n5.agregarHijo(n10);
		
		n7.agregarHijo(n2);
		
		n9.agregarHijo(n11);
		//n11.agregarHijo(n12);
		
		ListaGenerica<Integer> l = caminoMasLejano(n8);
		l.comenzar();
		while(!l.fin())
			System.out.print(l.proximo()+" ");
	}
}
