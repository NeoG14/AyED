package tp03.ejercicio1;

import tp02.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int hojas = 0;
		if(this.esHoja())
				hojas++;
		else {
			if(this.tieneHijoDerecho())
				hojas += this.getHijoDerecho().contarHojas();
			if(this.tieneHijoIzquierdo())
				hojas += this.getHijoIzquierdo().contarHojas();
			}	
		return hojas;
	}
	

    public ArbolBinario<T> espejo() {
    	ArbolBinario<T> ab = new ArbolBinario<T>();
    	ab.setDato(this.getDato());
    	if(this.esVacio())
    		return null;
    	else {
    		if(this.tieneHijoIzquierdo()) 
    			ab.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
    		if(this.tieneHijoDerecho())
    			ab.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
    	}
    	return ab;	
	}


	public void entreNiveles(int n, int m){
		if(n>=0 & m>n) {
			int nvl = 1;
			ArbolBinario<T> arbol = null;
			ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
			cola.encolar(this);
			cola.encolar(null);
			if(nvl>=n & nvl<=m)
				System.out.print("nivel "+nvl +": ");
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				if (arbol!= null) {
					if(nvl>=n & nvl<=m)
						System.out.print(arbol.getDato()+" ");
					if(arbol.tieneHijoIzquierdo())
						cola.encolar(arbol.getHijoIzquierdo());
					if(arbol.tieneHijoDerecho())
						cola.encolar(arbol.getHijoDerecho());
				}else if (!cola.esVacia()) {
					++nvl;
					if(nvl>=n & nvl<=m) {
						System.out.println();
						System.out.print("nivel "+ nvl +": ");
					}
					cola.encolar(null);
				}
			}
		}
		
	}
	
	public void recorridoPorNiveles() {
		int n = 1;
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		System.out.print("nivel "+n++ +": ");
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol!= null) {
				System.out.print(arbol.getDato()+" ");
				if(arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			}else if (!cola.esVacia()) {
				System.out.println();
				System.out.print("nivel "+n++ +": ");
				cola.encolar(null);
			}
		}
	}
	
	public void printPreOrden() {
		System.out.println(this.getDato());
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPreOrden();
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printPreOrden();
	}
	
	public void printPostOrden() {
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPostOrden();
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printPostOrden();
		System.out.println(this.getDato());
	}
	
	public void printInOrden() {
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printInOrden();
		System.out.println(this.getDato());
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printInOrden();
	}


	

}
