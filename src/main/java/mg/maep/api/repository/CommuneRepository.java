package mg.maep.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.maep.api.models.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Integer> {

	Commune findByIdCommune(int idCommune);

}
