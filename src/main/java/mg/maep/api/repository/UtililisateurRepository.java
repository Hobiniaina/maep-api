package mg.maep.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.maep.api.models.Utilisateur;

public interface UtililisateurRepository extends JpaRepository<Utilisateur, String> {

	@Query(value = "select nextval('\"public\".seq_user')", nativeQuery = true)
	int seqUser();

	@Query(value = "select u from Utilisateur u where u.individu.matricule = ?1")
	Utilisateur findByMatricule(String matricule);
	
	@Query(value = "select u from Utilisateur u where u.individu.matricule = ?1")
	Optional<Utilisateur> findByMatriculeIndiv(String matricule);
	
	@Query("select case when (count(u) > 0) then true else false end from Utilisateur u where u.individu.matricule = ?1")
	boolean existMatricule(String matricule);
}
