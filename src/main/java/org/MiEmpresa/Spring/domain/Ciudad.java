package org.MiEmpresa.Spring.domain;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudad {
	
	private Long id;
	private String nombre;
	private Collection <Empleado> empleados;
	
	public Ciudad() {
		super();		
	}
	
	public Ciudad(String nombre, Collection<Empleado> empleados) {
		super();
		this.nombre = nombre;
		this.empleados = empleados;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@OneToMany(mappedBy = "ciudad")
	public Collection<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Collection<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
	
	
	
	
}
