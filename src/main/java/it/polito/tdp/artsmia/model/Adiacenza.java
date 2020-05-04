package it.polito.tdp.artsmia.model;

public class Adiacenza {
	private int obj1;
	private int obj2;
	private int peso;
	
	
	
	/**
	 * @param obj1
	 * @param obj2
	 * @param peso
	 */
	public Adiacenza(int obj1, int obj2, int peso) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.peso = peso;
	}
	/**
	 * @return the obj1
	 */
	public int getObj1() {
		return obj1;
	}
	/**
	 * @param obj1 the obj1 to set
	 */
	public void setObj1(int obj1) {
		this.obj1 = obj1;
	}
	/**
	 * @return the obj2
	 */
	public int getObj2() {
		return obj2;
	}
	/**
	 * @param obj2 the obj2 to set
	 */
	public void setObj2(int obj2) {
		this.obj2 = obj2;
	}
	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	

}
