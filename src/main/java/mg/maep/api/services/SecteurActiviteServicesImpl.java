package mg.maep.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.maep.api.models.SecteurActivite;
import mg.maep.api.repository.SecteurActiviteRepository;

@Service
public class SecteurActiviteServicesImpl implements SecteurActiviteServices {

	@Autowired
	SecteurActiviteRepository repository;

	@Override
	public SecteurActivite save(SecteurActivite entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<SecteurActivite> listeAll() {
		// TODO Auto-generated method stub
		List<SecteurActivite> list = repository.findAll();
		return list;
	}

	@Override
	public SecteurActivite getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<SecteurActivite> listeAllPagination(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecteurActivite delete(SecteurActivite entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntity(SecteurActivite entity) {
		// TODO Auto-generated method stub
		repository.deleteById(entity.getIdSecteur());
	}

	@Override
	public int nombrePage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
