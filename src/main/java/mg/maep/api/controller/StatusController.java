package mg.maep.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.maep.api.models.Status;
import mg.maep.api.services.StatusServices;

@RestController
@CrossOrigin
@RequestMapping("/api/maep")
public class StatusController {

	@Autowired
	StatusServices services;

	@PostMapping(value = "/saveStatus")
	public ResponseEntity<Object> enregistreStatus(@Validated @RequestBody Status status) {
		try {
			Status status2 = services.save(status);
			return new ResponseEntity<>(status2, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}
}
