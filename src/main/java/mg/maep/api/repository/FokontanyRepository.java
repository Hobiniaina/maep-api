package mg.maep.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.maep.api.models.Fokontany;

public interface FokontanyRepository extends JpaRepository<Fokontany, Integer> {

	Fokontany findByIdFokontany(int idFokontany);

	@Query(value = "select distinct id_fokontany, nom_fokontany from public.fokontany", nativeQuery = true)
	List<Object> prendListeFokontany();

}
