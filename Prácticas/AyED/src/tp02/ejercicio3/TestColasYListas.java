package tp02.ejercicio3;

public class TestColasYListas {

	public static void main(String[] args) {
		ColaGenerica<Integer> cola = new ColaGenerica<Integer>();
		PilaGenerica<Integer> pila = new PilaGenerica<Integer>();
		
		pila.apilar(5);
		pila.apilar(4);
		pila.apilar(3);
		pila.apilar(2);
		pila.apilar(1);
		while(!pila.esVacia()) {
			System.out.println(pila.desapilar());
		}
		
		cola.encolar(5);
		cola.encolar(4);
		cola.encolar(3);
		cola.encolar(2);
		cola.encolar(1);
		/*
		while(!cola.esVacia()) {
			System.out.println(cola.desencolar());
		}*/
		
		
		//System.out.println(cola.esVacia());

	}

}
