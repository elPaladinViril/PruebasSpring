package org.MiEmpresa.Spring.controller;

import java.util.Collection;
import java.util.List;

import org.MiEmpresa.Spring.domain.Ciudad;
import org.MiEmpresa.Spring.domain.Empleado;
import org.MiEmpresa.Spring.domain.Lp;
import org.MiEmpresa.Spring.repository.CiudadModel;
import org.MiEmpresa.Spring.repository.EmpleadoModel;
import org.MiEmpresa.Spring.repository.LpModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/CrudEmple/Empleado")
public class EmpleadoController {
				
			@Autowired EmpleadoModel empleadoModel;
			@Autowired CiudadModel ciudadModel;
			@Autowired LpModel lpModel;
			
			@GetMapping("/crear")
			public String crearGet(ModelMap model){
				List<Empleado>empleados = (List<Empleado>) empleadoModel.findAll();
				List<Lp>lps = (List<Lp>) lpModel.findAll();
				List<Ciudad> ciudades = (List<Ciudad>) ciudadModel.findAll();
				model.addAttribute("lps", lps);
				model.addAttribute("ciudades", ciudades);
				model.addAttribute("empleados", empleados);
				return "empleado/crearGet";
			}
				
			@PostMapping("/crearPost")
			public String crearPost(@RequestParam String nombre, @RequestParam String apellidos, @RequestParam Collection<Lp>lps, @RequestParam Ciudad ciudad, ModelMap model){
				
				String redireccion = "";		
				
				if (nombre!=null){
					Empleado empleado = new Empleado ();
					empleado.setNombre(nombre);
					empleado.setApellidos(apellidos);
					empleado.setLps(lps);
					empleado.setCiudad(ciudad);
					empleadoModel.save(empleado);
					model.addAttribute("nombreEmpleado", nombre+" "+apellidos);
					redireccion = "empleado/crearPost";
				}
				else {
					model.addAttribute("error", nombre+" "+apellidos);
					redireccion = "error/errorEmpleado";
				}		
				
				return redireccion;
			}
			
			/*@GetMapping("/listar")
			public List<Empleado> listarGet(){
				return (List<Empleado>)empleadoModel.findAll();
			}*/
			
			@PostMapping("/borrarPost")
			public String borrarPost(@RequestParam Long id, ModelMap model){
					
				Empleado empleado = empleadoModel.findById(id);		
				empleadoModel.delete(empleado);
				model.addAttribute("nombreLp", empleado.getNombre());
				return "lp/borrarPost";
			}
			
			@PostMapping("/modificarPost")
			public String modificarPost(@RequestParam Long id, @RequestParam String nombre, @RequestParam String apellidos, @RequestParam Collection<Lp>lps, @RequestParam Ciudad ciudad, ModelMap model){			
				Empleado empleado = empleadoModel.findById(id);
				empleado.setNombre(nombre);
				empleado.setApellidos(apellidos);
				empleado.setCiudad(ciudad);
				empleado.setLps(lps);				
				empleadoModel.save(empleado);
				model.addAttribute("nombreLp", empleado.getNombre()+" "+empleado.getApellidos());
				return "empleado/modificarPost";
			}			


}
