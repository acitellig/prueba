package excepciones;

public class BusinessExceptions extends Exception{
	
	public BusinessExceptions(String mensaje) {
        super("Problema:" + mensaje);
    }

}
