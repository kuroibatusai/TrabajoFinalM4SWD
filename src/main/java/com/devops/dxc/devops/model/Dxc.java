package com.devops.dxc.devops.model;

import java.io.Serializable;

public class Dxc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988002029080131424L;
	
	private int dxc;
	private int saldo;
	private double impuesto;
	private int sueldo;
	private int ahorro;
	private double uf;

	public Dxc(int ahorro, int sueldo, double uf){
		this.setAhorro(ahorro);
		this.setSueldo(sueldo);
		this.setUf(uf);
		this.setImpuesto(Util.getImpuesto(sueldo));
		this.setSaldo(this.getAhorro() - (int) this.getImpuesto() - this.getDxc());
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
