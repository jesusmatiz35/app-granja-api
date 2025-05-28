
package com.cosoftia.granja.repositories;

import org.springframework.data.repository.CrudRepository;
import com.cosoftia.granja.entities.Vaccination;

public interface VaccinationRepository extends CrudRepository<Vaccination, Integer> {
}