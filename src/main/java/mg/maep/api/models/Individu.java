package mg.maep.api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "individu")
public class Individu {

	@Id
	@Column(name = "matricule")
	private String matricule;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "contact")
	private String contact;

	@Column(name = "mail")
	private String mail;

	@Column(name = "lieu_naissance")
	private String lieuNaiss;

	@Column(name = "date_naissance")
	private Date dateNaiss;

	@Column(name = "cin")
	private String cin;

	@Column(name = "sexe")
	private String sexe;

	@ManyToOne
	@JoinColumn(name = "idStatus")
	private Status status;

	@Column(name = "national")
	private String national;

	@ManyToOne
	@JoinColumn(name = "id_secteur")
	private SecteurActivite secteurActivite;

	@ManyToOne
	@JoinColumn(name = "id_mdp")
	private ModePaiement modePaiement;

	@ManyToOne
	@JoinColumn(name = "fokontany")
	private Fokontany fokontany;

	@ManyToOne
	@JoinColumn(name = "commune")
	private Commune commune;

	@ManyToOne
	@JoinColumn(name = "district")
	private District district;

	@ManyToOne
	@JoinColumn(name = "region")
	private Region region;

	@ManyToOne
	@JoinColumn(name = "province")
	private Province province;

	@ManyToOne
	@JoinColumn(name = "idImage")
	private ImgIndividu imgIndividu;

	public Individu() {
		super();
	}

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

	public SecteurActivite getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(SecteurActivite secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	public Fokontany getFokontany() {
		return fokontany;
	}

	public void setFokontany(Fokontany fokontany) {
		this.fokontany = fokontany;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public ImgIndividu getImgIndividu() {
		return imgIndividu;
	}

	public void setImgIndividu(ImgIndividu imgIndividu) {
		this.imgIndividu = imgIndividu;
	}

}
