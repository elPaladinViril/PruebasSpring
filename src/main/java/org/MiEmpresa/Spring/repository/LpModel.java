package org.MiEmpresa.Spring.repository;

import org.MiEmpresa.Spring.domain.Lp;
import org.springframework.data.repository.CrudRepository;

public interface LpModel extends CrudRepository<Lp, Long> {
	public Lp findByNombre(String nombre);
	public Lp findById(Long id);
}
