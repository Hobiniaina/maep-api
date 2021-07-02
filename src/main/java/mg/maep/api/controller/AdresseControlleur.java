package mg.maep.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.maep.api.models.Commune;
import mg.maep.api.models.Fokontany;
import mg.maep.api.services.CommuneServices;
import mg.maep.api.services.FokontanyServices;

@RestController
@CrossOrigin
@RequestMapping("/api/adresse")
public class AdresseControlleur {

	@Autowired
	FokontanyServices fokontanyServices;

	@Autowired
	CommuneServices communeService;

	@GetMapping(value = "/prendListeFokontany")
	public ResponseEntity<Object> listeFokontany() {
		try {
			List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
			List<Object> liste = fokontanyServices.prendListeFokontany();
			for (int i = 0; i < liste.size(); i++) {
				Object object = liste.get(i);
				Object[] objects = (Object[]) object;
				Map<String, String> map = new HashMap<String, String>();
				map.put("idFokontany", objects[0].toString());
				map.put("nomFokontany", objects[1].toString());
				listMap.add(map);
			}
			return new ResponseEntity<>(listMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/prendCommuneDistrictRegionProvinceByFokontany/{idFokontany}")
	public ResponseEntity<Object> prendCommuneByFokontany(@PathVariable int idFokontany) {
		try {
			Fokontany fokontany = fokontanyServices.getById(idFokontany);
			Commune commune = communeService.getById(fokontany.getCommune().getIdCommune());
			return new ResponseEntity<>(commune, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

}
