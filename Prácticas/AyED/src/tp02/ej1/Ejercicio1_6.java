package tp02.ej1;
import tp02.ejercicio1.*;

public class Ejercicio1_6 {
	//static ListaDeEnteros l = new ListaDeEnterosEnlazada();
	
	private static void calcular(int n,ListaDeEnteros l) {
		l.agregarFinal(n);
		if(n!=1) {
			if(n%2==0)
				calcular(n/2,l);
			else
				calcular(3*n+1,l);
		}
	}
	
	public static ListaDeEnterosEnlazada calcularSucesion(int n) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		calcular(n,l);
		return l;
		
	}
	
	public static void recorrerLista(ListaDeEnteros l) {
		l.comenzar();
		while(!l.fin())
			System.out.println(l.proximo());
	}

	public static void main(String[] args) {
		Ejercicio1_6 f = new Ejercicio1_6();
		ListaDeEnterosEnlazada l = f. calcularSucesion(6);
		recorrerLista(l);

	}

}
