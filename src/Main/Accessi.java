package Main;

import java.io.IOException;
/**
 * Lista con all'interno i vari nodi
 * @author Calchi
 *
 */
//ricordiamo che la posizione 0 non esiste e che verrà sempre messo in posizione 1 
public class Accessi 
{

	private Nodo head;
	private int elementi;
	/**
	 * Creazione Lista
	 */
	public Accessi()
	{
		head=null;
		elementi=0;
	}
	/**
	 * ottenimento elementi in lista
	 * @return int elementi
	 */
	public int getElementi()
	{
		return elementi;
	}
/**
 * Setta gli elementi
 * @param int elementi
 */
	public void setElementi(int elementi)
	{
		this.elementi = elementi;
	}
	/**
	 * Creiamo un nodo
	 * @param Accesso R 
	 * @param Nodo link
	 * @return Nodo nodo
	 */
	private Nodo creaNodo(Accesso R, Nodo link)
	{
		Nodo nodo= new Nodo(R);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * Otteniamo il link di una determinata posizione
	 * @param int posizione
	 * @return Nodo posizione
	 * @throws AccessoException
	 */
	private Nodo getLinkPosizione(int posizione) throws AccessoException
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new AccessoException("Posizione non valida");
		if (elementi==0)
			throw new AccessoException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	
			n++;
		}
		
		return p;
	}
	/**
	 * Inserisco un oggetto in testa
	 * @param Accesso R
	 */
	public void inserisciInTesta (Accesso R)
	{
		
		Nodo p=creaNodo(R, head);
		head=p;
		elementi++;
	}
	/**
	 * Stampo una stringa
	 */
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	/**
	 * Inserisco l'oggetto in ultima posizione (coda)
	 * @param Accesso R
	 * @throws AccessoException
	 */
	public void inserisciInCoda(Accesso R) throws AccessoException
	{
		if(elementi==0)
		{
			inserisciInTesta(R);
			return;
		}
		
		Nodo pn=creaNodo(R, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;	
	}
	/**
	 * Inserisco un ogetto in qualsiasi posizione (utilizzando quando serve i metodi inserisciInCoda e inserisciInTesta)
	 * @param Accesso R
	 * @param int posizione
	 * @throws AccessoException
	 */
	public void inserisciInPosizione(Accesso R,int posizione) throws AccessoException
	{
		if (posizione<=1)
		{
			inserisciInTesta(R);
			return;
		}
		if (posizione>elementi)
		{
			inserisciInCoda(R);
			return;
		}
		
		Nodo pn=creaNodo(R, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;
	}
	/**
	 * Elimina il primo oggetto della lista (testa)
	 * @throws AccessoException
	 */
	public void eliminaInTesta() throws AccessoException
	{
		if (elementi==0)
			throw new AccessoException("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	/**
	 * Elimina l'ultimo oggetto
	 * @throws AccessoException
	 */
	public void eliminaInCoda() throws AccessoException
	{
		if (elementi==0)
			throw new AccessoException("Lista vuota");
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	/**
	 * Elimina l'oggetto in una specificata posizione salvandone i dati su file
	 * @param int posizione
	 * @param int tariffaAccesso
	 * @param int tariffaOraria
	 * @param int tariffaNoleggioArma
	 * @throws AccessoException
	 * @throws IOException
	 */
	public void eliminaInPosizione(int posizione, int tariffaAccesso, int tariffaOraria, int tariffaNoleggioArma) throws AccessoException, IOException
	{
		if (elementi==0)
			throw new AccessoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new AccessoException("Posizione non valida");
		//////////////////////////////////////////////
		this.getAccesso(posizione).StampaScontrinoSuFile(tariffaAccesso, tariffaOraria, tariffaNoleggioArma);		
		//////////////////////////////////////////////
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	/**
	 * Elimina in una posizione senza salvare su file
	 * @param int posizione
	 * @throws AccessoException
	 * @throws IOException
	 */
	public void eliminaInPosizione(int posizione ) throws AccessoException, IOException //questo serve solo alla classe riordinatrice
	{
		if (elementi==0)
			throw new AccessoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new AccessoException("Posizione non valida");
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	/**
	 * Stampa l'oggetto in una determinata posizione
	 * @param int posizione
	 * @return
	 * @throws AccessoException
	 */
	public String visita (int posizione) throws AccessoException
	{
		if (elementi==0)
			throw new AccessoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new AccessoException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo().toString();		
	}
	/**
	 * Si ottiene l'oggetto nella desiderata posizione
	 * @param int posizione
	 * @return Accesso Info
	 * @throws AccessoException
	 */
	public Accesso getAccesso (int posizione) throws AccessoException
	{
		if (elementi==0)
			throw new AccessoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new AccessoException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	
	
	
	
	
}