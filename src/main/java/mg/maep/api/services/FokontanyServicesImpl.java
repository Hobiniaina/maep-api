package mg.maep.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.maep.api.models.Fokontany;
import mg.maep.api.repository.FokontanyRepository;

@Service
public class FokontanyServicesImpl implements FokontanyServices {

	@Autowired
	FokontanyRepository repository;

	@Override
	public Fokontany save(Fokontany entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fokontany> listeAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Fokontany getById(int id) {
		// TODO Auto-generated method stub
		return repository.findByIdFokontany(id);
	}

	@Override
	public List<Fokontany> listeAllPagination(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fokontany delete(Fokontany entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntity(Fokontany entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int nombrePage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> prendListeFokontany() {
		// TODO Auto-generated method stub
		return repository.prendListeFokontany();
	}

}
