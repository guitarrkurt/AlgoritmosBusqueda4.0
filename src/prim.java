
public class prim 
{
	int n;
	int m;
	String direcGrafo;
	leeGrafoTexto lee;
	int grafo[][];
	//
	int arbol[][];
	colaPriori colp;
	nodo s;
	//
	prim(String direcGrafo, int n, int m)
	{
		this.n = n; this.m = m;
		//this.direcGrafo = "/Users/mac/Desktop/leer.txt";
		this.direcGrafo = direcGrafo;
		this.grafo = lee.leelo(direcGrafo, n, m);
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				arbol[i][j] = 0;
			}
		}
		//
	//	colp.enqueque(grafo[0][0], getAdyasencia(), getPeso());
	}
	
}
