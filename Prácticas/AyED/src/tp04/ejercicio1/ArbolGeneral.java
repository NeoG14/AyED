package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenerica<T> preOrden(ArbolGeneral<T> a) {
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		preOrden(a,lista);
		return lista;
	}
	
	private void preOrden(ArbolGeneral<T> a,ListaGenerica<T> l) {
		 l.agregarFinal(a.getDato());
		 ListaGenerica<ArbolGeneral<T>> lHijos = a.getHijos();
		 lHijos.comenzar();
		 while (!lHijos.fin()) {
			 preOrden(lHijos.proximo(),l);
		 }
	}
	
	public ListaGenerica<T> postOrden(ArbolGeneral<T> a) {
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		postOrden(a,lista);
		return lista;
	}
	
	private void postOrden(ArbolGeneral<T> a,ListaGenerica<T> l) {
		 ListaGenerica<ArbolGeneral<T>> lHijos = a.getHijos();
		 lHijos.comenzar();
		 while (!lHijos.fin()) {
			 postOrden(lHijos.proximo(),l);
		 }
		 l.agregarFinal(a.getDato());
	}
	
	public ListaGenerica<T> InOrden(ArbolGeneral<T> a) {
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		InOrden(a,lista);
		return lista;
	}
	
	private void InOrden(ArbolGeneral<T> a,ListaGenerica<T> l) {
		 ListaGenerica<ArbolGeneral<T>> lHijos = a.getHijos();
		 lHijos.comenzar();
		 if(!lHijos.fin()) {
			 InOrden(lHijos.proximo(),l);
		 }
		 l.agregarFinal(a.getDato());
		 while (!lHijos.fin()) {
			 InOrden(lHijos.proximo(),l);
		 }
	}
	
	public Integer altura() {
		int altura=-1;
		if (this.esHoja())
			return 0;
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
			lhijos.comenzar();
			while (!lhijos.fin())
				altura = Math.max(altura,lhijos.proximo().altura());
		}
		return altura + 1;
	}

	public Integer nivel(T dato) {
		int n=-1;
		if(this.getDato() == dato) 
			return n+1;
		else
			if(this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
				lHijos.comenzar();
				while(!lHijos.fin())
					n = lHijos.proximo().nivel(dato);
			}
		if(n != -1)
			return n+1;
		return n;
	}

	public Integer ancho() {
		int max = -1; int tam_act = 0;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol_aux;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			if(arbol_aux != null) {
				tam_act++;
				if(arbol_aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) 
						cola.encolar(hijos.proximo());
				}
			}else {
				if(!cola.esVacia()) 
					cola.encolar(null);
				if(tam_act>max)
					max=tam_act;
				tam_act = 0;
			}			
		}
		return max;
	}
	
	
	public Boolean esAncestro(T a,T b) {
		//ArbolGeneral<T> arbolA = new ArbolGeneral<T>(null);
		//ArbolGeneral<T> arbolB = new ArbolGeneral<T>(null);
		//arbolA = devolverSubArbol(a,this);
		//if(!arbolA.esVacio())
			//arbolB = devolverSubArbol(b,arbolA);
		//return (!arbolB.esVacio());
		return (!devolverSubArbol(b,devolverSubArbol(a,this)).esVacio());
	}
	
	private ArbolGeneral<T> devolverSubArbol(T dato,ArbolGeneral<T> ab) {
		ArbolGeneral<T> arbol = new ArbolGeneral<T>(null);
		if(ab.getDato().equals(dato)) {
			return ab;
		}else
			if(ab.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> lHijos = ab.getHijos();
				lHijos.comenzar();
				while(!lHijos.fin() && arbol.esVacio()) {
					arbol = devolverSubArbol(dato,lHijos.proximo());
				}	
			}
		return arbol;
	}


}