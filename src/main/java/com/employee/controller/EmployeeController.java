package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.error.EmployeeErrorResponse;
import com.employee.error.EmployeeNotFoundException;
import com.employee.error.InvalidEmploeeIDFormatException;
import com.employee.model.Employee;
import com.employee.model.Skill;
import com.employee.service.EmployeeService;
import com.employee.service.SkillService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController 
{
	
	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	public SkillService skillService;

	/*************************************************EMPLOYEE API**********************************************************/
	
	/*
	 * Get all Perficient employees.
	 * '200': description: Retrieved all Perficient employees.
	 */
	@GetMapping("/employees")
	public List<Employee> findAllEmployees()
	{
		List<Employee> emp = employeeService.findAllEmployees();
		if(emp!=null && !emp.isEmpty())
		{
			return employeeService.findAllEmployees();
		}
		else
		{
			throw new EmployeeNotFoundException("Perficient employees not found");
		}
	}
	
	
	/*
	 * Create a Perficient employee.
	 * '201': description: Created new Perficient employee.
	 * '422': description: Invalid Perficient employee data sent to server.  
	 */
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeService.createEmployee(employee);
	}
	
	
	/*
	 * Find a Perficient employee by ID.
	 * '200': description: Retrieved a Perficient employee.
	 * '400': description: Invalid ID format.
	 * '404': description: Perficient employee not found.
	 */
	@GetMapping("/employees/{employeeId}")
	public Optional<Employee> findEmployeeById(@PathVariable("employeeId") long employeeId)
	{
		Optional<Employee> emp = employeeService.findEmployeeById(employeeId);
		if(emp.isPresent())
		{
			return emp;
		}
		else
		{
			throw new EmployeeNotFoundException("Perficient employee not found");
		}
		
	}
	
	
	/*
	 * Update a Perficient employee by ID.
	 * '200': Employee Object
	 * '400': description: Invalid ID format.
	 * '404': description: Perficient employee not found.
	 * '422': description: Invalid Perficient employee data sent to server.
	 */ 
	@PutMapping("/employees/{employeeId}")
	public Optional<Employee> updateEmployeeById(@PathVariable("employeeId") long employeeId,@RequestBody Employee employee)
	{
		Optional<Employee> emp = employeeService.findEmployeeById(employeeId);
		if(emp.isPresent())
		{
			return employeeService.updateEmployeeById(employeeId,employee);
		}
		else
		{
			throw new EmployeeNotFoundException("Perficient employee not found");
		}
	}
	
	
	/*
	 * Update a Perficient employee by ID.
	 * '204': description: Deleted a Perficient employee.
	 * '400': description: Invalid ID format.
	 * '404': description: Perficient employee not found.
	 */ 
	@DeleteMapping("/employees/{employeeId}")
	public EmployeeErrorResponse removeEmployeeById(@PathVariable("employeeId") long employeeId)
	{
		Optional<Employee> emp = employeeService.findEmployeeById(employeeId);
		if(emp.isPresent())
		{
			employeeService.removeEmployeeById(employeeId);
			EmployeeErrorResponse res = new EmployeeErrorResponse();
			res.setMessage("Deleted a Perficient employee.");
			return res;
		}
		else
		{
			throw new EmployeeNotFoundException("Perficient employee not found");
		}
	}
	
	
	/*************************************************SKILL API**********************************************************/
	
	/*
	 * Get all technical skills from a Perficient employee.
	 * '200': description: Retrieved all technical skills from a Perficient employees.
	 */ 
	@GetMapping("/employees/{employeeId}/skills")
	public List<Skill> findAllSkillsByEmployee(@PathVariable("employeeId") long employeeId)
	{
		Optional<Employee> emp = employeeService.findEmployeeById(employeeId);
		if(emp.isPresent())
		{
			return skillService.findAllSkillsByEmployee(employeeId);
		}
		else
		{
			throw new EmployeeNotFoundException("Perficient employee not found");
		}
	}
	

	/*
	 * Add a technical skill to a Perficient employee.
	 * '201': description: Created new technical skill to a Perficient employee.
	 * '400': description: Invalid ID format.
     * '404': description: Perficient employee not found.
     * '422': description: Invalid technical skill data sent to server.   
	 */ 
	@PostMapping("/employees/{employeeId}/skills")
	public Skill addSkillToEmployee(@PathVariable("employeeId") long employeeId, @RequestBody Skill skill)
	{
		return skillService.addSkillToEmployee(employeeId,skill);
	}
	
	/*
	 * Find a technical skill, from a Perficient employee, by ID
	 * '200': description: Retrieved all technical skills from a Perficient employees.
	 * '400': description: Invalid ID format.
     * '404': description: Perficient employee not found.
	 */ 
	@GetMapping("/employees/{employeeId}/skills/{skillId}")
	public Optional<Skill> findSkillFromEmployeeById(@PathVariable("employeeId") long employeeId, @PathVariable("skillId") long skillId)
	{
		Optional<Employee> emp = employeeService.findEmployeeById(employeeId);
		if(emp.isPresent())
		{
			return skillService.findSkillFromEmployeeById(employeeId,skillId);
		}
		else
		{
			throw new EmployeeNotFoundException("Perficient employee not found");
		}
	}
	
	/*
	 * 'Update a technical skill, from a Perficient employee, by ID.'
	 * '200': description: Retrieved all technical skills from a Perficient employees.
	 * '400': description: Invalid ID format.
     * '404': description: Perficient employee not found.
     * '422': description: Invalid technical skill data sent to server.
	 */ 
	@PutMapping("/employees/{employeeId}/skills/{skillId}")
	public Skill updateSkillFromEmployeeById(@PathVariable("employeeId") long employeeId, @PathVariable("skillId") long skillId,@RequestBody Skill skill)
	{
		Optional<Employee> emp = employeeService.findEmployeeById(employeeId);
		if(emp.isPresent())
		{
			return skillService.updateSkillFromEmployeeById(employeeId,skillId,skill);
		}
		else
		{
			throw new EmployeeNotFoundException("Perficient employee not found");
		}
	}
	
	
	/*
	 * 'Delete a technical skill, from a Perficient employee, by ID.'
	 * '204': description: 'Deleted a technical skill, from a Perficient employee, by ID.'
     * '400': description: Invalid ID format.
     * '404': description: Perficient employee not found.
	 */ 
	@DeleteMapping("/employees/{employeeId}/skills/{skillId}")
	public EmployeeErrorResponse removeSkillFromEmployeeById(@PathVariable("employeeId") String employeeId, @PathVariable("skillId") long skillId)
	{
		try
		{
			Optional<Employee> emp = employeeService.findEmployeeById(Long.valueOf(employeeId));
			if(emp.isPresent())
			{
				skillService.removeSkillFromEmployeeById(Long.valueOf(employeeId),skillId);
				EmployeeErrorResponse res = new EmployeeErrorResponse();
				res.setMessage("Deleted a technical skill, from a Perficient employee, by ID.");
				return res;
			}
			else
			{
				throw new EmployeeNotFoundException("Perficient employee not found");
			}
		}
		catch(Exception e)
		{
			throw new InvalidEmploeeIDFormatException("Invalid ID format.");
		}
	}
	
	
	/****************************************************************************************************************************/
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc)
	{	
		EmployeeErrorResponse error=new EmployeeErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(InvalidEmploeeIDFormatException exc)
	{	
		EmployeeErrorResponse error=new EmployeeErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
