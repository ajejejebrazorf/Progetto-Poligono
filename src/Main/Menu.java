package Main;

import java.io.IOException;
import java.util.Scanner;

/**Menu che gestisce le voci (appunto del menu)
 * 
 * @author Calchi
 *
 */
public class Menu 
{
	/**
	 * Aggiungo l'accesso alla lista
	 * @param Accessi lista
	 * @throws AccessoException
	 */
	public static void voce1(Accessi lista) throws AccessoException 		//aggiugni alla lista
	{
		int temp;
		Scanner tastiera = new Scanner(System.in);
		Accesso Accesso = new Accesso();
		System.out.println("Inserisci il tuo nome");
		Accesso.setNome(tastiera.nextLine());
		System.out.println("Inserisci il tuo cognome");
		Accesso.setCognome(tastiera.nextLine());
		System.out.println("Inserisci 0 se non hai noleggiato e un qualsiasi altro numero se hai noleggiato l'attrezzatura");
		temp = Controlli.controlloInputInt();
		Accesso.setArmaANoleggio(temp);
		System.out.println("Inserisci il tuo codice identificativo");
		temp = Controlli.controlloInputInt();
		Accesso.setCodiceIdentificativo(temp);
		
		lista.inserisciInPosizione(Accesso, lista.getElementi()+1);
		//--------------------------------------------------
	
		System.out.println("Inserimento avvenuto correttamente");
		System.out.println();
	}
/**
 * Registro l'uscita dalla lista
 * @param Accessi lista
 * @param int posizione
 * @param int tariffaAccesso
 * @param int tariffaOraria
 * @param int tariffaNoleggioArma
 * @throws IOException
 */
	public static void voce2(Accessi lista, int posizione, int tariffaAccesso, int tariffaOraria, int tariffaNoleggioArma) throws IOException 		//elimina elemento dalla lista
	{
		try 
		{
			if (lista.getAccesso(posizione).getArmaANoleggio() != 0) 
			{
				lista.eliminaInPosizione(posizione, tariffaAccesso, tariffaOraria, tariffaNoleggioArma);
			}
			else
			{
				lista.eliminaInPosizione(posizione, tariffaAccesso, tariffaOraria, 0);
			}
			
		} 
		catch (AccessoException e)
		{
			System.out.println("Posizione non valida, riprova da capo");
		}
	}
	
	/**
	 * Ricerco in base a nome e cognome
	 * @param Accessi lista
	 * @throws AccessoException
	 */
	public static void voce6(Accessi lista) throws AccessoException 		//Ricerca in base a nome e cognome
	{
		Scanner tastiera = new Scanner(System.in);
		String nome = null; 
		String cognome = null;
		
		System.out.println("Inserisci il nome della persona che desideri cercare");
		nome = tastiera.nextLine();
		System.out.println("Inserisci il cognome della persona che desideri cercare");
		cognome = tastiera.nextLine();
		
		boolean controllo = false;
		for (int i = 1; i < lista.getElementi()+1; i++) 
		{
			if (lista.getAccesso(i).getNome().compareTo(nome) == 0 && lista.getAccesso(i).getCognome().compareTo(cognome) == 0) 
			{
				System.out.println("Il suddetto e i suoi dati sono stati trovati, sono elencati di seguito:");
				System.out.println(lista.getAccesso(i).toString() + "\n");
				controllo = true;
			}
		}
		if (controllo == false) 
		{
			System.out.println("Mi spiace ma sembra che alcuni dati siano errati, o non è stato trovato alcun soggetto corrispondente ai requisiti");
		}
		System.out.println("\n" + "\n");
	}
	

}
