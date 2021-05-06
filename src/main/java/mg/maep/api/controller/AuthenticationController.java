package mg.maep.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.maep.api.config.JwtTokenUtil;
import mg.maep.api.models.ApiResponse;
import mg.maep.api.models.AuthToken;
import mg.maep.api.models.LoginUser;
import mg.maep.api.models.Utilisateur;
import mg.maep.api.services.UtilisateurServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	UtilisateurServices services;

	@PostMapping(value = "/connecter")
	public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getMatricule(), loginUser.getPassword()));
		final Utilisateur user = services.findByMatricule(loginUser.getMatricule());
		final String token = jwtTokenUtil.generateToken(user);
		return new ApiResponse<>(200, "Success", new AuthToken(loginUser.getMatricule(), token));
	}
}
