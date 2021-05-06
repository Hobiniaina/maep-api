package mg.maep.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.maep.api.models.ApiResponse;
import mg.maep.api.models.Utilisateur;
import mg.maep.api.services.UtilisateurServices;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UtilisateurControlleur {

	@Autowired
	UtilisateurServices services;

	@PostMapping(value = "/saveUtilisateur")
	public ApiResponse<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		try {
			Utilisateur user = services.save(utilisateur);
			return new ApiResponse<>(200, "success", user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ApiResponse<>(500, "Erreur", "No Result");
		}

	}

	@GetMapping(value = "/listeUtilisateur/{page}")
	public ApiResponse<Utilisateur> listeUtilisateur(@PathVariable int page) {
		try {
			List<Utilisateur> list = services.listeAllPagination(page);
			return new ApiResponse<>(200, "Liste Affichée", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ApiResponse<>(500, "Erreur", "No Result");
		}
	}
}
