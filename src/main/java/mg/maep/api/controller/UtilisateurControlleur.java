package mg.maep.api.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.maep.api.config.JwtResponse;
import mg.maep.api.config.JwtUtils;
import mg.maep.api.config.UserDetailsImpl;
import mg.maep.api.models.Adresse;
import mg.maep.api.models.ApiResponse;
import mg.maep.api.models.Individu;
import mg.maep.api.models.LoginUser;
import mg.maep.api.models.ModePaiement;
import mg.maep.api.models.SecteurActivite;
import mg.maep.api.models.Status;
import mg.maep.api.models.Utilisateur;
import mg.maep.api.repository.IndividuRepository;
import mg.maep.api.repository.StatusRepository;
import mg.maep.api.repository.UtililisateurRepository;
import mg.maep.api.services.AdresseServices;
import mg.maep.api.services.ModePaiementServices;
import mg.maep.api.services.SecteurActiviteServices;
import mg.maep.api.services.StatusServices;
import mg.maep.api.services.UtilisateurServices;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UtilisateurControlleur {

	@Autowired
	UtilisateurServices services;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	UtililisateurRepository repository;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	IndividuRepository indivRepository;

	@Autowired
	StatusServices statusServices;

	@Autowired
	ModePaiementServices mdpservices;

	@Autowired
	SecteurActiviteServices secteurServices;

	@Autowired
	AdresseServices adresseServices;

	@PostMapping("/connecter")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginUser loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getMatricule(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		Individu individu = indivRepository.findByMatricule(loginRequest.getMatricule());
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, "Bearer", userDetails.getUsername(), individu, roles));
	}

	@PostMapping(value = "/inscrire")
	public ApiResponse<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		try {
			Set<Status> roles = new HashSet<>();
			Status status = statusRepository.findByIdStatus(utilisateur.getIndividu().getStatus().getIdStatus());
			roles.add(status);
			Utilisateur user = new Utilisateur();
			utilisateur.setPassword(encoder.encode(utilisateur.getPassword()));
			utilisateur.setRoles(roles);
			user = services.save(utilisateur);
			return new ApiResponse<>(200, "success", user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ApiResponse<>(500, "Erreur pour l'inscription", "No Result");
		}

	}

	@GetMapping(value = "/findAllStatus")
	public ResponseEntity<Object> listeAllStatus() {
		try {
			List<Status> liste = statusServices.listeAll();
			return new ResponseEntity<>(liste, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/saveStatus")
	public ResponseEntity<Object> enregistreStatus(@Validated @RequestBody Status status) {
		try {
			Status status2 = statusServices.save(status);
			return new ResponseEntity<>(status2, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/allModePaiement")
	public ResponseEntity<Object> liste() {
		try {
			List<ModePaiement> modePaiement = mdpservices.listeAll();
			return new ResponseEntity<>(modePaiement, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/allSecteur")
	public ResponseEntity<Object> listeSecteur() {
		try {
			List<SecteurActivite> activite = secteurServices.listeAll();
			return new ResponseEntity<>(activite, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/allAdresse")
	public ResponseEntity<Object> adresseList() {
		try {
			List<Adresse> adresse = adresseServices.listeAll();
			return new ResponseEntity<>(adresse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}
}
