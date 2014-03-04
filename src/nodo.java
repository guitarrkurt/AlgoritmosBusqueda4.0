public class nodo 
{
	int nod;
	int adyasencia;
	int peso;
	nodo sgt;
	
	// CONSTRUCTOR SIN PARAMETROS
	public nodo()
	{
		this.nod = 0;
		this.adyasencia = 0;
		this.peso = 0;
		this.sgt = null;
	};
	// SOLO NODO
	public nodo(int nod)
	{
		this.nod = nod;
		this.adyasencia = 0;
		this.peso = 0;
		this.sgt = null;
	}
	// NODO CON ADYASENCIA && PESO
	public nodo(int nod, int adyasencia, int peso)
	{
		this.nod = nod;
		this.adyasencia = adyasencia;
		this.peso = peso;
		this.sgt = null;
	}
	// GET SIGUIENTE
	public nodo getSgt()
	{
		return this.sgt;
	}
	// SET SIGUIENTE
	public void setSgt(nodo nuevo)
	{
		this.sgt = nuevo;
	}
	// GET nod
	public int getnod()
	{
		return this.nod;
	}
	// GET ADYASENCIA
	public int getAdyasencia()
	{
		return this.adyasencia;
	}
	// GET PESO
	public int getPeso()
	{
		return this.peso;
	}

}