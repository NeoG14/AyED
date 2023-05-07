package tp04.parciales;

import tp03.ejercicio1.ArbolBinario;

public class UltimoParcial {
	public ArbolBinario<Integer> ab = new ArbolBinario<>(2);
	
	public UltimoParcial() {
		ArbolBinario<Integer> n7 = new ArbolBinario<>(7);
		ArbolBinario<Integer> n9 = new ArbolBinario<>(9);
		ArbolBinario<Integer> n23 = new ArbolBinario<>(23);
		ArbolBinario<Integer> n16 = new ArbolBinario<>(16);
		ArbolBinario<Integer> n29 = new ArbolBinario<>(29);
		ArbolBinario<Integer> n12 = new ArbolBinario<>(12);
		ArbolBinario<Integer> n3 = new ArbolBinario<>(3);
		ArbolBinario<Integer> n19 = new ArbolBinario<>(19);
		ArbolBinario<Integer> n21 = new ArbolBinario<>(21);
		ArbolBinario<Integer> n13 = new ArbolBinario<>(13);
		ArbolBinario<Integer> n14 = new ArbolBinario<>(14);
		ArbolBinario<Integer> n90 = new ArbolBinario<>(90);
		
		ab.agregarHijoIzquierdo(n7);
		ab.agregarHijoDerecho(n9);
		n7.agregarHijoIzquierdo(n23);
		n7.agregarHijoDerecho(n16);
		n23.agregarHijoIzquierdo(n3);
		n16.agregarHijoIzquierdo(n19);
		n16.agregarHijoDerecho(n21);
		n9.agregarHijoIzquierdo(n29);
		n9.agregarHijoDerecho(n12);
		n12.agregarHijoIzquierdo(n13);
		n13.agregarHijoIzquierdo(n14);
		n14.agregarHijoIzquierdo(n90);
	}
	
	public boolean isLeftTree(int num) {
		ArbolBinario<Integer> arbol = DevolverArbol(this.ab, num);
		if(!arbol.esVacio()) 
			return calcular(arbol,num);
		return false;
		
		
	}
	
	private ArbolBinario<Integer> DevolverArbol(ArbolBinario<Integer> ab,int num){
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(null);
		if(ab.getDato().equals(num))
			return ab;
		if(ab.tieneHijoIzquierdo() & arbol.esVacio())
			arbol = DevolverArbol(ab.getHijoIzquierdo(),num);
		if(ab.tieneHijoDerecho() & arbol.esVacio())
			arbol = DevolverArbol(ab.getHijoDerecho(),num);
		return arbol;
	}
	
	private boolean calcular(ArbolBinario<Integer> ab, int num) {
		int izq=0;
		int der=0;
		if(ab.tieneHijoIzquierdo())
			izq = calcular2(ab.getHijoIzquierdo());
		else
			if(ab.tieneHijoDerecho())
				izq=-1;
		if(ab.tieneHijoDerecho())
			der = calcular2(ab.getHijoDerecho());
		else
			if(ab.tieneHijoIzquierdo())
				der = -1;
		System.out.println(izq+","+der);
		return (izq > der);
			
	}
	
	private int calcular2(ArbolBinario<Integer> ab) {
		int cont=0;
		if(ab.tieneHijoIzquierdo())
			cont += calcular2(ab.getHijoIzquierdo());
		if(ab.tieneHijoDerecho())
			cont += calcular2(ab.getHijoDerecho());
		if(!ab.esHoja()) {
			if( (ab.tieneHijoIzquierdo() & !ab.tieneHijoDerecho()) | (ab.tieneHijoDerecho() & !ab.tieneHijoIzquierdo())) {
				cont++;
			}		
		}	
		return cont;
	}

	public static void main(String[] args) {
		UltimoParcial up = new UltimoParcial();
		System.out.println(up.isLeftTree(23));
	}
}
