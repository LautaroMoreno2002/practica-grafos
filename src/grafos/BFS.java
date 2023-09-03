package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	
	private static ArrayList<Integer> l;
	private static boolean[] marcados; 
	
	public static boolean esConexo(Grafo g) {
		if (g == null)
			throw new IllegalArgumentException("Se intento pasar un grafo nulo");
		if (g.vertices()==0) return true;
		return alcanzables(g, 0).size() == g.vertices();
	}

	public static Set<Integer> alcanzables(Grafo g, int origen) {
		Set<Integer> ret = new HashSet<Integer>();
		inicializar(g, origen);
		while (l.size()>0) {
			int i = l.get(0);
			marcados[i] = true;
			ret.add(i);
			agregarVecinosPendientes(g, i);
			l.remove(0);
		}
		return ret;
	}

	private static void agregarVecinosPendientes(Grafo g, int i) {
		for (int vertice : g.vecinos(i)) {
			if ((marcados[vertice] == false) && l.contains(vertice)==false)
				l.add(vertice);
		}
		
	}

	private static void inicializar(Grafo g, int origen) {
		l = new ArrayList<Integer>();
		l.add(origen);
		marcados = new boolean[g.vertices()];
	}
	
}
