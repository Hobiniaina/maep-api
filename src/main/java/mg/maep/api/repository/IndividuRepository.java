package mg.maep.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.maep.api.models.Individu;

public interface IndividuRepository extends JpaRepository<Individu, String> {

	@Query(value = "select nextval('\"public\".seq_individu')", nativeQuery = true)
	int seqIndividu();
}
