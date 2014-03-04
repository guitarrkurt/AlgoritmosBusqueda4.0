
public class prim 
{
	// Elementos
	int n;
	int m;
	String direcGrafo;
	leeGrafoTexto lee;
	int grafo[][];
	colaPriori arbol;
	colaPriori colp;
	//
	prim(String direcGrafo, int n, int m)
	{
		this.n = n; this.m = m;
		//this.direcGrafo = "/Users/mac/Desktop/leer.txt";
		this.direcGrafo = direcGrafo;
		this.grafo = lee.leelo(direcGrafo, n, m);
		//
	}
	// REGRESA LOS ADYASENTES DE UN NODO X
	public int[] adyasentes(int x)
	{
		int cont = 0, i = 0;
			for(int j = 0; j < this.m; j++)
			{
				if(grafo[x][j] != 0)
				{
					cont++;
				}
			}
			
			int adya[] = new int[cont]; // Crea el arreglo de adyasentes
			
			for(int j = 0; j < this.m; j++)
			{
				if(grafo[x][j] != 0)
				{
					adya[i] = grafo[x][j];
					i++;
				}
			}
		return adya;
	}
	//
	public int[] noEstanArbol(int adya[])
	{
		int cont = 0, k = 0;
		for(int i = 0; i < adya.length; i++)
		{
			if(!(arbol.esta(adya[i])))
			{
				cont++;
			}
		}
		int noEstaA[] = new int[cont];
		for(int j = 0; j < adya.length; j++)
		{
			if(!(arbol.esta(adya[j])))
			{
				noEstaA[k] = adya[j];
				k++;
			}
		}
		return noEstaA;
	}
	//
	public void enAccion(nodo inicialS)
	{
		arbol.enqueque(inicialS.getnod()); // Metemos el primer nodoS en el arbol
		int adyaS[] = adyasentes(inicialS.getnod()); // Obtenemos los adyasentes al nodoS
		int adyaSnoEstan[] = noEstanArbol(adyaS); // Obtenemos los adyasentes que no esten en el arbol
		
		if(adyaSnoEstan.length > 0) // Si hay almenos un adyasente que no este en el arbol
		{
			for(int i = 0; i < adyaSnoEstan.length; i++) // Metemos a la cola priorizada
			{
				colp.enqueque(inicialS.getnod(), adyaSnoEstan[i], grafo[inicialS.getnod()][adyaSnoEstan[i]]);
			}
		}
		
		colp.dequeue(); // Sacamos un vertice de la cola priorizada /*Aqui va un ciclo*/
		
	}
}
