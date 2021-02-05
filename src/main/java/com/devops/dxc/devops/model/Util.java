package com.devops.dxc.devops.model;

import java.text.SimpleDateFormat;
//Fecha ( Date )
//import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
//Importar para llamar api externa
import org.springframework.web.client.RestTemplate;

public class Util {

	private final static Logger LOGGER = Logger.getLogger("devops.subnivel.Control");

	/**
	 * Método para cacular el 10% del ahorro en la AFP. Las reglas de negocio se
	 * pueden conocer en
	 * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
	 * 
	 * @param ahorro
	 * @param sueldo
	 * @return
	 */
	public static int getDxc(int ahorro, int sueldo, Double uf) {
        double min = (35 * uf);
		if (((ahorro * 0.1) / uf) > 150) {
			return (int) (150 * uf);
		} else if ((ahorro * 0.1) <= min && ahorro >= min) {
			return (int) min;
		} else if (ahorro <= min) {
			return (int) ahorro;
		} else {
			return (int) (ahorro * 0.1);
		}
	}

	/**
	 * Método que retorna el valor de la UF. Este método debe ser refactorizado por
	 * una integración a un servicio que retorne la UF en tiempo real. Por ejemplo
	 * mindicador.cl
	 * 
	 * @return
	 */
	public static Double getUf() {

		LOGGER.log(Level.INFO, "---- CALCULANDO LA UF DINAMICA ----");

		// Obtener la fecha de Hoy
		Date dt = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String fecha_ayer = dateFormat.format(dt);

		// Call MiNdicador API para UF Online
		final String uri = "https://mindicador.cl/api/uf/" + fecha_ayer;

		RestTemplate restTemplate = new RestTemplate();
		String result_json = restTemplate.getForObject(uri, String.class);
		LOGGER.log(Level.INFO, result_json);
		JSONObject json = new JSONObject(result_json);
		double uf = json.getJSONArray("serie").getJSONObject(0).getDouble("valor");
		return uf;
	}

	/**
	 * Método que calcula el impuesto del Retiro
	 * 
	 * @return
	 */
	public static double getImpuesto(int sueldo, int retiro) {
		//https://www.t13.cl/noticia/politica/segundo-retiro-del-10-calcula-cuanto-impuesto-deberias-pagar-segun-sueldo-12-12-2020
		//aprox 1.500.000 y 2.500.000
		if (sueldo*12 >= 17864280 && sueldo*12 < 29773800) {
			return retiro * 0.08;
		//aprox 2.500.000 y 3.500.000
		} else if (sueldo*12 >= 29773800 && sueldo*12 < 41600000) {
			return retiro * 0.135;
		//aprox 3.500.000 y 4.500.000
		} else if (sueldo*12 >= 41600000 && sueldo*12 < 53500000) {
			return retiro * 0.23;
		//aprox 4.500.000 y 6.000.000
		} else if (sueldo*12 >= 53500000 && sueldo*12 < 71400000) {
			return retiro * 0.340;
		//aprox 6.000.000
		} else if (sueldo*12 >= 71400000) {
			return retiro * 0.35;
		}
		return 0;
	}

}
