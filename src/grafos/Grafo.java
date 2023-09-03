package grafos;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
	private boolean[][] MA; // matriz de adyacencia
	
	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices) {
		MA = new boolean[vertices][vertices];
	}
	
	// Agregado de aristas
	public void agregarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		MA[i][j] = true;
		MA[j][i] = true;
	}

	// Agregado de aristas
	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		MA[i][j] = false;
		MA[j][i] = false;
	}
	
	// Vecinos de un vertice
	public Set<Integer> vecinos(int i){
		verificarVertice(i);
		Set<Integer> ret = new HashSet<Integer>();
		for (int j = 0; j < MA.length; j++) if (i!=j){
			if (existeArista(i, j)) ret.add(j);
		}
		return ret;
	}
		
	private void verificarDistintos(int i, int j) {
		if (j == i) throw new IllegalArgumentException("No se permiten loops: ("+i+", "+j+")");
	}
	
	// Informa si existe la arita especificada
	public boolean existeArista(int i,int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		return MA[i][j];
	}

	private void verificarVertice(int i) {
		if (i < 0) throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		if (i >= MA.length) throw new IllegalArgumentException("Los vértices deben estar entre 0 y " + (MA.length-1));
	}

	public int vertices() {
		return MA.length;
	}
	
	
	
}
