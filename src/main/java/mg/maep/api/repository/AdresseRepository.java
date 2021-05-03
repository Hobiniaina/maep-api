package mg.maep.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.maep.api.models.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

	Adresse findByCodeAdresse(int code);
}
