package mg.maep.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mg.maep.api.models.Utilisateur;
import mg.maep.api.repository.UtililisateurRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UtililisateurRepository repository;

	@Override
	public UserDetails loadUserByUsername(String matricule) throws UsernameNotFoundException {
		Utilisateur user = repository.findByMatriculeIndiv(matricule)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + matricule));

		return UserDetailsImpl.build(user);
	}

}
