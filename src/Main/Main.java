package Main;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Gestito tutto ciò che viene richiesto nel Main
 * @author Calchi
 *
 */

public class Main {
/**
 * Gestito tutto ciò che viene richiesto nel Main
 * @throws AccessoException
 * @throws IOException
 * @throws ClassNotFoundException
 */
	public static void main(String[] args) throws AccessoException, IOException, ClassNotFoundException 
	{
		int tariffaAccesso = 10;
		int tariffaOraria = 2;
		int tariffaNoleggioArma = 20;		
		
		Accessi Lista = new Accessi();	
		if (SaveRestore.loadProject(Lista, tariffaAccesso, tariffaNoleggioArma) == true) 
		{
			tariffaAccesso = SaveRestore.loadAccesso(Lista);
			tariffaNoleggioArma = SaveRestore.loadNoleggio(Lista);
			System.out.println("Caricamento avvenuto con successo");
			System.out.println();
			System.out.println();
		} 
		else 
		{
			System.out.println("Dati non trovati/esistenti o corrotti");
			System.out.println();
			System.out.println();
		}

		System.out.println("I dati che verranno modificati saranno permanenti."+ "\n"  +"Inoltre quando nel programma si fa riferimento al codice della persona (es: registriamo un'uscita) ci si riferisce alla sua posizione (primo numerino scritto durante la visualizzazione)");
		
		
		Scanner tastiera = new Scanner(System.in);
		int controllo = 0;
		int posizione = 0;
		do
		{
			SaveRestore.saveProject(Lista, tariffaAccesso, tariffaNoleggioArma);
			System.out.println("Voci selezionabili del Menu inserendo il numero desiderato: (in caso inserisci un altro numero il programma termina)");
			System.out.println("1)  Registra un Accesso");
			System.out.println("2)  Registra una uscita");
			System.out.println("3)  Visualizza i presenti in ordine alfabetico");
			System.out.println("4)  Visualizza i presenti in ordine cronologico (i primi entrati sono i primi visualizzati)");
			System.out.println("5)  Modifica tariffa di accesso e di noleggio");
			System.out.println("6)  Verifica se è presente una persona in base al nome e al cognome");
			
			controllo = tastiera.nextInt();

			switch (controllo) 
			{
			case 1:
				Menu.voce1(Lista);
				break;

			case 2:
				posizione = 0;
				System.out.println("Inserisci la posizione dell'oggetto di cui vuoi visualizzare l'uscita");
				posizione = Controlli.controlloInputInt();
				Menu.voce2(Lista, posizione, tariffaAccesso, tariffaOraria, tariffaNoleggioArma);
				break;
				
			case 3:
				VisualizzaRiordinato.ordineAlfabetico(Lista);
				break;
				
			case 4:
				VisualizzaRiordinato.ordineCronologico(Lista);
				break;

			case 5:
				System.out.println("Inserisci il nuovo valore della tariffa di accesso");
				tariffaAccesso = Controlli.controlloInputInt();
				System.out.println("Inserisci il nuovo valore della tassa di noleggio");
				tariffaNoleggioArma = Controlli.controlloInputInt();
				break;
				
			case 6:
				Menu.voce6(Lista);
				break;
			
				
			default: 
			System.out.println("Programma terminato");
			controllo = -1;
				break;
			}			
		}while(controllo != -1);
		
		SaveRestore.saveProject(Lista, tariffaAccesso, tariffaNoleggioArma);
		
		
	}

}
