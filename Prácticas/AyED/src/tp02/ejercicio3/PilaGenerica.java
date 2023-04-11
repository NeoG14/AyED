package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {
	private ListaGenerica<T> datos;
	
	public PilaGenerica() {
		this.datos = new ListaEnlazadaGenerica<T>();
	}
	
	public void apilar(T elem) {
		this.datos.agregarFinal(elem);
	}
	
	public T desapilar() {
		if(datos.esVacia())
			return null;
		T dato = this.datos.elemento(datos.tamanio());
		this.datos.eliminarEn(datos.tamanio());
		return dato;
	}
	
	public T tope() {
		return this.datos.elemento(datos.tamanio());
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
		
}

