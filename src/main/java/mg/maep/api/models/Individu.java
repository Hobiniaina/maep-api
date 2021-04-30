package mg.maep.api.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "utilisateur_status", joinColumns = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name = "id_status"))
	private Set<Status> roles = new HashSet<>();

	@Column(name = "national")
	private String national;

	@ManyToOne
	@JoinColumn(name = "id_secteur")
	private SecteurActivite secteurActivite;

	@ManyToOne
	@JoinColumn(name = "id_mdp")
	private ModePaiement modePaiement;

	@ManyToOne
	@JoinColumn(name = "code_adr")
	private Adresse adresse;

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

	public Set<Status> getRoles() {
		return roles;
	}

	public void setRoles(Set<Status> roles) {
		this.roles = roles;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
