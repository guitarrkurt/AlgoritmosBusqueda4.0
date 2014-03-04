
public class prim 
{
	// ELEMENTOS
	int n;
	int m;
	String direcGrafo;
	leeGrafoTexto lee;
	int grafo[][];
	colaPriori arbol;
	colaPriori colp;
	colaPriori camino;
	// CONSTRUCTOR
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
			if(cont == 0)
			{
				int adya[] = new int[0];
				adya[0] = 0;
				return adya;
			}else{
				int adya[] = new int[cont]; // Crea el arreglo de adyasentes
			
				for(int j = 0; j < this.m; j++)
				{
					if(grafo[x][j] != 0)
					{
						//adya[i] = grafo[x][j];
						adya[i] = j;
						i++;
					}
				}
				return adya;
			}
	}
	//
	public int[] noEstanArbol(int adya[])
	{
		int cont = 0, k = 0;
		if(adya.length < 2)
		{
			return adya;
		}else{
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
	}
	//
	/*Usamos Una cola normal S (que ira guardando los caminos), una cola priorizada, y un arbol de expansion minimo*/
	public void enAccion(nodo inicialS)
	{
			nodo extraidoS, Snodo; int adyaS[], pesoAdya = 0, adyaSnoEstan[], nodoAdya;
		
			//camino.enqueque(inicialS); // Metemos al nodo Inicial a la cola caminoS, que sera la que ira guardando el camino
			arbol.enqueque(inicialS.getnod()); // Metemos el primer nodoS en el arbol
			adyaS = adyasentes(inicialS.getnod()); // Obtenemos los adyasentes al nodoS
			adyaSnoEstan = noEstanArbol(adyaS); // Obtenemos los adyasentes que no esten en el arbol
			if(adyaSnoEstan.length > 0) // Si hay almenos un adyasente que no este en el arbol
			{
				for(int i = 0; i < adyaSnoEstan.length; i++) // Metemos a la cola priorizada
				{
					colp.enqueque(inicialS.getnod(), adyaSnoEstan[i], grafo[inicialS.getnod()][adyaSnoEstan[i]]); // Metemos a la cola priorizada, los nodos adyasentes a S, que no estan en el arbol
				}
			}
			colp.ordena(); // Ordenamos la cola, respecto al PESO, para volverla cola priorizada
			//--------------------------------------------------------------------------------------
			while(!colp.isEmpty())
			{
				if(arbol.tam() != this.n) // N es el largo, es decir el numero de nodos, es el mismo numero que esta en el arbol -> ya se visitaron todos los nodos, por lo tanto ya puede acabar
				{
					Snodo = colp.dequeueNodo(); // Sacamos un vertice de la cola priorizada
			
					//camino.enqueque(Snodo.getAdyasencia()); // camino.enqueque(new nodo(extraidoS));
					arbol.enqueque(Snodo.getAdyasencia(), Snodo.adyasencia, Snodo.getPeso());
					adyaS = adyasentes(Snodo.getAdyasencia());
					adyaSnoEstan = noEstanArbol(adyaS); // Regresa un arreglo con los que no estan en el arbol
			
					if(adyaSnoEstan.length > 1) // Si hay almenos un adyasente que no este en el arbol
					{
						for(int i = 0; i < adyaSnoEstan.length; i++) // Metemos a la cola priorizada
						{
							pesoAdya = this.grafo[Snodo.getnod()][adyaSnoEstan[i]];
							nodoAdya = adyaSnoEstan[i];
							colp.enqueque(Snodo.getAdyasencia(), nodoAdya, pesoAdya); // Metemos a la cola priorizada, los nodos adyasentes a S, que no estan en el arbol
							
						}
					}
					colp.ordena();
				}else{
					
					break;
				}
			}
			// En este punto todos los datos estan guardados en colap
		}
	
	
	
	
	
	
	
	
	
	} // Llave del fin de la clase
