package tp03.caminoMasLejano;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class CaminosArbolesBinarios {

	//Retorna el primer Camino mas Largo que encuentra de un arbol binario
	public static ListaGenerica<Integer> caminoMasLargo(ArbolBinario<Integer> ab) {
		ListaGenerica<Integer> camMasLargo = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<Integer>();
		if(!ab.esVacio())
			calcularCamino(ab,camMasLargo,camAct);
		return camMasLargo;
	}
	private static void calcularCamino (ArbolBinario<Integer> ab, ListaGenerica<Integer> camMasLargo, ListaGenerica<Integer> camAct) {
		camAct.agregarFinal(ab.getDato());
		if(ab.esHoja()) {
			if(camAct.tamanio()>camMasLargo.tamanio()) {
				eliminarTodo(camMasLargo);
				camAct.comenzar();
				while(!camAct.fin()) 
					camMasLargo.agregarFinal(camAct.proximo());

			}	
		}else {
			if(ab.tieneHijoIzquierdo()) 
				calcularCamino(ab.getHijoIzquierdo(),camMasLargo,camAct);	
			if(ab.tieneHijoDerecho()) 
				calcularCamino(ab.getHijoDerecho(),camMasLargo,camAct);
		}
		camAct.eliminarEn(camAct.tamanio());
	}
	
	//Retorna el camino más largo con mayor peso de un arbol binario
	public static ListaGenerica<Integer> caminoMasLargoMayorPeso(ArbolBinario<Integer> ab){
		int max=0;
		int sumaAct=0;
		ListaGenerica<Integer> camMasLargo = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<Integer>();
		if(!ab.esVacio())
			calcularCaminoConMayorPeso(ab,camMasLargo,camAct,max,sumaAct);
		return camMasLargo;
	}
	
	private static int calcularCaminoConMayorPeso(ArbolBinario<Integer> ab, ListaGenerica<Integer> camMasLargo, ListaGenerica<Integer> camAct, int max, int sumaAct) {
		camAct.agregarFinal(ab.getDato());
		sumaAct+=ab.getDato();
		if(ab.esHoja()) {
			if( (camAct.tamanio()>camMasLargo.tamanio()) || (sumaAct>max)&&(camAct.tamanio()>=camMasLargo.tamanio()) ) {
				max=sumaAct;
				eliminarTodo(camMasLargo);
				camAct.comenzar();
				while(!camAct.fin())
					camMasLargo.agregarFinal(camAct.proximo());
			}
		}else {
			if(ab.tieneHijoIzquierdo())
				max = calcularCaminoConMayorPeso(ab.getHijoIzquierdo(),camMasLargo,camAct,max,sumaAct);
			if(ab.tieneHijoDerecho())
				max = calcularCaminoConMayorPeso(ab.getHijoDerecho(),camMasLargo,camAct,max,sumaAct);
		}
		camAct.eliminarEn(camAct.tamanio());
		return max;
	}
	
	//Retorna todos los caminos mas largos de un arbol binario
	public static ListaGenerica<ListaGenerica<Integer>> caminosMasLargos(ArbolBinario<Integer> ab) {
		ListaGenerica<ListaGenerica<Integer>> caminos = new ListaEnlazadaGenerica<ListaGenerica<Integer>>();
		ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<Integer>();
		calcularCaminos(ab,caminos,camAct);
		return caminos;
	}
	
	private static void calcularCaminos(ArbolBinario<Integer> ab,ListaGenerica<ListaGenerica<Integer>> cam,ListaGenerica<Integer> camAct) {
		camAct.agregarFinal(ab.getDato());
		if(ab.esHoja()) {
			if(cam.esVacia())
				cam.agregarFinal(camAct.clonar());
			else
				if(camAct.tamanio() == cam.elemento(1).tamanio()) 
					cam.agregarFinal(camAct.clonar());
				else if(camAct.tamanio() > cam.elemento(1).tamanio()) {
					eliminarTodos(cam);
					cam.agregarFinal(camAct.clonar());
				}
		}else {
			if(ab.tieneHijoIzquierdo())
				calcularCaminos(ab.getHijoIzquierdo(),cam,camAct);
			if(ab.tieneHijoDerecho())
				calcularCaminos(ab.getHijoDerecho(),cam,camAct);
		}	
		camAct.eliminarEn(camAct.tamanio());
	}
	
	//Borra todos los elementos de la lista
	public static void eliminarTodo(ListaGenerica<Integer> l) {
		l.comenzar();
		while(!l.fin()) {
			l.eliminarEn(1);
			l.proximo();
		}
	}
	//Borra todo los elemento de la lista de listas
	public static void eliminarTodos(ListaGenerica<ListaGenerica<Integer>> l) {
		l.comenzar();
		while(!l.fin()) {
			l.eliminarEn(1);
			l.proximo();
		}
	}
	
	public static void main(String[] args) {
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(1);
		
		
		ArbolBinario<Integer> n2 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> n4 = new ArbolBinario<Integer>(4);
		
		ArbolBinario<Integer> n3 = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> n5 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> n6 = new ArbolBinario<Integer>(6);
		
		ArbolBinario<Integer> n8 = new ArbolBinario<Integer>(8);
		ArbolBinario<Integer> n7 = new ArbolBinario<Integer>(7);
		
		ArbolBinario<Integer> n16 = new ArbolBinario<Integer>(16);
		ArbolBinario<Integer> n9 = new ArbolBinario<Integer>(9);
		
		ArbolBinario<Integer> n10 = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> n11 = new ArbolBinario<Integer>(11);
		
		ab.agregarHijoIzquierdo(n2);
		ab.agregarHijoDerecho(n4);
		
		n2.agregarHijoIzquierdo(n3);
		//n2.agregarHijoDerecho(n999);
		n4.agregarHijoIzquierdo(n5);
		n4.agregarHijoDerecho(n6);
		
		n5.agregarHijoIzquierdo(n8);
		n6.agregarHijoDerecho(n7);
		
		n8.agregarHijoIzquierdo(n16);
		n8.agregarHijoDerecho(n10);
		n7.agregarHijoDerecho(n9);
		
		n10.agregarHijoIzquierdo(n11);
		
		//n16.agregarHijoDerecho(n999);
		//ab.recorridoPorNiveles();
		
		//ListaGenerica<Integer> camino = caminoMasLargo(ab);
		//ListaGenerica<Integer> camino = caminoMasLargoMayorPeso(ab);
		ListaGenerica<ListaGenerica<Integer>> caminos = caminosMasLargos(ab);
		
		/*
		camino.comenzar();
		while(!camino.fin())
			System.out.println(camino.proximo());
		*/
		
		
		caminos.comenzar();
		while(!caminos.fin()) {
			ListaGenerica<Integer> camino = caminos.proximo();
			camino.comenzar();
			while(!camino.fin())
				System.out.print(camino.proximo()+", ");
			System.out.println();
		}
			
		
			
			
		
		
	}
}
