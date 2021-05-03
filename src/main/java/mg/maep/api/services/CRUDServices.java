package mg.maep.api.services;

import java.util.List;

public interface CRUDServices<E> {

	E save(E entity);

	List<E> listeAll();

	E getById(int id);

	List<E> listeAllPagination(int page);

	E delete(E entity);

	void deleteEntity(E entity);

	int nombrePage();

}
