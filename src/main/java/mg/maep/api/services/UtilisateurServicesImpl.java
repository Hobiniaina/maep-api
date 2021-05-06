package mg.maep.api.services;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mg.maep.api.models.Individu;
import mg.maep.api.models.Utilisateur;
import mg.maep.api.repository.IndividuRepository;
import mg.maep.api.repository.UtililisateurRepository;

@Service(value = "utilisateurServices")
public class UtilisateurServicesImpl implements UserDetailsService, UtilisateurServices {

	@Autowired
	UtililisateurRepository repository;

	@Autowired
	IndividuRepository indRepository;

	int max = 15;

	@Override
	public Utilisateur save(Utilisateur entity) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("ddMMyy");
		Individu individu = entity.getIndividu();
		individu.setMatricule(
				"MAT/" + formater.format(date) + "/" + String.format("%03d", indRepository.seqIndividu()));
		entity.setIdUtilisateur(String.format("%03d", repository.seqUser()));
		indRepository.save(individu);
		entity.setIndividu(individu);
		return repository.save(entity);
	}

	@Override
	public List<Utilisateur> listeAll() {
		// TODO Auto-generated method stub
		List<Utilisateur> list = repository.findAll();
		return list;
	}

	@Override
	public Utilisateur getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> listeAllPagination(int page) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page - 1, max);
		Page<Utilisateur> liste = repository.findAll(pageable);
		return liste.getContent();
	}

	@Override
	public Utilisateur delete(Utilisateur entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntity(Utilisateur entity) {
		// TODO Auto-generated method stub
		repository.delete(entity);
	}

	@Override
	public int nombrePage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Utilisateur findByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return repository.findByMatricule(matricule);
	}

	@Override
	public UserDetails loadUserByUsername(String matricule) throws UsernameNotFoundException {
		Utilisateur user = repository.findByMatricule(matricule);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getIndividu().getMatricule(),
				user.getPassword(), getAuthority());

	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
