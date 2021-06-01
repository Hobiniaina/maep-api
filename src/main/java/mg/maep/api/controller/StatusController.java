package mg.maep.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.maep.api.services.StatusServices;

@RestController
@CrossOrigin
@RequestMapping("/api/status")
public class StatusController {

	@Autowired
	StatusServices services;

	

	
}
