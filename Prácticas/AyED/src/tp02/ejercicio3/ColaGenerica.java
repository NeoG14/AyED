package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ColaGenerica<T> {
	private ListaGenerica<T> datos;
	
	public ColaGenerica() {
		this.datos = new ListaEnlazadaGenerica<T>();
	}
	
	public void encolar(T elem) {
		datos.agregarFinal(elem);
	}
	
	public T desencolar( ) {
		if(datos.esVacia()) 
			return null;
		T dato = datos.elemento(1);
		datos.eliminarEn(1);
		return dato;
	}
	
	public T tope() {
		if(!datos.esVacia())
			return datos.elemento(datos.tamanio());
		return null;
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
	
	
}
