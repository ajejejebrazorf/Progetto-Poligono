package Main;

import java.io.*;

/**
 * Salva e carica il rpogetto
 * @author Calchi
 *
 */

public class SaveRestore 
{
	/**
	 * Salvo il rpogetto
	 * @param lista
	 * @param tariffaAccesso
	 * @param tariffaNoleggioArma
	 * @throws IOException
	 * @throws AccessoException
	 */
	public static void saveProject(Accessi lista, int tariffaAccesso, int tariffaNoleggioArma) throws IOException, AccessoException			//non mi interessa gestire le eccezioni in quanto genero sempre tutto da 0
	{
		ObjectOutputStream out =new ObjectOutputStream ( new BufferedOutputStream (new FileOutputStream ("Data.dat" )));
		int elementi = lista.getElementi(); 
		out.writeObject(tariffaAccesso);
		out.writeObject(tariffaNoleggioArma);
		out.writeObject(elementi);		
		elementi++;
		for (int i = 1; i < elementi; i++)
		{
			out.writeObject(lista.getAccesso(i));			
		}
		out.close();
	}
	/**
	 * Carico il singolo dato --> tariffaAccesso
	 * @param lista
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static int loadAccesso(Accessi lista) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		int accesso;
		ObjectInputStream in =new ObjectInputStream ( new BufferedInputStream (new FileInputStream ("Data.dat" )));
		accesso = (int) in.readObject();
		return accesso;	
	}
	/**
	 * Carico il singolo dato --> tariffaNoleggioArma
	 * @param lista
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static int loadNoleggio(Accessi lista) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		int noleggio;
		ObjectInputStream in =new ObjectInputStream ( new BufferedInputStream (new FileInputStream ("Data.dat" )));
		noleggio = (int) in.readObject();
		noleggio = (int) in.readObject();
		return noleggio;	
	}
	/**
	 * Carico le altre informazioni relative al progetto
	 * @param lista
	 * @param tariffaAccesso
	 * @param tariffaNoleggioArma
	 * @return
	 * @throws AccessoException
	 */
	public static boolean loadProject(Accessi lista, int tariffaAccesso, int tariffaNoleggioArma) throws AccessoException			//qua lo gestisco in quanto mi serve sapere se posso caricare o no i dati  
	{
		try
		{
			int elementi = 0;
			ObjectInputStream in =new ObjectInputStream ( new BufferedInputStream (new FileInputStream ("Data.dat" )));
			tariffaAccesso = (int) in.readObject();
			tariffaNoleggioArma =(int) in.readObject();
			elementi = (int) in.readObject();
			elementi++;
			Accesso rTemp = new Accesso();
			for (int i = 1; i < elementi; i++) 
			{
				rTemp = (Accesso) in.readObject();
				lista.inserisciInPosizione(rTemp, i);
			}
			in.close();
			return true;
		}
		catch (FileNotFoundException e)			//niente file
		{
			return false;
		}
		catch (IOException e)			//problemi di collegamento (fisici)
		{
			return false;
		}	
		catch (ClassNotFoundException e)			//problemi di corruzione
		{
			return false;
		}
	}
	
	
	
	
}
