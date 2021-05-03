package mg.maep.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.maep.api.models.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

	Status findByIdStatus(int id);
}
