package tp04.recorridos;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Recorridos {
	
	public static void ImprimirLista(ListaGenerica<Character> lista) {
		lista.comenzar();
		while(!lista.fin())
			System.out.print(lista.proximo()+", ");
		System.out.println();
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
		ArbolGeneral<Character> J = new ArbolGeneral<Character>('J');
		ArbolGeneral<Character> K = new ArbolGeneral<Character>('K');
		ArbolGeneral<Character> L = new ArbolGeneral<Character>('L');
		ArbolGeneral<Character> M = new ArbolGeneral<Character>('M');
		ArbolGeneral<Character> N = new ArbolGeneral<Character>('N');
		ArbolGeneral<Character> O = new ArbolGeneral<Character>('O');
		
		A.agregarHijo(B);
		A.agregarHijo(C);
		A.agregarHijo(D);
		A.agregarHijo(E);
		A.agregarHijo(F);
		A.agregarHijo(G);
		
		B.agregarHijo(O);
		
		C.agregarHijo(H);
		C.agregarHijo(I);
		C.agregarHijo(J);
		
		E.agregarHijo(K);
		E.agregarHijo(L);
		E.agregarHijo(M);
		
		ListaGenerica<Character> preOrden = A.preOrden(A);
		ListaGenerica<Character> postOrden = A.postOrden(A);
		ListaGenerica<Character> inOrden = A.InOrden(A);
		
		System.out.println("PreOrden");
		ImprimirLista(preOrden);
		System.out.println("PostOrden");
		ImprimirLista(postOrden);
		System.out.println("InOrden");
		ImprimirLista(inOrden);
		
	}
}
