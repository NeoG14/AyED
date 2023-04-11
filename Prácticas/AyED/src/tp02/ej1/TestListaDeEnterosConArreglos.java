package tp02.ej1;
import tp02.ejercicio1.*;

public class TestListaDeEnterosConArreglos {
	
	public static void main(String[] args) {
		ListaDeEnteros lista = new ListaDeEnterosConArreglos();
		lista.agregarFinal(5);
		lista.agregarFinal(6);
		lista.agregarFinal(7);
		lista.agregarFinal(8);
		System.out.println(lista.agregarEn(4, 1));
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
	}
}
