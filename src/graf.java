

public class graf
{
//
	int matriz[][];
	int n;
	int m;
//Dependiendo de n es el numero de argumentos
	public graf(int a1, int a2, int a3, int b1, int b2, int b3, int c1, int c2, int c3)
	{
		this.n = 3;
		this.m = n;
		this.matriz = new int[n][m];
		this.matriz[0][0] = a1; this.matriz[0][1] = a2; this.matriz[0][2] = a3;
		this.matriz[1][0] = b1; this.matriz[1][1] = b2; this.matriz[1][2] = b3;
		this.matriz[2][0] = c1; this.matriz[2][1] = c2; this.matriz[2][2] = c3;
	}
//
	public int getN()
	{
		return this.n;
	}
//
	public int getM()
	{
		return this.m;
	}
//
	public void muestra()
	{
		for(int i = 0; i < getN(); i++)
		{
			for(int j = 0; j < getM(); j++)
			{
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
	}
//
	public void grado()
	{
		int contador = 0;
		for(int i = 0; i < getN(); i++) // Ciclo es para cada nodo
		{
			for(int j = 0; j < getM(); j++) // Ciclo es para recorrrer las adyasencias
			{
				if(matriz[i][j] != 0)
				{
					contador++;
				}
			}
			System.out.println("G( " + i + " )  =  " + contador );
		}
	}
// 
	public boolean dirOnoDir()
	{
		for(int i = 0; i < getN(); i++)
		{
			for(int j = 0; j < getM(); j++)
			{
				if(matriz[i][j] != matriz[j][i])
				{
					return false;
				}
			}
		}
		return true;
	}
// 
	public boolean adyacentes(int na, int nb)
	{
		if(matriz[na][nb] != 0)
		{
			return true; // Si nodoA en la fila, y nodoB en la columna, tienen un peso
						 // Existe una adyasencia
		}else{
			return false;
		}
	}
	
}
