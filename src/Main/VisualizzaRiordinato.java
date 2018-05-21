package Main;

import java.io.IOException;

/**
 * Classe che riordina e visualizza la lista in una nuova temporanea lista
 * @author Calchi
 *
 */

public class VisualizzaRiordinato 
{
	/**
	 * Creo e riordino la lista
	 * @param lista
	 * @throws AccessoException
	 * @throws IOException
	 */
	public static void ordineAlfabetico(Accessi lista) throws AccessoException, IOException
	{
		boolean controllo = true;
		int elementi = lista.getElementi()+1;
		Accessi listatemp = new Accessi();
		for (int i = 1; i < elementi; i++) 
		{
			listatemp.inserisciInPosizione(lista.getAccesso(i), i);
		}
		elementi--;
	///////////////////////////////////////
	do			//ordina per cognome
	{
		controllo = true;
		for (int i = 1; i < elementi; i++) 
		{
			if (listatemp.getAccesso(i).getCognome().compareTo(listatemp.getAccesso(i+1).getCognome()) > 0)
			{
				listatemp.inserisciInPosizione(listatemp.getAccesso(i+1), i);
				listatemp.eliminaInPosizione(i+2);
				controllo = false;
			}
			else
			{
			}
		}
	}while(controllo == false);			//false = controllo non passato, non in ordine
///////////////////////////////////////////////////////
	
do		//ordina per nome tenendo conto del cognome
{
	controllo = true;
	for (int i = 1; i < elementi; i++) 
	{
		if (listatemp.getAccesso(i).getCognome().compareTo(listatemp.getAccesso(i+1).getCognome()) > 0)
		{
			if (listatemp.getAccesso(i).getNome().compareTo(listatemp.getAccesso(i+1).getNome()) > 0) 
			{
				listatemp.inserisciInPosizione(listatemp.getAccesso(i+1), i);
				listatemp.eliminaInPosizione(i+2);
				controllo = false;
			}	
			else
			{
			}
		}
		else
		{
		}
	}
}while(controllo == false);			

		VisualizzaRiordinato.visualizzaListaTempRiordinata(listatemp);
	}
	/**
	 * Creo e riordino la lista
	 * @param lista
	 * @throws AccessoException
	 * @throws IOException
	 */
	
	public static void ordineCronologico(Accessi lista) throws AccessoException, IOException
	{
		boolean controllo = true;
		int elementi = lista.getElementi()+1;
		Accessi listatemp = new Accessi();
		for (int i = 1; i < elementi; i++) 
		{
			listatemp.inserisciInPosizione(lista.getAccesso(i), i);
		}
		elementi--;
	do
	{
		controllo = true;
		for (int i = 1; i < elementi; i++) 
		{
			if (listatemp.getAccesso(i).getIngresso().compareTo(listatemp.getAccesso(i+1).getIngresso()) > 0)
			{
				listatemp.inserisciInPosizione(listatemp.getAccesso(i+1), i);
				listatemp.eliminaInPosizione(i+2);
				controllo = false;
			}
			else
			{
			}
		}
	}while(controllo == false);			//false = controllo non passato, non in ordine
		
	VisualizzaRiordinato.visualizzaListaTempRiordinata(listatemp);
	}
	
	/**
	 * CVisualizzo la lista temporaneamente creata
	 * @param lista
	 * @throws AccessoException
	 * @throws IOException
	 */
	
	public static void visualizzaListaTempRiordinata(Accessi lista) throws AccessoException
	{
		for (int i = 1; i < lista.getElementi()+1; i++) 
		{
			System.out.println(lista.getAccesso(i).toString(i));
		}
		System.out.println("Visualizzazione completata");
		System.out.println("--------------------------------------------------");
		System.out.println();
	}
	
	
	
}
