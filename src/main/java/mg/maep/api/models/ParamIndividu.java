package mg.maep.api.models;

import java.util.Date;

public class ParamIndividu {

	private String matricule;
	private String nom;
	private String prenom;
	private String contact;
	private String mail;
	private String lieuNaiss;
	private Date dateNaiss;
	private String cin;
	private String sexe;
	private Status status;
	private String national;
	private String secteurActivite;
	private String modePaiement;
	private String fokontany;
	private String commune;
	private String district;
	private String region;
	private String province;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLieuNaiss() {
		return lieuNaiss;
	}

	public void setLieuNaiss(String lieuNaiss) {
		this.lieuNaiss = lieuNaiss;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public String getFokontany() {
		return fokontany;
	}

	public void setFokontany(String fokontany) {
		this.fokontany = fokontany;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
