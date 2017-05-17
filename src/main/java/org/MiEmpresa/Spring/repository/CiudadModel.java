package org.MiEmpresa.Spring.repository;

import org.MiEmpresa.Spring.domain.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadModel extends CrudRepository<Ciudad, Long> {	
	public Ciudad findByNombre(String nombre);  
	public Ciudad findById(Long id);
}
