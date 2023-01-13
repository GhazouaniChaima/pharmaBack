package com.pharmatunisie.pharmatunisie.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmatunisie.pharmatunisie.dto.MedicamentDto;
import com.pharmatunisie.pharmatunisie.service.Imedicament;
import com.pharmatunisie.pharmatunisie.entity.MedicamentEntity;
import java.util.List;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/Medicament")
public class MedicamentController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MedicamentController.class);
	
	@Autowired
	private ModelMapper modelMapper;
	private Imedicament imedicament;

	public MedicamentController(Imedicament imedicament) {
		super();
		this.imedicament = imedicament;
	}

	@GetMapping
	public List<MedicamentDto> getAllMedicament() {
		
		return imedicament.getAllMedicament().stream().map(medicament -> modelMapper.map(medicament, MedicamentDto.class))
				.collect(Collectors.toList());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<MedicamentDto> getMedicamentById(@PathVariable(name = "id") int id) {
		MedicamentEntity medicament = imedicament.getMedicamentById(id);

		// convert entity to DTO
		MedicamentDto medicamentResponse = modelMapper.map(medicament, MedicamentDto.class);

		//return ResponseEntity.ok().body(medicamentResponse);
		return new ResponseEntity<MedicamentDto>(medicamentResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<MedicamentDto> createMedicament(@RequestBody MedicamentDto medicamentDto) {

		// convert DTO to entity
		try {
			LOGGER.info("createMedicament IN ..");
		//MedicamentEntity medicamentRequest = modelMapper.map(medicamentDto, MedicamentEntity.class);
		MedicamentEntity medicament = new MedicamentEntity(medicamentDto.getNom_commercial(), medicamentDto.getDci(), medicamentDto.getDossage(), medicamentDto.getNbre_stock(), medicamentDto.getPrix(), medicamentDto.getPresentaion());
		LOGGER.info("medicamentRequest .. "+medicamentDto.getPresentaion());
		MedicamentEntity _medicament = imedicament.createMedicament(medicament);

		// convert entity to DTO
		MedicamentDto medicamentResponse = modelMapper.map(medicament, MedicamentDto.class);
		LOGGER.info("medicamentResponse .. "+medicamentResponse.toString());
		return new ResponseEntity<MedicamentDto>(medicamentResponse, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			LOGGER.error("Exception was raised..");
			return null;
		}
	}

	// change the request for DTO
	// change the response for DTO
	@PutMapping("/{id}")
	public ResponseEntity<MedicamentDto> updateMedicament(@PathVariable int id, @RequestBody MedicamentDto medicamentDto) {

		// convert DTO to Entity
		MedicamentEntity medicamentRequest = modelMapper.map(medicamentDto, MedicamentEntity.class);

		MedicamentEntity medicament = imedicament.updateMedicament(id, medicamentRequest);

		// entity to DTO
		MedicamentDto medicamentResponse = modelMapper.map(medicament, MedicamentDto.class);

		return ResponseEntity.ok().body(medicamentResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteMedicament(@PathVariable(name = "id") int id) {
		try {
		imedicament.deleteMedicament(id);
		//ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "zone deleted successfully", HttpStatus.OK);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
