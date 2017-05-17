package org.MiEmpresa.Spring.controller;

import java.util.Collection;
import java.util.List;

import org.MiEmpresa.Spring.domain.Ciudad;
import org.MiEmpresa.Spring.domain.Empleado;
import org.MiEmpresa.Spring.domain.Lp;
import org.MiEmpresa.Spring.repository.LpModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping ("/CrudEmple/Lp")
public class LpController {	
	
		@Autowired LpModel lpModel;
			
		@PostMapping("/crearPost")
		public String crearPost(@RequestParam String nombre, ModelMap model){
			
			String redireccion = "";		
			
			if (nombre!=null){
				Lp lp = new Lp ();
				lp.setNombre(nombre);
				lpModel.save(lp);
				model.addAttribute("nombreLp", nombre);
				redireccion = "lp/crearPost";
			}
			else {
				model.addAttribute("error", nombre);
				redireccion = "error/errorLp";
			}		
			
			return redireccion;
		}
		
		@GetMapping("/listar")
		public List<Lp> listarGet(){
			return (List<Lp>)lpModel.findAll();
		}
		
		@PostMapping("/borrarPost")
		public String borrarPost(@RequestParam Long id, ModelMap model){
				
			Lp lp = lpModel.findById(id);		
			lpModel.delete(lp);
			model.addAttribute("nombreLp", lp.getNombre());
			return "lp/borrarPost";
		}
		
		@PostMapping("/modificarPost")
		public String modificarPost(@RequestParam Long id, @RequestParam String nombre, @RequestParam Collection<Empleado> empleados, ModelMap model){				
			Lp lp = lpModel.findById(id);
			lp.setEmpleados(empleados);
			lp.setNombre(nombre);
			lpModel.save(lp);
			model.addAttribute("nombreLp", lp.getNombre());
			return "lp/modificarPost";
		}
		
		

	}
