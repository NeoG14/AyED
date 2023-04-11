package tp02.ej2;

import practica1B.Estudiante;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		Estudiante e1 = new Estudiante("Juan","Carlos","1A","juancarlos@gmail.com","picen 105");
		Estudiante e2 = new Estudiante("Tomas","Bus","3B","tomasbuss@gmail.com","Av libertad 447");
		Estudiante e3 = new Estudiante("Rodolfo","Xdsds","3B","tasdmffdss@gmail.com","Av fartarn 197");
		Estudiante e4 = new Estudiante("Nahel","Xvns","1C","Dagbvd@gmail.com","Av santem 37");
		Estudiante e5 = new Estudiante("Luisito gustavo nahuel","De la virgencita de guadalupe","3C","gnoqui@gmail.com","Av siempreviva 742");
		
		ListaGenerica<Estudiante> estudiantes = new ListaEnlazadaGenerica<Estudiante>();
		estudiantes.agregarFinal(e1);
		estudiantes.agregarFinal(e2);
		estudiantes.agregarFinal(e3);
		estudiantes.agregarFinal(e4);
		ListaGenerica<Integer> numeros = new ListaEnlazadaGenerica<Integer>();
		numeros.agregarFinal(5);
		//System.out.println(estudiantes.agregarTodos(numeros));
		
		estudiantes.comenzar();
		while(!estudiantes.fin())
			System.out.println(estudiantes.proximo().tusDatos());

	}

}
