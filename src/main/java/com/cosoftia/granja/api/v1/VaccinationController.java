
package com.cosoftia.granja.api.v1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cosoftia.granja.dto.VaccinationDTO;
import com.cosoftia.granja.services.VaccinationService;

import jakarta.validation.Valid;

/**
 * REST controller for managing vaccinations.
 */
@RestController
@RequestMapping(path = "/v1/vaccinations")
public class VaccinationController {

	@Autowired
	private VaccinationService vaccinationService;

	/**
	 * Retrieves a list of all vaccinations.
	 *
	 * @return a list of VaccinationDTO objects
	 */
	@GetMapping
	public List<VaccinationDTO> getAllVaccinations() {
		return vaccinationService.findAll();
	}

	/**
	 * Retrieves a vaccination by its ID.
	 *
	 * @param id the ID of the vaccination to retrieve
	 * @return a ResponseEntity containing the VaccinationDTO if found, or a 404 Not
	 *         Found status if not
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<VaccinationDTO> getVaccinationById(@PathVariable int id) {
		return ResponseEntity.ok(vaccinationService.findById(id));
	}

	/**
	 * Creates a new vaccination.
	 *
	 * @param vaccinationDTO the vaccination data to create
	 * @return the created VaccinationDTO
	 */
	@PostMapping
	public ResponseEntity<VaccinationDTO> createVaccination(@Valid @RequestBody VaccinationDTO vaccinationDTO) {
		return ResponseEntity.ok(vaccinationService.save(vaccinationDTO));
	}

	/**
	 * Deletes a vaccination by its ID.
	 *
	 * @param id the ID of the vaccination to delete
	 * @return a ResponseEntity with no content
	 */
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteVaccination(@PathVariable int id) {
		vaccinationService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
