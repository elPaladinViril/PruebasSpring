package org.MiEmpresa.Spring.repository;

import org.MiEmpresa.Spring.domain.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoModel extends CrudRepository<Empleado, Long> {
	public Empleado findById(Long id);
}
