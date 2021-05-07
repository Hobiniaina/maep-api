package mg.maep.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.maep.api.models.Adresse;
import mg.maep.api.models.ApiResponse;
import mg.maep.api.services.AdresseServices;

@RestController
@CrossOrigin
@RequestMapping("/api/adresse")
public class AdresseControlleur {

	@Autowired
	AdresseServices services;

	@PostMapping(value = "/saveAdresse")
	public ApiResponse<Adresse> save(@RequestBody Adresse adresse) {
		try {
			Adresse entity = services.save(adresse);
			return new ApiResponse<>(200, "Enregistrement avec succes", entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ApiResponse<>(200, "Erreur pour Enregistrement", e);
		}
	}
}
