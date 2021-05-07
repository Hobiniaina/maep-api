package mg.maep.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.maep.api.models.SecteurActivite;
import mg.maep.api.services.SecteurActiviteServices;

@RestController
@CrossOrigin
@RequestMapping("/api/secteur")
public class SecteurControlleur {

	@Autowired
	SecteurActiviteServices services;

	@PostMapping(value = "/saveSecteur")
	public ResponseEntity<Object> save(@RequestBody SecteurActivite activite) {
		try {
			activite = services.save(activite);
			return new ResponseEntity<>(activite, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}
}
