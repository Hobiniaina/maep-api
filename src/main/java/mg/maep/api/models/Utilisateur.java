package mg.maep.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	@Id
	@Column(name = "id_utilisateur")
	private String idUtilisateur;

	@ManyToOne
	@JoinColumn(name = "matricule")
	private Individu individu;

	@Column(name = "mot_de_passe")
	private String password;

	public Utilisateur() {
		super();
	}

	public Individu getIndividu() {
		return individu;
	}

	public void setIndividu(Individu individu) {
		this.individu = individu;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
