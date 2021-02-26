package pruebaAlejandraC;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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

	public void setMensaje(String mensaje) 
	{
		String[] parts = mensaje.split("\\\\");
		String part1 = parts[0];
		String part2 = parts[1];
		String aux = "";
		String result = "";
		int contador;
		boolean coin = false;

		String[] output = mensaje.split("\\n");
		List<String> mensajes = new ArrayList();

		for (int i = 0; i < output.length; i++){
			
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
		}
		this.mensaje = result.toLowerCase();
	}
	
	public String mostrar() {
		return "validacion";
	}
}
