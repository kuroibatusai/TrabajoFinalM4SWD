package com.devops.dxc.devops.model;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dxc implements Serializable{
	
	private final static Logger LOGGER = Logger.getLogger("devops.subnivel.Control");

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988002029080131424L;
	
	private int dxc; //Retiro 10%
	private int saldo;
	private double impuesto;
	private int sueldo;
	private int ahorro;
	private double uf;
	private String fechaUf;

	public Dxc(int ahorro, int sueldo, String fechaUf){
		this.setAhorro(ahorro);
		this.setSueldo(sueldo);
		this.setFechaUf(fechaUf);
		this.setUf(Util.getUf(fechaUf)); // Recibo Fecha , busco la Uf y la almaceno 

		//Guardar el 10% , Retiro
		this.setDxc(Util.getDxc(ahorro,sueldo,uf)); // Ocupo la UF

		//int retiro = this.getDxc(); // Con esto se duplicaba el metodo del profe ( getDxc ), asi que refactorice y corregi con la linea anterior
		//la variable dxc es el retiro asi que la volvi a agregar y comente esta parte que hiciste y abajo coloque la versión modificada
		//this.setImpuesto(Util.getImpuesto(sueldo, retiro));
		//this.setSaldo(this.getAhorro() - retiro);

		this.setImpuesto(Util.getImpuesto(sueldo, dxc));
		this.setSaldo(this.getAhorro() - this.getDxc()); 
	}

	public Dxc() {
	}

	public int getDxc() {
		return dxc;
	}

	public void setDxc(int dxc) {
		this.dxc = dxc;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	public int getAhorro() {
		return ahorro;
	}

	public void setAhorro(int ahorro) {
		this.ahorro = ahorro;
	}

	public double getUf() {
		return uf;
	}

	public void setUf(double uf) {
		this.uf = uf;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public int getSaldo(){
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getFechaUf() {
		return fechaUf;
	}

	public void setFechaUf(String fechaUf) {
		this.fechaUf = fechaUf;
	}

}
