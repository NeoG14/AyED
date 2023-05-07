package tp04.parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

// implemente un metodo resolver(ArbolBinario<Integer> arbol)
//que devuelva una lista con los valores de los nodos que tengan el mismo número de descendientes
//tanto por su subárbol izquierdo como su subárbol derecho
public class EjercicioParcial5 {

	public static ListaGenerica<Integer> resolver(ArbolBinario<Integer> arbol) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		resolver(arbol,lista);
		return lista;
	}
	
	private static int resolver(ArbolBinario<Integer> ab, ListaGenerica<Integer> l) {
		if(!ab.esHoja()) {
			int cont_der=0;
			int cont_izq=0;
			if(ab.tieneHijoIzquierdo())
				cont_izq += resolver(ab.getHijoIzquierdo(),l);
			if(ab.tieneHijoDerecho())
				cont_der += resolver(ab.getHijoDerecho(),l);
			if(cont_der==cont_izq)
				l.agregarFinal(ab.getDato());
		}else 
			l.agregarFinal(ab.getDato());
		return 1;
	}
	
	public static void main(String[] args) {
		ArbolBinario<Integer> n2 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> n1 = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> n5 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> n16 = new ArbolBinario<Integer>(16);
		ArbolBinario<Integer> n6 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> n8 = new ArbolBinario<Integer>(8);
		ArbolBinario<Integer> n22 = new ArbolBinario<Integer>(22);
		
		n2.agregarHijoIzquierdo(n1);
		n2.agregarHijoDerecho(n5);
		n1.agregarHijoIzquierdo(n16);
		n1.agregarHijoDerecho(n6);
		n5.agregarHijoDerecho(n8);
		n8.agregarHijoIzquierdo(n22);
		
		ListaGenerica<Integer> l = resolver(n2);
		l.comenzar();
		while(!l.fin())
			System.out.print(l.proximo()+" ");
	}
}
