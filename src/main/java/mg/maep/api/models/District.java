package mg.maep.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class District implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_district")
	private int idDistrict;
	@Column(name = "nom_district")
	private String nomDistrict;
	@ManyToOne
	@JoinColumn(name = "idRegion")
	private Region region;

	public District() {
		super();
	}

	public int getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(int idDistrict) {
		this.idDistrict = idDistrict;
	}

	public String getNomDistrict() {
		return nomDistrict;
	}

	public void setNomDistrict(String nomDistrict) {
		this.nomDistrict = nomDistrict;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
