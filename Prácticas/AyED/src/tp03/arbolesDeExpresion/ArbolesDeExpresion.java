package tp03.arbolesDeExpresion;
import tp03.ejercicio1.ArbolBinario;
import tp02.ejercicio3.PilaGenerica;

public class ArbolesDeExpresion {
	
	public static ArbolBinario<Character> convertirPostfija(String exp) {
		Character c = null;
		ArbolBinario<Character> result;
		PilaGenerica<ArbolBinario<Character>> p = new PilaGenerica<ArbolBinario<Character>>();
		for (int i = 0; i < exp.length(); i++) {
			c = exp.charAt(i);
			result = new ArbolBinario<Character>(c);
				//Es operador
			if ((c == '+') || (c == '-') || (c == '/') || (c == '*')) {	
				result.agregarHijoDerecho(p.desapilar());
				result.agregarHijoIzquierdo(p.desapilar ());
			}
			p.apilar(result);
		}
		return (p.desapilar());
	}
	
	public ArbolBinario<Character> convertirPrefija(StringBuffer exp) {
		Character c = exp.charAt(0);
		ArbolBinario<Character> result = new ArbolBinario<Character>(c);
					// es operador
		if ((c == '+') || (c == '-') || (c == '/') || c == '*') {
			result.agregarHijoIzquierdo(this.convertirPrefija(exp.delete(0,1)));
			result.agregarHijoDerecho(this.convertirPrefija(exp.delete(0,1)));
		}
		// es operando
		return result;
	}
	
	public Integer evaluar(ArbolBinario<Character> arbol) {
		Character c = arbol.getDato();
					// es operador
		if ((c == '+') || (c == '-') || (c == '/') || c == '*') {
			int operador_1 = evaluar(arbol.getHijoIzquierdo());
			int operador_2 = evaluar(arbol.getHijoDerecho());
			switch (c) {
				case '+': return operador_1 + operador_2;
				case '-': return operador_1 - operador_2;
				case '*': return operador_1 * operador_2;
				case '/': return operador_1 / operador_2;
			}
		}
				// es operando
		return Integer.parseInt(c.toString());
	}


	
	public static void main(String[] args) {
		ArbolBinario<Character> ab;
		String expresion = "IJK++AB*C-*";
		ab = convertirPostfija(expresion);
		ab.recorridoPorNiveles();
		
	}

}
