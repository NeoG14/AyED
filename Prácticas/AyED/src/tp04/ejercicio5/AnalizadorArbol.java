package tp04.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {

	public static int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol) {
		int max = -1;
		int total=0;
		int cant=0;
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> ab_aux;
		if(!arbol.esVacio()) {
			cola.encolar(arbol);
			cola.encolar(null);
			while(!cola.esVacia()) {
				ab_aux=cola.desencolar();
				if(ab_aux != null) {
					total+=ab_aux.getDato().getTardanza();
					cant++;
					if(ab_aux.tieneHijos()) {
						ListaGenerica<ArbolGeneral<AreaEmpresa>> lHijos = ab_aux.getHijos();
						lHijos.comenzar();
						while(!lHijos.fin())
							cola.encolar(lHijos.proximo());
					}
				}else {
					if(!cola.esVacia())
						cola.encolar(null);
					total = total/cant;
					if(total>max) 
						max=total;
					total=0;
					cant=0;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		AreaEmpresa M = new AreaEmpresa("M",14);
		AreaEmpresa J = new AreaEmpresa("J",13);
		AreaEmpresa K = new AreaEmpresa("K",25);
		AreaEmpresa L = new AreaEmpresa("L",10);
		AreaEmpresa A = new AreaEmpresa("A",4);
		AreaEmpresa B = new AreaEmpresa("B",7);
		AreaEmpresa C = new AreaEmpresa("C",5);
		AreaEmpresa D = new AreaEmpresa("D",6);
		AreaEmpresa E = new AreaEmpresa("E",10);
		AreaEmpresa F = new AreaEmpresa("F",18);
		AreaEmpresa G = new AreaEmpresa("G",9);
		AreaEmpresa H = new AreaEmpresa("H",12);
		AreaEmpresa I = new AreaEmpresa("I",19);
		
		
		ArbolGeneral<AreaEmpresa> abM = new ArbolGeneral<AreaEmpresa>(M);
		ArbolGeneral<AreaEmpresa> abJ = new ArbolGeneral<AreaEmpresa>(J);
		ArbolGeneral<AreaEmpresa> abK = new ArbolGeneral<AreaEmpresa>(K);
		ArbolGeneral<AreaEmpresa> abL = new ArbolGeneral<AreaEmpresa>(L);
		ArbolGeneral<AreaEmpresa> abA = new ArbolGeneral<AreaEmpresa>(A);
		ArbolGeneral<AreaEmpresa> abB = new ArbolGeneral<AreaEmpresa>(B);
		ArbolGeneral<AreaEmpresa> abC = new ArbolGeneral<AreaEmpresa>(C);
		ArbolGeneral<AreaEmpresa> abD = new ArbolGeneral<AreaEmpresa>(D);
		ArbolGeneral<AreaEmpresa> abE = new ArbolGeneral<AreaEmpresa>(E);
		ArbolGeneral<AreaEmpresa> abF = new ArbolGeneral<AreaEmpresa>(F);
		ArbolGeneral<AreaEmpresa> abG = new ArbolGeneral<AreaEmpresa>(G);
		ArbolGeneral<AreaEmpresa> abH = new ArbolGeneral<AreaEmpresa>(H);
		ArbolGeneral<AreaEmpresa> abI = new ArbolGeneral<AreaEmpresa>(I);
		
		abM.agregarHijo(abJ);
		abM.agregarHijo(abK);
		abM.agregarHijo(abL);
		
		abJ.agregarHijo(abA);
		abJ.agregarHijo(abB);
		abJ.agregarHijo(abC);
		abK.agregarHijo(abD);
		abK.agregarHijo(abE);
		abK.agregarHijo(abF);
		abL.agregarHijo(abG);
		abL.agregarHijo(abH);
		abL.agregarHijo(abI);
		
		System.out.println(devolverMaximoPromedio(abM));
		
	}
}
