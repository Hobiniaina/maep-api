package mg.maep.api.services;

import mg.maep.api.models.Utilisateur;

public interface UtilisateurServices extends CRUDServices<Utilisateur> {

	Utilisateur findByMatricule(String matricule);
}
