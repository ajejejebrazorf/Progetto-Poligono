package Main;

import java.util.Scanner;
/**
 * Si verifica il giusto inserimento dei dati
 * @author Calchi
 *
 */
public class Controlli 
{
	/**
	 * Si verifica che l'input sia numerico
	 * @return controllo (int)
	 */
	public static int controlloInputInt()
	{
		Scanner tastiera = new Scanner(System.in);
		int controllo = 0;
		do
		{
		try 
		{
			controllo  = tastiera.nextInt();
			break;
		} 
		catch (java.util.InputMismatchException e) 
		{
			System.out.println("Inserimento sbagliato... RIPROVA");
			tastiera.nextLine();
		}	
		}while(true);
		
		return controllo;
	}
	
	
}
