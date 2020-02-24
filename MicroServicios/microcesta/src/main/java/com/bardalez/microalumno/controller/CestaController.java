package com.bardalez.microalumno.controller;

//import java.net.URI;
import com.bardalez.microalumno.client.EurekaClient;
import com.bardalez.microalumno.model.Curso;
import com.bardalez.microalumno.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bardalez.microalumno.model.Alumno;

@RestController
@CrossOrigin(origins = "*")
public class CestaController {

	@Autowired
	private EurekaClient eureka;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@RequestMapping(value = "/curso/{unidades}", method = RequestMethod.POST)
	public void addProductoCesta(@RequestBody Alumno prod, @PathVariable Integer unidades)
	{
		Alumno alumnoTemp = new Alumno();
		alumnoTemp.setNombreAlumno(prod.getNombreAlumno());
		alumnoTemp.setDni(prod.getDni());
		alumnoTemp.setPrecioporCurso(prod.getPrecioporCurso());
		alumnoTemp.setUnidades(unidades);



		
		alumnoTemp.setUsername("Jhonatan"); //lo debo traer del microservicio login

		alumnoTemp.setPrecioTotal(prod.getPrecioporCurso()*unidades);
		
		alumnoRepository.save(alumnoTemp);
		
	}
	

	@GetMapping("/curso/{codigo}")
	public Curso getProducto(@PathVariable String codigo)
	{
		//URI catalogoURI = eureka.getUri("SERVICIO.CATALOGO");
		//Producto prod = restTemplate.getForObject(catalogoURI.resolve("/producto/"+codigo), Producto.class);
		Curso prod = restTemplate.getForObject("http://SERVICIO.CURSO/curso/"+codigo, Curso.class);
		return prod;
	}
	
	private Curso fallbackMethod(String codigo) {
		return new Curso("0","Articulo de prueba","prueba",1, 38.5, "dasdasd","123");
	}
	
}
