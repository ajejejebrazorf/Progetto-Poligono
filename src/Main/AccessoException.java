package Main;
/**
 * Classe dell'eccezioni
 * @author Calchi
 *
 */
public class AccessoException extends Exception 
{
	private String messaggio;
	
	public AccessoException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
