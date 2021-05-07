package mg.maep.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mg.maep.api.models.Adresse;
import mg.maep.api.repository.AdresseRepository;

@Service
public class AdresseServicesImpl implements AdresseServices {

	@Autowired
	AdresseRepository repository;
	int max = 15;

	@Override
	public Adresse save(Adresse entity) {
		return repository.save(entity);
	}

	@Override
	public List<Adresse> listeAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Adresse getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Adresse> listeAllPagination(int page) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page - 1, max);
		Page<Adresse> list = repository.findAll(pageable);
		return list.getContent();
	}

	@Override
	public Adresse delete(Adresse entity) {
		Adresse adresse = repository.findByCodeAdresse(entity.getCodeAdresse());
		if (adresse.getCodeAdresse() != 0) {
			repository.delete(adresse);
		}
		return adresse;
	}

	@Override
	public void deleteEntity(Adresse entity) {
		repository.deleteById(entity.getCodeAdresse());

	}

	@Override
	public int nombrePage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
