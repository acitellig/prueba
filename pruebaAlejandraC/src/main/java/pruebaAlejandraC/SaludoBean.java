package pruebaAlejandraC;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import excepciones.BusinessExceptions;

@ManagedBean
@RequestScoped
public class SaludoBean {
	
	public SaludoBean()
	{
		
	}
	
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) throws Exception 
	{
		String[] parts;
		String part1;
		String part2;
		String aux = "";
		String result = "";
		int contador;
		boolean coin = false;

		String[] output = mensaje.split("\\n");
		List<String> mensajes = new ArrayList();

		if(mensaje.equals("") || mensaje == null)
		{
			throw new BusinessExceptions("El mensaje no puede estar vacío");
		}
		for (int i = 0; i < output.length; i++){
			
			try {				
				parts = output[i].split("\\\\");
				part1 = parts[0];
				part2 = parts[1];
				aux = part2.replaceAll("[0-9]+", "");
				aux = aux.replaceAll("[^\\w\\s]", "");
				StringTokenizer st = new StringTokenizer(aux);
				
				contador = st.countTokens();
				if(contador == Integer.parseInt(part1))
				{
					coin = true;
				}
				else
					coin=false;
				
				contador=0;
				aux = aux + "\\" + coin ;
				result = result + aux  + "<br/>";
				
			} catch (Exception e) {
				throw new BusinessExceptions("Formato inválido");
			}
					
			
		}
		this.mensaje = result.toLowerCase();
	}
	
	public String mostrar() {
		return "validacion";
	}
}
