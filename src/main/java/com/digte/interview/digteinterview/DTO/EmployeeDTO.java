package com.digte.interview.digteinterview.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.digte.interview.digteinterview.entities.Employee;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String cpf;
	private String email;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Long id, String name, String cpf, String email) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}
	
	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
