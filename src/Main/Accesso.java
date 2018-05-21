package Main;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
/**
 * Classe relativa al singolo Accesso
 * @author Calchi
 *
 */
public class Accesso implements Serializable 
{
	int codiceIdentificativo;
	String nome;
	String cognome;
	LocalDateTime ingresso;
	LocalDateTime uscita;
	int armaANoleggio;
	
	/**
	 * Creo un accesso vuoto
	 */
	public Accesso() 
	{
		this.ingresso = LocalDateTime.now();
	}
	/**
	 * Creo un accesso con parametri
	 * @param intcodiceIdentificativo
	 * @param String nome
	 * @param String cognome
	 * @param int armaANoleggio
	 */
	public Accesso(int codiceIdentificativo, String nome, String cognome, int armaANoleggio) 
	{
		this.codiceIdentificativo = codiceIdentificativo;
		this.nome = nome;
		this.cognome = cognome;
		this.ingresso = LocalDateTime.now();
		this.armaANoleggio = armaANoleggio;
	}
	/**
	 * Si ottiene il codiceIdentificativo
	 * @return int codiceIdentificativo
	 */
	public int getCodiceIdentificativo() 
	{
		return codiceIdentificativo;
	}
/**
 * Si setta il codiceIdentificativo
 * @param codiceIdentificativo
 */
	public void setCodiceIdentificativo(int codiceIdentificativo) 
	{
		this.codiceIdentificativo = codiceIdentificativo;
	}
/**
 * Si ottiene il nome
 * @return String nome
 */
	public String getNome() 
	{
		return nome;
	}
/**
 * Si setta il nome
 * @param String nome
 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
/**
 * Si ottiene il cognome
 * @return String cognome
 */
	public String getCognome() 
	{
		return cognome;
	}
/**
 * Si setta il cognome
 * @param String cognome
 */
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
/**
 * Si ottengono le informazioni relative all'ora di ingresso
 * @return LocalDateTime ingresso
 */
	public LocalDateTime getIngresso()
	{
		return ingresso;
	}
/**
 * Si setta tutto ciò che riguardo l'ingresso
 * @param LocalDateTime ingresso
 */
	public void setIngresso(LocalDateTime ingresso) 
	{
		this.ingresso = ingresso;
	}
	/**
	 * Si ottengono le informazioni relative all'ora di uscita
	 * @return LocalDateTime uscita
	 */
	public LocalDateTime getUscita() 
	{
		return uscita;
	}
	/**
	 * Si setta tutto ciò che riguardo l'uscita
	 * @param LocalDateTime uscita
	 */
	public void setUscita(LocalDateTime uscita) 
	{
		this.uscita = uscita;
	}
/**
 * Ottengo le informazioni relative al noleggio
 * @return int armaANoleggio
 */
	public int getArmaANoleggio() 
	{
		return armaANoleggio;
	}
/**
 * Setto le informazioni relative al noleggio
 * @param int armaANoleggio
 */
	public void setArmaANoleggio(int armaANoleggio) 
	{
		this.armaANoleggio = armaANoleggio;
	}

	/**
	 * Stamp sul file tutto ciò che serve
	 * @param int tariffaAccesso
	 * @param int tariffaOraria
	 * @param int tariffaNoleggioArma
	 * @throws IOException
	 */
	public void StampaScontrinoSuFile( int tariffaAccesso,  int tariffaOraria, int tariffaNoleggioArma) throws IOException //qui se si mette SECONDS al posto di HOURS si può verificare il corretto funzionamento del calcolo in base alle ore
	{		
		PrintWriter file_output =new PrintWriter ( new BufferedWriter (new FileWriter ("Scontrini .txt", true )));
		uscita = LocalDateTime.now();
		long differenzaInOre = ChronoUnit.HOURS.between(this.ingresso, uscita);
		file_output.print("Nome: " + this.nome + " " + "Cognome: " + this.cognome + "\n");
		file_output.print(ingresso + " ");
		file_output.println(uscita +  " ");
		file_output.println("Il costo totale è di: " + tariffaAccesso + "€ " + tariffaOraria*differenzaInOre + "€ " + tariffaNoleggioArma + "€ ");
		file_output.println("--------------------------------------------------" + "\n"); System.out.println();		//spazio per separare la lista degli elementi con annessi 50 puntini di separazione
		file_output . close ();
	}
/**
 * Stampo a schermo i dati rigurdanti l'ora di entrata dell'Accesso
 * @return
 */
	public String DataAndingressoToSting()
	{
		String Stringa = "La data di ingresso è: " + ingresso.getYear() + " " + ingresso.getMonth() + " " + ingresso.getDayOfMonth() + "  " + "  " + "e l'ora di ingresso è: " + ingresso.getHour() + ":" + ingresso.getMinute();
		return Stringa;
	}
	/**
	 * Stampo a schermo i dati rigurdanti l'ora di uscita dell'Accesso
	 * @return
	 */

	public String DataAnduscitaToSting()
	{
		try 
		{
			String Stringa = "La data di uscita è: " + uscita.getYear() + " " + uscita.getMonth() + " " + uscita.getDayOfMonth() + "  " + "  " + "e l'ora di uscita è: " + uscita.getHour() + ":" + uscita.getMinute();
			return Stringa;
		} 
		catch (NullPointerException e) 
		{
			return "Data di uscita non ancora inserita";
		}
	}

	/**
	 * Stampo a schermo i dati dell'Accesso
	 * @return
	 */
	public String toString(int posizione) 
	{
		return posizione + ") Accesso [codiceIdentificativo=" + codiceIdentificativo + ", nome=" + nome + ", cognome=" + cognome + "  " + this.DataAndingressoToSting() + "   " + this.DataAnduscitaToSting() + ", armaANoleggio=" + armaANoleggio + "]";
	}
	/**
	 * Stampo a schermo i dati dell'Accesso
	 * @return
	 */
	public String toString() 
	{
		return "Accesso [codiceIdentificativo=" + codiceIdentificativo + ", nome=" + nome + ", cognome=" + cognome + "  " + this.DataAndingressoToSting() + "   " + this.DataAnduscitaToSting() + ", armaANoleggio=" + armaANoleggio + "]";
	}
		
		
		
	
	
	
	
	
	
}
