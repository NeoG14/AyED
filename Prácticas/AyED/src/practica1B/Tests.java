package practica1B;

public class Tests {

	public static void main(String[] args) {
		Estudiante e1 = new Estudiante("Juan","Carlos","1A","juancarlos@gmail.com","picen 105");
		Estudiante e2 = new Estudiante("Tomas","Bus","3B","tomasbuss@gmail.com","Av libertad 447");
		Estudiante[] estudiantes = new Estudiante[2];
		estudiantes[0]=e1; estudiantes[1]=e2;
		
		Profesor p1 = new Profesor("Pablo","Thomas","pablitolos@gmail.com","FOD","UNLP");
		Profesor p2 = new Profesor("Rodolfo","Berone","rodolfito@gmail.com","FOD","UNLP");
		Profesor p3 = new Profesor("Victoria","rofelia","vickyr@gmail.com","Taller","UNLP");
		Profesor[] profesores = new Profesor[3];
		profesores[0]=p1; profesores[1]=p2;profesores[2]=p3;
		
		System.out.println("Estudiantes");
		for (Estudiante est:estudiantes)
			System.out.println(est.tusDatos());
		
		System.out.println("Profesores");
		for(Profesor profe:profesores)
			System.out.println(profe.tusDatos());

	}

}
