package mg.maep.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.maep.api.models.ApiResponse;
import mg.maep.api.models.ModePaiement;
import mg.maep.api.services.ModePaiementServices;

@RequestMapping("/api/paiement")
public class ModePaiementControlleur {

	@Autowired
	ModePaiementServices services;

	@PostMapping(value = "/saveModePaiement")
	public ApiResponse<ModePaiement> save(@RequestBody ModePaiement paiement) {
		try {
			ModePaiement modePaiement = services.save(paiement);
			return new ApiResponse<>(200, "Enregistrement Avec Success", modePaiement);
		} catch (Exception e) {
			return new ApiResponse<>(500, "Erreur pour l'ajout", e);
		}
	}

	@GetMapping(value = "/allModePaiement")
	public ApiResponse<ModePaiement> liste() {
		try {
			List<ModePaiement> modePaiement = services.listeAll();
			return new ApiResponse<>(200, "Enregistrement Avec Success", modePaiement);
		} catch (Exception e) {
			return new ApiResponse<>(500, "Erreur pour l'ajout", e);
		}
	}
}
