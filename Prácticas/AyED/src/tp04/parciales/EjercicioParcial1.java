package tp04.parciales;
//Dado un arbol general, encontrar todos los caminos desde la raiz a una hoja
//tales que la cantidad de nodos en el camino sea un número par.

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class EjercicioParcial1 {

	public static ListaGenerica<ListaGenerica<Character>> caminosPares(ArbolGeneral<Character> arbol){
		ListaGenerica<ListaGenerica<Character>> listaPares = new ListaEnlazadaGenerica<ListaGenerica<Character>>();
		ListaGenerica<Character> camAct = new ListaEnlazadaGenerica<Character>();
		if(!arbol.esVacio())
			caminosPares(arbol,listaPares,camAct);
		return listaPares;
	}
	
	private static void caminosPares(ArbolGeneral<Character> ab, ListaGenerica<ListaGenerica<Character>> l, ListaGenerica<Character> camAct) {
		camAct.agregarFinal(ab.getDato());
		if(!ab.esHoja()) {
			ListaGenerica<ArbolGeneral<Character>> lHijos = ab.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				caminosPares(lHijos.proximo(),l,camAct);
				camAct.eliminarEn(camAct.tamanio());
			}
		}else if(camAct.tamanio()%2 == 1)
			l.agregarFinal(camAct.clonar());
	}
	
	public static void imprimirListas(ListaGenerica<ListaGenerica<Character>> l) {
		l.comenzar();
		while(!l.fin()) {
			ListaGenerica<Character> lista = l.proximo();
			lista.comenzar();
			while(!lista.fin())
				System.out.print(lista.proximo()+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		ArbolGeneral<Character> A = new ArbolGeneral<Character>('A');
		ArbolGeneral<Character> B = new ArbolGeneral<Character>('B');
		ArbolGeneral<Character> C = new ArbolGeneral<Character>('C');
		ArbolGeneral<Character> D = new ArbolGeneral<Character>('D');
		ArbolGeneral<Character> E = new ArbolGeneral<Character>('E');
		ArbolGeneral<Character> F = new ArbolGeneral<Character>('F');
		ArbolGeneral<Character> G = new ArbolGeneral<Character>('G');
		ArbolGeneral<Character> H = new ArbolGeneral<Character>('H');
		ArbolGeneral<Character> I = new ArbolGeneral<Character>('I');
		
		A.agregarHijo(B);
		A.agregarHijo(C);
		A.agregarHijo(D);
		
		B.agregarHijo(E);
		
		C.agregarHijo(F);
		C.agregarHijo(G);
		
		F.agregarHijo(H);
		F.agregarHijo(I);
		
		imprimirListas(caminosPares(A));
	}
}
