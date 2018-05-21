package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Main.Accesso;
import Main.Nodo;

public class NodoTest {
	
	Accesso accesso = new Accesso();
	Accesso accesso2 = new Accesso();

	@Test
	public void testNodo() throws Exception 
	{
		Nodo nodo = new Nodo(accesso);
		Nodo nodo2 = new Nodo(accesso);		
		
		assertEquals(nodo.getInfo(), accesso);
		assertEquals(nodo.getLink(), null);
		nodo.setInfo(accesso2);
		nodo.setLink(nodo2);
		assertEquals(nodo.getInfo(), accesso2);
		assertEquals(nodo.getLink(), nodo2);
	}

	@Test
	public void testGetInfo() throws Exception 
	{
		Nodo nodo = new Nodo(accesso);
		assertEquals(nodo.getInfo(), accesso);
		nodo.setInfo(accesso2);
		assertEquals(nodo.getInfo(), accesso2);
	}

	@Test
	public void testGetLink() throws Exception 
	{
		Nodo nodo = new Nodo(accesso);
		Nodo nodo2 = new Nodo(accesso);
		assertEquals(nodo.getLink(), null);
		nodo.setLink(nodo2);
		assertEquals(nodo.getLink(), nodo2);
	}

}
