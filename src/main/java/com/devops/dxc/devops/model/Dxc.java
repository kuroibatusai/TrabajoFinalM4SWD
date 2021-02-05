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
	
	private int saldo;
	private double impuesto;
	private int sueldo;
	private int ahorro;
	private double uf;

	public Dxc(int ahorro, int sueldo, double uf){
		this.setAhorro(ahorro);
		this.setSueldo(sueldo);
		this.setUf(uf);
		int retiro = this.getDxc();
		this.setImpuesto(Util.getImpuesto(sueldo, retiro));
		this.setSaldo(this.getAhorro() - retiro);
	}

	public Dxc() {
		this.setUf(Util.getUf());
	}

	public int getDxc() {
		return Util.getDxc(ahorro,sueldo,this.getUf());
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

}
