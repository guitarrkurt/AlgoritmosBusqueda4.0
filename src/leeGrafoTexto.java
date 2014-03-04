import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class leeGrafoTexto
{
	int[][] leelo(String texto, int n, int m)
	{
		int columna = 0, numero = 0, fila = 0, i = 0, j = 0;
		String concatena = "";
		int[][] array = new int[n][m];
		
		for( i = 0; i < n; i++) // Imprime lo leido
        {
        	for( j = 0; j < m; j++)
        	{
        		//System.out.print(array[i][j] + " ");
        		array[i][j] = 0;
        	}
        	//System.out.println("");
        }

	    try{
	        //FileInputStream fstream = new FileInputStream("/Users/mac/Desktop/pruebaLee.txt");
	    	FileInputStream fstream = new FileInputStream(texto);
	        DataInputStream entrada = new DataInputStream(fstream);
	        BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));

	        
	        while ( true ) 
	        {
	        	numero = buffer.read();
	        	if(numero == -1)
	        	{
	        		break;
	        	}
	        	if(numero == ',')
	        	{
	        		columna++;
	        	}
	        	if(numero == '\n')
	        	{
	        		fila++;
	        		columna = 0;
	        		concatena = "";
	        	}
	            if(numero > 47 && numero < 58)
	            {
	            		concatena += String.valueOf(numero - 48);	
	            }
	            if(numero == ' ')
	            {
	            	array[fila][columna -1] = Integer.parseInt(concatena);
	            	concatena = "";
	            }
	        }        
	        entrada.close();
		    return array;	
        		
	    	}catch (Exception e){ //Catch de excepciones
	    		System.err.println("Ocurrio un error: " + e.getMessage());
	    	}
	    return array;
	}

	
}
