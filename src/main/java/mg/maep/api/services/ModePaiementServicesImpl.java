package mg.maep.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mg.maep.api.models.ModePaiement;
import mg.maep.api.repository.ModePaiementRepository;

@Service
public class ModePaiementServicesImpl implements ModePaiementServices {

	@Autowired
	ModePaiementRepository repository;
	int max = 15;

	@Override
	public ModePaiement save(ModePaiement entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<ModePaiement> listeAll() {
		// TODO Auto-generated method stub
		List<ModePaiement> list = repository.findAll();
		return list;
	}

	@Override
	public ModePaiement getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<ModePaiement> listeAllPagination(int page) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page - 1, max);
		Page<ModePaiement> list = repository.findAll(pageable);
		return list.getContent();
	}

	@Override
	public ModePaiement delete(ModePaiement entity) {
		// TODO Auto-generated method stub
		ModePaiement paiement = repository.findById(entity.getIdModePaiement()).get();
		if (paiement.getIdModePaiement() != 0) {
			repository.delete(paiement);
		}
		return paiement;
	}

	@Override
	public void deleteEntity(ModePaiement entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int nombrePage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
