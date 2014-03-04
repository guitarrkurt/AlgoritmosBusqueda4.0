
public class colaPriori 
{
nodo inicio;
	
	public colaPriori()
	{
		this.inicio = new nodo();
	}
//	
	public void enqueque(int nod)
	{
		nodo aux = this.inicio;
		nodo nuevo = new nodo(nod);
		
		if(aux.getSgt() != null)
		{
			while(aux.getSgt() != null)
			{
				aux = aux.getSgt();
			}
			aux.setSgt(nuevo);	
		}else{
			aux.setSgt(nuevo);
		}	
	}
// Encolar con un nod y con un PESO	
	public void enqueque(int nod,int adyasencia, int peso)
	{
		nodo aux = this.inicio;
		nodo nuevo = new nodo(nod, adyasencia, peso);
		
		if(aux.getSgt() != null)
		{
			while(aux.getSgt() != null)
			{
				aux = aux.getSgt();
			}
			aux.setSgt(nuevo);	
		}else{
			aux.setSgt(nuevo);
		}	
	}
//
	public void ordena()
	{
		nodo auxContador = this.inicio; nodo aux0 = this.inicio;
		nodo aux1 = this.inicio.getSgt(); nodo aux2 = aux1.getSgt();
		nodo aux3; // Auxiliar que contendra el nodo que se movera una posicion atraz
		int entero = 0, contador = 0;
		//	
		while( auxContador.getSgt() != null ) // Regresa el numero de veces que se hara la burburja
		{
			contador++;
			auxContador = auxContador.getSgt();
		}
		//
		if( contador > 0) // Si fu� '0' no hay argumentos que ordenar
		{
			while(contador > 0)
			{
				aux0 = this.inicio; aux1 = this.inicio.getSgt();
				aux2 = aux1.getSgt(); 
				while(aux2 != null) // Recorre la cola priorizada
				{
					if(aux1.getPeso() > aux2.getPeso())
					{
						aux3 = aux2;
						aux3.setSgt(aux1);
						aux1.setSgt(aux2.getSgt());
						aux0.setSgt(aux3);
					}
					aux2 = aux2.getSgt();
					aux1 = aux1.getSgt();
					aux0 = aux0.getSgt();
				}	
				contador--;
			}
		}
	}
//
	public int dequeue()
	{
		nodo aux = inicio;
		nodo aux2 = aux.getSgt();
		int nod;
		
		if(aux2.getSgt() != null)
		{
			nod = aux2.getnod();
			inicio = aux2.getSgt();
			return nod;
		}else{
			nod = aux2.getnod();
			aux.setSgt(null);
			return nod;
		}
	}
//
	public boolean isEmpty()
	{	
		nodo aux = inicio;
		if(aux.getSgt() == null)
		{
			return true;
		}else{
			return false;
		}
	}
//
	public void muestra()
	{
		nodo aux = inicio;
		while(aux != null)
		{
			System.out.print(aux.getnod() + " ");
			aux = aux.getSgt();
		}
		System.out.println("");
	}
//
	
}
