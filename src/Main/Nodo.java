package Main;

/**
 * Nodo della lista
 * @author Calchi
 *
 */

public class Nodo 
{
	private Accesso info;
	private Nodo link;
	 /**
	  * Creo un nodo
	  * @param persona
	  */
	public Nodo(Accesso persona)
	{
		setInfo(persona);
		link=null;
	}
/**
 * Ottengo le informazioni (info)
 * @return Accesso info
 */
	public Accesso getInfo() 
	{
		return info;
	}
/**
 * Setto le info
 * @param info
 */
	public void setInfo(Accesso info) 
	{
		this.info = info;
	}
/**
 * Ottengo il link al nodo successivo
 * @return Nodo link
 */
	public Nodo getLink() 
	{
		return link;
	}
/**
 * Setto il parametro link
 * @param link
 */
	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}