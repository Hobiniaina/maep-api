package mg.maep.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mg.maep.api.models.Individu;
import mg.maep.api.repository.IndividuRepository;

@Service
public class IndividuServicesImpl implements IndividuServices {

	@Autowired
	IndividuRepository repository;
	int max = 15;

	@Override
	public Individu save(Individu entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<Individu> listeAll() {
		// TODO Auto-generated method stub
		List<Individu> list = repository.findAll();
		return list;
	}

	@Override
	public Individu getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Individu> listeAllPagination(int page) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page - 1, max);
		Page<Individu> liste = repository.findAll(pageable);
		return liste.getContent();
	}

	@Override
	public Individu delete(Individu entity) {
		// TODO Auto-generated method stub
		Individu individu = repository.getOne(entity.getMatricule());
		if (individu.getMatricule() != null) {
			repository.delete(individu);
		}
		return individu;
	}

	@Override
	public void deleteEntity(Individu entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int nombrePage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
