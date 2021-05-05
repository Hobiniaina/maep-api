package mg.maep.api.models;

public class AuthToken {

	private String matricule;
	private String token;

	public AuthToken() {
		super();
	}

	public AuthToken(String matricule, String token) {
		super();
		this.matricule = matricule;
		this.token = token;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
