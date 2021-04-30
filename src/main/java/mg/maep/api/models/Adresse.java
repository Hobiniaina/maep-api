package mg.maep.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adresse")
public class Adresse {

	@Id
	@Column(name = "code_adr", length = 50, unique = true)
	private String codeAdresse;

	@Column(name = "lot", length = 100)
	private String lot;

	@Column(name = "code_postal")
	private String codePostal;

	@Column(name = "fokontany")
	private String fokontany;

	@Column(name = "commune")
	private String commune;

	@Column(name = "district")
	private String district;

	@Column(name = "region")
	private String region;

	@Column(name = "province")
	private String province;

	public Adresse() {
		super();
	}

	public String getCodeAdresse() {
		return codeAdresse;
	}

	public void setCodeAdresse(String codeAdresse) {
		this.codeAdresse = codeAdresse;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getFokontany() {
		return fokontany;
	}

	public void setFokontany(String fokontany) {
		this.fokontany = fokontany;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
