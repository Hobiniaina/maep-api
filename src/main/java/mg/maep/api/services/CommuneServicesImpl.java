package mg.maep.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.maep.api.models.Commune;
import mg.maep.api.repository.CommuneRepository;

@Service
public class CommuneServicesImpl implements CommuneServices {

	@Autowired
	CommuneRepository repository;

	@Override
	public Commune save(Commune entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commune> listeAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commune getById(int id) {
		// TODO Auto-generated method stub
		return repository.findByIdCommune(id);
	}

	@Override
	public List<Commune> listeAllPagination(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commune delete(Commune entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntity(Commune entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int nombrePage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
