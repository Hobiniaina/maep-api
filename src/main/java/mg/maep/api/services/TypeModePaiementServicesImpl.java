package mg.maep.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.maep.api.models.TypeModePaiement;
import mg.maep.api.repository.TypeModePaiementRepository;

@Service
public class TypeModePaiementServicesImpl implements TypeModePaiementServices {

	@Autowired
	TypeModePaiementRepository repository;

	@Override
	public TypeModePaiement save(TypeModePaiement entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<TypeModePaiement> listeAll() {
		// TODO Auto-generated method stub
		List<TypeModePaiement> list = repository.findAll();
		return list;
	}

	@Override
	public TypeModePaiement getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<TypeModePaiement> listeAllPagination(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeModePaiement delete(TypeModePaiement entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntity(TypeModePaiement entity) {
		// TODO Auto-generated method stub
		repository.deleteById(entity.getIdTypeMdp());
	}

	@Override
	public int nombrePage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
