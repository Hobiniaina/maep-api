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
@Table(name = "adresse")
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_adr")
	private int codeAdresse;

	@Column(name = "code_postal")
	private String codePostal;

	@ManyToOne
	@JoinColumn(name = "fokontany")
	private Fokontany fokontany;

	@ManyToOne
	@JoinColumn(name = "commune")
	private Commune commune;

	@ManyToOne
	@JoinColumn(name = "district")
	private District district;

	@ManyToOne
	@JoinColumn(name = "region")
	private Region region;

	@ManyToOne
	@JoinColumn(name = "province")
	private Province province;

	public Adresse() {
		super();
	}

	public int getCodeAdresse() {
		return codeAdresse;
	}

	public void setCodeAdresse(int codeAdresse) {
		this.codeAdresse = codeAdresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Fokontany getFokontany() {
		return fokontany;
	}

	public void setFokontany(Fokontany fokontany) {
		this.fokontany = fokontany;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}
