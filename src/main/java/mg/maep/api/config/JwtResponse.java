package mg.maep.api.config;

import java.util.List;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String matricule;
	private List<String> status;

	public JwtResponse(String token, String type, String matricule, List<String> status) {
		super();
		this.token = token;
		this.type = type;
		this.matricule = matricule;
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

}
