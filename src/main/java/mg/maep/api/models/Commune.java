package mg.maep.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commune")
public class Commune implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_commune")
	private int idCommune;
	@Column(name = "nom_commune")
	private String nomCommune;
	@ManyToOne
	@JoinColumn(name = "idDistrict")
	private District district;

	public Commune() {
		super();
	}

	public int getIdCommune() {
		return idCommune;
	}

	public void setIdCommune(int idCommune) {
		this.idCommune = idCommune;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
