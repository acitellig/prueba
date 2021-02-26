package pruebaAlejandraC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excepciones.BusinessExceptions;

public class SaludoBeanTest {

	private SaludoBean saludoBean;
	
	@Before
	public void setUp() throws Exception {
		saludoBean = new SaludoBean();
		saludoBean.setMensaje("3\\the force is strong in this one");
	}
	
	@Test
	public void getMensaje() throws Exception
	{
		saludoBean = new SaludoBean();
		saludoBean.setMensaje("3\\the force is strong in this one");
		assertNotNull(saludoBean.getMensaje());
	}
	
	@Test(expected = BusinessExceptions.class)
	public void getMensajeException() throws Exception
	{
		saludoBean = new SaludoBean();
		saludoBean.setMensaje("3the force is strong in this one");
		assertNotNull(saludoBean.getMensaje());
	}
	
	@Test(expected = BusinessExceptions.class)
	public void getMensajeVacio() throws Exception
	{
		saludoBean = new SaludoBean();
		saludoBean.setMensaje("");
		assertNotNull(saludoBean.getMensaje());
	}


}
