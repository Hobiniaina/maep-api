package mg.maep.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.maep.api.config.JwtResponse;
import mg.maep.api.config.JwtUtils;
import mg.maep.api.config.UserDetailsImpl;
import mg.maep.api.models.ApiResponse;
import mg.maep.api.models.LoginUser;
import mg.maep.api.models.Utilisateur;
import mg.maep.api.repository.UtililisateurRepository;
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

	@PostMapping("/connecter")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginUser loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getMatricule(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, "", userDetails.getUsername(), roles));
	}

	@PostMapping(value = "/inscrire")
	public ApiResponse<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		try {
			Utilisateur user = new Utilisateur();
			utilisateur.setPassword(encoder.encode(utilisateur.getPassword()));
			user = services.save(utilisateur);
			return new ApiResponse<>(200, "success", user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ApiResponse<>(500, "Erreur d'inscription", "No Result");
		}

	}

}
