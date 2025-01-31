package com.digte.interview.digteinterview.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.digte.interview.digteinterview.DTO.EmployeeDTO;
import com.digte.interview.digteinterview.entities.Employee;
import com.digte.interview.digteinterview.repositories.EmployeeRepository;
import com.digte.interview.digteinterview.services.exceptions.DataBaseException;
import com.digte.interview.digteinterview.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll() {
		List<Employee> list = repository.findAll();
		return list.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) {
		Optional<Employee> obj = repository.findById(id);
		Employee entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not Found"));
		return new EmployeeDTO(entity);
	}

	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setEmail(dto.getEmail());
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}

	@Transactional
	public EmployeeDTO update(Long id, EmployeeDTO dto) {
		try {
			Employee entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new EmployeeDTO(entity);
		
	}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Not Found" + id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Resource not found");
		}
		try {
	        	repository.deleteById(id);    		
		}
	    	catch (DataIntegrityViolationException e) {
	        	throw new DataBaseException("Referential integrity failure");
	   	}
	}

}
