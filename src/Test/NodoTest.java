package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Main.Accesso;
import Main.Nodo;

public class NodoTest {
	
	Accesso accesso = new Accesso();

	@Test
	public void testNodo() throws Exception 
	{
		Nodo nodo = new Nodo(accesso);
		assertEquals(nodo.getInfo(), accesso);
		assertEquals(nodo.getLink(), null);
	}

	@Test
	public void testGetInfo() throws Exception 
	{
		Nodo nodo = new Nodo(accesso);
		assertEquals(nodo.getInfo(), accesso);
	}

	@Test
	public void testGetLink() throws Exception 
	{
		Nodo nodo = new Nodo(accesso);
		assertEquals(nodo.getLink(), null);
	}

}
