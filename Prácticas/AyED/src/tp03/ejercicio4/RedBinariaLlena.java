package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	private ArbolBinario<Integer> ab;
	
	public RedBinariaLlena() {
		this.ab = new ArbolBinario<Integer>(1);
	}


	public ArbolBinario<Integer> getAb() {
		return ab;
	}

	public int retardoReenvio() {
		int max=0;
		int act=0;
		max = calcular(act,max,this.ab);
		System.out.println("actual="+ act);
		return max;
	}
	
	private int calcular(int act,int max, ArbolBinario<Integer> ab) {
		act += ab.getDato();
		if(!ab.esHoja()) {
			if(ab.tieneHijoIzquierdo())
				max = calcular(act,max,ab.getHijoIzquierdo());
			if(ab.tieneHijoDerecho())
				max = calcular(act,max,ab.getHijoDerecho());
		}else {
			if(act>max)
				max = act;
		}
		//System.out.println("actual="+ act);
		return max;
	}
	
	public static void main(String[] args) {
		RedBinariaLlena rbl = new RedBinariaLlena();
		ArbolBinario<Integer> n2 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> n3 = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> n7 = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> n15 = new ArbolBinario<Integer>(15);
		ArbolBinario<Integer> n4 = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> n9 = new ArbolBinario<Integer>(9);
		
		n2.agregarHijoIzquierdo(n7);
		n2.agregarHijoDerecho(n15);
		n3.agregarHijoIzquierdo(n4);
		n3.agregarHijoDerecho(n9);
		
		rbl.getAb().agregarHijoIzquierdo(n2);
		rbl.getAb().agregarHijoDerecho(n3);
		
		System.out.println("El tiempo de retorno máximo es: "+rbl.retardoReenvio());
	}
}
