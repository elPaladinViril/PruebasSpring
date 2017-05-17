package org.MiEmpresa.Spring.controller;


import java.util.Collection;
import java.util.List;

import org.MiEmpresa.Spring.domain.Ciudad;
import org.MiEmpresa.Spring.domain.Empleado;
import org.MiEmpresa.Spring.repository.CiudadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/CrudEmple/ciudad")
public class CiudadController {
	
	@Autowired CiudadModel ciudadModel;
		
	@PostMapping("/crearPost")
	public String crearPost(@RequestParam String nombre, ModelMap model){
		
		String redireccion = "";		
		
		if (nombre!=null){
			Ciudad ciudad = new Ciudad ();
			ciudad.setNombre(nombre);
			ciudadModel.save(ciudad);
			model.addAttribute("nombreCiudad", nombre);
			redireccion = "ciudad/crearPost";
		}
		else {
			model.addAttribute("error", nombre);
			redireccion = "error/errorCiudad";
		}		
		
		return redireccion;
	}
	
	@GetMapping("/listar")
	public List<Ciudad> listarGet(){
		return (List<Ciudad>)ciudadModel.findAll();
	}
	
	@PostMapping("/borrarPost")
	public String borrarPost(@RequestParam Long id, ModelMap model){
			
		Ciudad ciudad = ciudadModel.findById(id);		
		ciudadModel.delete(ciudad);
		model.addAttribute("nombreCiudad", ciudad.getNombre());
		return "ciudad/borrarPost";
	}
	
	@PostMapping("/modificarPost")
	public String modificarPost(@RequestParam Long id, @RequestParam String nombre, @RequestParam Collection<Empleado> empleados, ModelMap model){
			
		Ciudad ciudad = ciudadModel.findById(id);
		ciudad.setEmpleados(empleados);
		ciudad.setNombre(nombre);
		ciudadModel.save(ciudad);
		model.addAttribute("nombreCiudad", ciudad.getNombre());
		return "ciudad/modificarPost";
	}
	
	

}
