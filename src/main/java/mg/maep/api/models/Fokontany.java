package mg.maep.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fokontany")
public class Fokontany implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_fokontany")
	private int idFokontany;
	@Column(name = "nom_fokontany")
	private String nomFokontany;
	@ManyToOne
	@JoinColumn(name = "idCommune")
	private Commune commune;

	public Fokontany() {
		super();
	}

	public int getIdFokontany() {
		return idFokontany;
	}

	public void setIdFokontany(int idFokontany) {
		this.idFokontany = idFokontany;
	}

	public String getNomFokontany() {
		return nomFokontany;
	}

	public void setNomFokontany(String nomFokontany) {
		this.nomFokontany = nomFokontany;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
