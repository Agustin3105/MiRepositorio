package ar.edu.unlam.pb1.finalAgosto;

public class Contacto {
	
	String nombreCompleto, Mail, Dirección, Localidad;
	int Celular, codigoPostal;
	boolean esCliente, deseaSerLlamado;
	Provincia Provincia;
	Llamada historialDeLlamadas[]=new Llamada[100];
	
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * �	Nombre y Apellido: No se aceptan n�meros.
	 * �	Celular: Compuesto del c�digo de pa�s + c�digo de �rea + n�mero de celular.
	 * �	E-Mail: Debe contener al menos el s�mbolo �@� y el caracter �.�.
	 * �	Direcci�n: Valor alfanum�rico.
	 * �	C�digo Postal: Valor num�rico.
	 * �	Localidad: Valor alfanum�rico.
	 * �	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 * �	Es cliente (Si o No): Inicialmente se carga en �No�.
	 * �	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en �Si�.
	 */
	
	public boolean esEmailValido(String eMail) {
		/*
		 * Eval�a si un String determinado puede ser almacenado como E-MAIL.
		 */
		
		if(eMail.contains(String.valueOf("@")) & eMail.contains(String.valueOf("."))){
			return true;
		}
		else return false;
		
	}
	
	public boolean esCliente() {
		return esCliente;
	}
	
	public boolean deseaSerLlamado() {
		return deseaSerLlamado;
	}
	
	public int getCodigoPostal() {
		return codigoPostal;
	}
	
	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
		
		for (int i=0; i<historialDeLlamadas.length; i++){
		    if(historialDeLlamadas[i]==null) {
		    	historialDeLlamadas[i]=nueva;
		    	return true;
		    }
		}
		
		return false;
	}
	
	public String toString() {
		/*
		 * Muestra los datos de un contacto, entre los que se debe incluir el registro de las llamadas realizadas.
		 */
		
		return "";
	}
	
}
