package mg.maep.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class Province implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_province")
	private int idProvince;
	@Column(name = "nom_province")
	private String nomProvince;

	public Province() {
		super();
	}

	public int getIdProvince() {
		return idProvince;
	}

	public void setIdProvince(int idProvince) {
		this.idProvince = idProvince;
	}

	public String getNomProvince() {
		return nomProvince;
	}

	public void setNomProvince(String nomProvince) {
		this.nomProvince = nomProvince;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
