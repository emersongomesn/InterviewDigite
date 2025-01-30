package com.digte.interview.digteinterview.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digte.interview.digteinterview.DTO.EmployeeDTO;
import com.digte.interview.digteinterview.entities.Employee;
import com.digte.interview.digteinterview.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll(){
		List<EmployeeDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
				
	}

	
	//@GetMapping(value = "/{id}")
	//public Employee findById(@PathVariable Long id) {
		//Employee result = repository.findById(id).get();
		//return result;
	//}

	//@PostMapping
	//public Employee insert(@RequestBody Employee employee) {
		//Employee result = repository.save(employee);
		//return result;
	//}

}
