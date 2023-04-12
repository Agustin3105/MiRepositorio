package ar.edu.unlam.pb1.finalAgosto;
import java.util.concurrent.ThreadLocalRandom;


public class Empresa {

	private String Nombre;
	private int listaDeZonasDeCobertura[] = new int [100];
	private Contacto listaDeContactos[] = new Contacto [100];
	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	
	public String getNombreEmpresa() {
		/*
		 * Devuelve el nombre de la empresa
		 */
		
		return Nombre;
	}
	
	public boolean agregarNuevoContacto(Contacto nuevo) {
	
		/*
		 * Incorpora un nuevo contacto a la empresa
		 */
		for (int i=0; i<listaDeContactos.length; i++){
		    if(listaDeContactos[i]==null) {
		    	listaDeContactos[i]=nuevo;
		    	return true;
		    }
		}
		
		return false;
	}
	
	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican por el codigo postal)
		 */
		
		if(!elCodigoPostalEstaDentroDeLaZonaDeCobertura(codigoPostal) && String.valueOf(codigoPostal).length()==4){
			for (int i=0; i<listaDeZonasDeCobertura.length; i++){
			    if(listaDeZonasDeCobertura[i]==0){
			    	listaDeZonasDeCobertura[i]=codigoPostal;
			    	return true;
			    }
			}
		}
		
		return false;
	}	
	
	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {
		/*
		 * Determina si un c�digo postal est� dentro de la zona de cobertura
		 */
		
		for (int i=0; i<listaDeZonasDeCobertura.length; i++){
		    if(listaDeZonasDeCobertura[i]==codigoPostal){
		    	return true;
		    }
		}
		return false;
	}
	
	public Contacto buscarCandidato() {
		/*
		 * Para determinar qu� contacto el sistema debe mostrar, se debe realizar la siguiente b�squeda:
		 * 1.	El contacto NO debe ser cliente a�n.
		 * 2.	El contacto desea ser llamado o al menos no inform� lo contrario.
		 * 3.	El c�digo postal del contacto debe existir en las zonas de cobertura existente.
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el pr�ximo llamado.
		 */
		
		Contacto listaParaLlamado[] = new Contacto[100];
		Contacto contactoALlamar = null;
		int indiceAleatorio;
		
		for (int i=0; i<listaDeContactos.length; i++){
		    if(listaDeContactos[i]!=null){
		    	if(elCodigoPostalEstaDentroDeLaZonaDeCobertura(listaDeContactos[i].getCodigoPostal())) {
		    		if(!(listaDeContactos[i].esCliente()) && listaDeContactos[i].deseaSerLlamado()) {
			    		for(int j=0; j<listaParaLlamado.length; j++) {
			    			if(listaParaLlamado[j]==null) {
			    				listaParaLlamado[j]=listaDeContactos[i];
			    			}
			    		}
		    		}
		    	}
		    		
		    }
		}
		
		indiceAleatorio = numeroAleatorioEnRango(0, listaParaLlamado.length-1);
		
		contactoALlamar = listaParaLlamado[indiceAleatorio];
		
		return contactoALlamar;
	}
	
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
