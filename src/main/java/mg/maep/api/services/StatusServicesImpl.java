package mg.maep.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.maep.api.models.Status;
import mg.maep.api.repository.StatusRepository;

@Service
public class StatusServicesImpl implements StatusServices {

	@Autowired
	StatusRepository repository;

	@Override
	public Status save(Status entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Status> listeAll() {
		// TODO Auto-generated method stub
		List<Status> list = repository.findAll();
		return list;
	}

	@Override
	public Status getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Status> listeAllPagination(int page) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Status delete(Status entity) {
		return null;
	}

	@Override
	public void deleteEntity(Status entity) {
		// TODO Auto-generated method stub
		repository.deleteById(entity.getIdStatus());
	}

	@Override
	public int nombrePage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
