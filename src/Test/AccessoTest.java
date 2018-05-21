package Test;

import Main.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class AccessoTest { //nei getter provo i getter e il metodo che crea l'oggetto vuoto poi settandolo e riutilizzando i getter.


	@Test
	public void testAccessoIntStringStringInt() throws Exception 
	{
		Accesso accesso = new Accesso(159, "Ciao", "Bello", 134);
		assertEquals(accesso.getCodiceIdentificativo(), 159);
		assertEquals(accesso.getNome(), "Ciao");
		assertEquals(accesso.getCognome(), "Bello");
		assertEquals(accesso.getArmaANoleggio(), 134);
	}

	@Test
	public void testGetCodiceIdentificativo() throws Exception 
	{
		Accesso accesso = new Accesso();
		assertEquals(accesso.getCodiceIdentificativo(), 0);
		accesso.setCodiceIdentificativo(5);
		assertEquals(accesso.getCodiceIdentificativo(), 5);
	}

	@Test
	public void testGetNome() throws Exception 
	{
		Accesso accesso = new Accesso();
		assertEquals(accesso.getNome(), null);
		accesso.setNome("Ciao");
		assertEquals(accesso.getNome(), "Ciao");
	}

	@Test
	public void testGetCognome() throws Exception 
	{
		Accesso accesso = new Accesso();
		assertEquals(accesso.getCognome(), null);
		accesso.setCognome("Ciao");
		assertEquals(accesso.getCognome(), "Ciao");
	}

	@Test
	public void testGetIngresso() throws Exception 
	{
		LocalDateTime now = LocalDateTime.now();
		Accesso accesso = new Accesso();
		assertEquals(accesso.getIngresso(), now);
		accesso.setIngresso(now.plusSeconds(110));
		assertEquals(accesso.getIngresso(), now.plusSeconds(110));
	}

	@Test
	public void testGetUscita() throws Exception 
	{
		LocalDateTime now = LocalDateTime.now();
		Accesso accesso = new Accesso();
		assertEquals(accesso.getUscita(), null);
		accesso.setUscita(now.plusSeconds(110));
		assertEquals(accesso.getUscita(), now.plusSeconds(110));
	}

	@Test
	public void testGetArmaANoleggio() throws Exception
	{
		Accesso accesso = new Accesso();
		assertEquals(accesso.getArmaANoleggio(), 0);
		accesso.setArmaANoleggio(159);
		assertEquals(accesso.getArmaANoleggio(), 159);
	}

}
