
package com.cosoftia.granja.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cosoftia.granja.dto.VaccinationDTO;
import com.cosoftia.granja.entities.Vaccination;
import com.cosoftia.granja.repositories.VaccinationRepository;

@Service
public class VaccinationService {

	@Autowired
	private VaccinationRepository vaccinationRepository;

	public List<VaccinationDTO> findAll() {
		return ((List<Vaccination>) vaccinationRepository.findAll()).stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public VaccinationDTO findById(int id) {
		return vaccinationRepository.findById(id).map(this::convertToDTO).orElse(null);
	}

	public VaccinationDTO save(VaccinationDTO vaccinationDTO) {
		Vaccination vaccination = convertToEntity(vaccinationDTO);
		return convertToDTO(vaccinationRepository.save(vaccination));
	}

	public void deleteById(int id) {
		vaccinationRepository.deleteById(id);
	}

	private VaccinationDTO convertToDTO(Vaccination vaccination) {
		VaccinationDTO dto = new VaccinationDTO();
		dto.setVaccinationId(vaccination.getVaccinationId());
		dto.setAge(vaccination.getAge());
		dto.setVaccine(vaccination.getVaccine());
		dto.setCepa(vaccination.getCepa());
		dto.setVaccineType(vaccination.getVaccineType());
		dto.setVia(vaccination.getVia());
		return dto;
	}

	private Vaccination convertToEntity(VaccinationDTO dto) {
		Vaccination vaccination = new Vaccination();
		vaccination.setVaccinationId(dto.getVaccinationId());
		vaccination.setAge(dto.getAge());
		vaccination.setVaccine(dto.getVaccine());
		vaccination.setCepa(dto.getCepa());
		vaccination.setVaccineType(dto.getVaccineType());
		vaccination.setVia(dto.getVia());
		return vaccination;
	}
}
