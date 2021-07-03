package mg.maep.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.maep.api.models.Individu;

public interface IndividuRepository extends JpaRepository<Individu, String> {

	@Query(value = "select nextval('\"public\".seq_individu')", nativeQuery = true)
	int seqIndividu();

	Individu findByMatricule(String matricule);

	@Query(value = "select * from public.individu where idstatus = ?1", nativeQuery = true)
	Individu prendIndividuByStatus(int idStatus);

}
