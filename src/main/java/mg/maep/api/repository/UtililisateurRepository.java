package mg.maep.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.maep.api.models.Utilisateur;

public interface UtililisateurRepository extends JpaRepository<Utilisateur, String> {

	@Query(value = "select u from Utilisateur u where u.individu.matricule = ?1")
	Utilisateur findByMatricule(String matricule);
}
