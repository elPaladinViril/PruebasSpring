package org.MiEmpresa.Spring.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Empleado {
		
	private Long id;
	private String nombre;
	private String apellidos;
	private Collection<Lp>lps;
	private Ciudad ciudad;
	
	public Empleado() {
		super();	
	}

	public Empleado(String nombre, String apellidos, Collection<Lp> lps, Ciudad ciudad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.lps = lps;
		this.ciudad = ciudad;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@ManyToMany
	public Collection<Lp> getLps() {
		return lps;
	}

	public void setLps(Collection<Lp> lps) {
		this.lps = lps;
	}
	
	@ManyToOne
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	
	
	
	
}
