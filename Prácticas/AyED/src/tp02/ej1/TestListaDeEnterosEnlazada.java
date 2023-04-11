package tp02.ej1;
import tp02.ejercicio1.*;

public class TestListaDeEnterosEnlazada {
	
	public static void imprimirInverso(ListaDeEnteros l) {
		int n;
		if(!l.fin()) {
			n=l.proximo();
			imprimirInverso(l);
			System.out.println(n);
		}
			
	}

	public static void main(String[] args) {
		ListaDeEnteros lista = new ListaDeEnterosEnlazada();
		lista.agregarFinal(5);
		lista.agregarFinal(6);
		lista.agregarFinal(7);
		lista.agregarFinal(8);
		lista.comenzar();
		imprimirInverso(lista);

	}

}
