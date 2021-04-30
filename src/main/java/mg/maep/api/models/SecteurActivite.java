package mg.maep.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "secteur_activite")
public class SecteurActivite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_secteur")
	private int idSecteur;
	
	@Column(name = "libelle_secteur")
	private String libelle;
	
	public SecteurActivite() {
		super();
	}

	public int getIdSecteur() {
		return idSecteur;
	}

	public void setIdSecteur(int idSecteur) {
		this.idSecteur = idSecteur;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
