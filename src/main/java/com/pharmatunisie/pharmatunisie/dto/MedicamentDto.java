package com.pharmatunisie.pharmatunisie.dto;

public class MedicamentDto {
	
	private int id_med;
    private String nom_commercial;
    private String dci;
    private String dossage;
    private int nbre_stock;
    private float prix;
    private String presentaion;
    
	public int getId_med() {
		return id_med;
	}
	public void setId_med(int id_med) {
		this.id_med = id_med;
	}
	public String getNom_commercial() {
		return nom_commercial;
	}
	public void setNom_commercial(String nom_commercial) {
		this.nom_commercial = nom_commercial;
	}
	public String getDci() {
		return dci;
	}
	public void setDci(String dci) {
		this.dci = dci;
	}
	public String getDossage() {
		return dossage;
	}
	public void setDossage(String dossage) {
		this.dossage = dossage;
	}
	public int getNbre_stock() {
		return nbre_stock;
	}
	public void setNbre_stock(int nbre_stock) {
		this.nbre_stock = nbre_stock;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getPresentaion() {
		return presentaion;
	}
	public void setPresentaion(String presentaion) {
		this.presentaion = presentaion;
	}
	public MedicamentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicamentDto(int id_med, String nom_commercial, String dci, String dossage, int nbre_stock, float prix,
			String presentaion) {
		super();
		this.id_med = id_med;
		this.nom_commercial = nom_commercial;
		this.dci = dci;
		this.dossage = dossage;
		this.nbre_stock = nbre_stock;
		this.prix = prix;
		this.presentaion = presentaion;
	}
	@Override
	public String toString() {
		return "MedicamentDto [id_med=" + id_med + ", nom_commercial=" + nom_commercial + ", dci=" + dci + ", dossage="
				+ dossage + ", nbre_stock=" + nbre_stock + ", prix=" + prix + ", presentaion=" + presentaion + "]";
	}
    
    
}
