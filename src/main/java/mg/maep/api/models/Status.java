package mg.maep.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_status")
	private int idStatus;

	@Column(name = "libelle_status")
	private String libelleStatus;

	public Status() {
		super();
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getLibelleStatus() {
		return libelleStatus;
	}

	public void setLibelleStatus(String libelleStatus) {
		this.libelleStatus = libelleStatus;
	}

}
