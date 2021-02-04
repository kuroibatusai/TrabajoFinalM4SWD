package com.devops.dxc.devops.model;

//Importar para llamar api externa
import org.springframework.web.client.RestTemplate;
//Fecha ( Date )
//import java.util.Calendar;
import java.util.Date;
//Formatear Date a String
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
//Jsonpath para leer el JSON de Miindcador
import com.jayway.jsonpath.JsonPath;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Util {

    private final static Logger LOGGER = Logger.getLogger("devops.subnivel.Control");

    /**
     * Método para cacular el 10% del ahorro en la AFP.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * 
     * @param ahorro
     * @param sueldo
     * @return
     */
    public static int getDxc(int ahorro, int sueldo){
        if(((ahorro*0.1)/getUf()) > 150 ){
            return (int) (150*getUf()) ;
        } else if((ahorro*0.1)<=1000000 && ahorro >=1000000){
            return (int) 1000000;
        } else if( ahorro <=1000000){
            return (int) ahorro;
        } else {
            return (int) (ahorro*0.1);
        }
    }

    /**
     * Método que retorna el valor de la UF.  Este método debe ser refactorizado por una integración a un servicio
     * que retorne la UF en tiempo real.  Por ejemplo mindicador.cl
     * @return
     */
    public static Double getUf(){
        
        //Obtener la fecha de Hoy
        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fecha_ayer = dateFormat.format(dt);  
        
        //Call MiNdicador API para UF Online
        final String uri = "https://mindicador.cl/api/uf/" + fecha_ayer;

        RestTemplate restTemplate = new RestTemplate();
        String result_json = restTemplate.getForObject(uri, String.class);
        int uf_int = JsonPath.read(result_json, "$.serie[0].valor");
        double uf = uf_int;
        return uf;
    }

    /**
    * Método que calcula el impuesto del Retiro
    * @return
    */
	public static double getImpuesto(int sueldo){
		
		if (sueldo >= 1500000 && sueldo < 2500000) {
			return sueldo * 0.08;
			} else if (sueldo >= 2500000 && sueldo < 3000000) {
				return sueldo * 0.135;
				}else if (sueldo >= 3000000 && sueldo < 4000000) {
					return sueldo * 0.23;
					}else if (sueldo >= 4000000 && sueldo < 5000000) {
						return sueldo * 0.340;
						}else if (sueldo >= 5000000 && sueldo < 6000000) {
							return sueldo * 0.35;
						}else {
							return 0;
						}
						
	}

    /**
     * Calculo Saldo Restante
     * @return
     */
    public static int saldoRestante(int ahorro, int sueldo){
        return 999;
    }

    /*
    public static Double obtenerUF()
    {   
      
        //Obtener la fecha de Hoy
        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fecha_ayer = dateFormat.format(dt);  
        
        //Call MiNdicador API para UF Online
        final String uri = "https://mindicador.cl/api/uf/" + fecha_ayer;

        RestTemplate restTemplate = new RestTemplate();
        String result_json = restTemplate.getForObject(uri, String.class);

        Double uf = JsonPath.read(result_json, "$.serie[0].valor");

        return uf;
        
        
    }
    */
    
}
