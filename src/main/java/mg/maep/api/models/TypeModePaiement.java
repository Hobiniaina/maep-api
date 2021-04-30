package mg.maep.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_mode_paiement")
public class TypeModePaiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_mdp")
	private int idTypeMdp;

	@Column(name = "libelle_mdp")
	private String libelleMdp;

	public TypeModePaiement() {
		super();
	}

	public int getIdTypeMdp() {
		return idTypeMdp;
	}

	public void setIdTypeMdp(int idTypeMdp) {
		this.idTypeMdp = idTypeMdp;
	}

	public String getLibelleMdp() {
		return libelleMdp;
	}

	public void setLibelleMdp(String libelleMdp) {
		this.libelleMdp = libelleMdp;
	}

}
