package mg.maep.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
