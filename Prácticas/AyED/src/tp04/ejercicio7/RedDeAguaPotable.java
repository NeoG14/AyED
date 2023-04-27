package tp04.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
	public ArbolGeneral<Character> red;
	
	public RedDeAguaPotable() {
		red = new ArbolGeneral<Character>('A');
	}

	public double minimoCaudal(double caudal) {
		double min = 9999;
		return minimoCaudal(caudal,min,red);	
	}
	
	private double minimoCaudal(double caudal,double min,ArbolGeneral<Character> ab) {
		if(ab.esHoja()) 
			if(caudal<min)
				min=caudal;
		if(ab.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Character>> lHijos = ab.getHijos();
			lHijos.comenzar();
			double caudalAct = caudal/lHijos.tamanio();
			while(!lHijos.fin()) {
				ArbolGeneral<Character> aux = lHijos.proximo();
				min = minimoCaudal(caudalAct,min,aux);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		//RedDeAguaPotable red = new RedDeAguaPotable();
		ArbolGeneral<Integer> ab1 = new ArbolGeneral<Integer>(null);
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
		
		A.agregarHijo(B);
		A.agregarHijo(C);
		A.agregarHijo(D);
		A.agregarHijo(E);
		
		C.agregarHijo(F);
		C.agregarHijo(G);
		
		D.agregarHijo(H);
		D.agregarHijo(I);
		D.agregarHijo(J);
		D.agregarHijo(K);
		
		G.agregarHijo(L);
		J.agregarHijo(M);
		J.agregarHijo(N);
		
		
		//ListaGenerica<Character> l = ab.preOrden();
		
		
		
	}

}
