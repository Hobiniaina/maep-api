package mg.maep.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mode_paiement")
public class ModePaiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mdp")
	private int idModePaiement;

	@Column(name = "banque")
	private String banque;

	@ManyToOne
	@JoinColumn(name = "id_type_mdp")
	private TypeModePaiement typeModePaiement;

	public ModePaiement() {
		super();
	}

	public int getIdModePaiement() {
		return idModePaiement;
	}

	public void setIdModePaiement(int idModePaiement) {
		this.idModePaiement = idModePaiement;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public TypeModePaiement getTypeModePaiement() {
		return typeModePaiement;
	}

	public void setTypeModePaiement(TypeModePaiement typeModePaiement) {
		this.typeModePaiement = typeModePaiement;
	}

}
