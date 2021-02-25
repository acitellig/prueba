package pruebaAlejandraC;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SaludoBean {
	
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
